package cagey.lessontab

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.adapters.StudentListAdapter
import cagey.lessontab.views.CageyRecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import cagey.lessontab.student.NewStudentActivity
import cagey.lessontab.student.StudentViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() : MainFragment {
            return MainFragment()
        }
    }

    private lateinit var recyclerView: CageyRecyclerView
    private lateinit var viewAdapter: StudentListAdapter
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ) : View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        student_add_fab.setOnClickListener {
            val intent = Intent(activity, NewStudentActivity::class.java)
            startActivity(intent)
//            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        super.onCreate(savedInstanceState)


        viewAdapter = StudentListAdapter(view.context)
        recyclerView = view.findViewById<CageyRecyclerView>(R.id.student_list_view).apply {
            setEmptyView(view.findViewById(R.id.student_empty_view))
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(this.context)
            adapter = viewAdapter
        }

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentViewModel.allStudents.observe(this, Observer { students -> students?.let { viewAdapter.setStudents(students)} })
    }
}