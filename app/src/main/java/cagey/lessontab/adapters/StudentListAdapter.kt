package cagey.lessontab.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.R

class StudentListAdapter(private val values: MutableList<String>) : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    // Provide a reference to the view for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the view for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView
    class StudentViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val txtFirstLine = v.findViewById(R.id.firstLine) as TextView
        val txtSecondLine = v.findViewById(R.id.secondLine) as TextView
        val layout = v
    }


    fun add(position: Int, item : String) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int) : StudentListAdapter.StudentViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.txtFirstLine.text = values[position]
        holder.txtSecondLine.text = values[position]
    }

    override fun getItemCount() = values.size

}