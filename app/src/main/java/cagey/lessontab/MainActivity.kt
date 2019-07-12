package cagey.lessontab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.adapters.StudentListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)

        //create some dummy data
        val input = ArrayList<String>()
        for ( i in 0..99) {
            input.add("Student $i")
        }

        viewAdapter = StudentListAdapter(input)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content to not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // user a linear layout manager
            layoutManager = viewManager

            // specify a viewAdapter
            adapter = viewAdapter
        }
    }
}
