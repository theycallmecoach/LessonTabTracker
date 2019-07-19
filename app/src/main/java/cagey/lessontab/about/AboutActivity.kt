package cagey.lessontab.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cagey.lessontab.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.about_container, AboutFragment.newInstance()).commitNow()
        }
    }
}
