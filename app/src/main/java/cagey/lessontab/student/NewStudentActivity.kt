package cagey.lessontab.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import cagey.lessontab.R

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.new_student_container, NewStudentFragment.newInstance()).commitNow()
        }
    }
}
