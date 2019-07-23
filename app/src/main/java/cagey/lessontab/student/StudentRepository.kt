package cagey.lessontab.student

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class StudentRepository(private val studentDao: StudentDao) {
  val allStudents: LiveData<List<Student>> = studentDao.getAllStudents()

    @WorkerThread
    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }
}