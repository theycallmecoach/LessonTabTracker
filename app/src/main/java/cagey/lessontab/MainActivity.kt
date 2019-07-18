package cagey.lessontab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import cagey.lessontab.activities.about.AboutActivity
import cagey.lessontab.fragments.MainFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        actionBar?.setDisplayHomeAsUpEnabled(false)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_main, MainFragment.newInstance(), "studentList")
                .commit()
        }

//        val fab = findViewById<FloatingActionButton>(R.id.add_student_fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

//        viewManager = LinearLayoutManager(this)
//
//        //create some dummy data
//        val input = ArrayList<String>()
//        for ( i in 0..99) {
//            input.add("Student $i")
//        }
//
//        viewAdapter = StudentListAdapter(input)
//
//        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
//            // use this setting to improve performance if you know that changes
//            // in content to not change the layout size of the RecyclerView
//            setHasFixedSize(true)
//
//            // user a linear layout manager
//            layoutManager = viewManager
//
//            // specify a viewAdapter
//            adapter = viewAdapter
//        }
   }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this add items to teh action bar if it is present
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
