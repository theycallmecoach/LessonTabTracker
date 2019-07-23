package cagey.lessontab.student

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context.applicationContext, StudentDatabase::class.java, "student_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(StudentDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                instance
            }
        }

        private class StudentDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.studentDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(studentDao: StudentDao) {
            studentDao.deleteAll()

            var student = Student(1, "Billy", "Bob")
            studentDao.insert(student)
        }

    }

}