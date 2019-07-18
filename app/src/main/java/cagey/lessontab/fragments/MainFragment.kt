package cagey.lessontab.fragments

import android.view.View
import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.R
import cagey.lessontab.adapters.StudentListAdapter
import cagey.lessontab.views.CageyRecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() : MainFragment {
            return MainFragment()
        }
    }

    private lateinit var recyclerView: CageyRecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ) : View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        student_add_fab.setOnClickListener { v ->
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val studentList = ArrayList<String>()

        super.onCreate(savedInstanceState)

        viewAdapter = StudentListAdapter(studentList)
        recyclerView = view.findViewById<CageyRecyclerView>(R.id.student_list_view).apply {
            setEmptyView(view.findViewById(R.id.student_empty_view))
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(this.context)
            adapter = viewAdapter
        }
    }
}