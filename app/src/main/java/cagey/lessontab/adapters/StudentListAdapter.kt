package cagey.lessontab.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.R
import cagey.lessontab.student.Student

class StudentListAdapter(context: Context) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var students = emptyList<Student>()


    inner class StudentViewHolder(v: View) : RecyclerView.ViewHolder(v) {
      val txtName = v.findViewById(R.id.student_name) as TextView
    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int) : StudentListAdapter.StudentViewHolder {
        // create a new view
        val view = inflater.inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = students[position]
        holder.txtName.text = current.firstName + " " + current.lastName
    }

    internal fun setStudents(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }

    override fun getItemCount() = students.size
}