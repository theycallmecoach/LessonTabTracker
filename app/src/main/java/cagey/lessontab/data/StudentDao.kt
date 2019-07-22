package cagey.lessontab.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * from students ORDER by first_name ASC")
    fun getAllStudents(): LiveData<List<Student>>

    @Insert
    suspend fun insert(student: Student)

    @Query("DELETE FROM students")
    fun deleteAll()
}