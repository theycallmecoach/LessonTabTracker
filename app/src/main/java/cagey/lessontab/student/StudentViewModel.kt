package cagey.lessontab.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : StudentRepository
    val allStudents : LiveData<List<Student>>

    init {
        val studentDao = StudentDatabase.getDatabase(application, viewModelScope).studentDao()
        repository = StudentRepository(studentDao)
        allStudents = repository.allStudents
    }

    fun insert(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }
}