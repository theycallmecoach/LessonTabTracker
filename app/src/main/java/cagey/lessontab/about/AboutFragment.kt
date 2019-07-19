package cagey.lessontab.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import cagey.lessontab.R

class AboutFragment : Fragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var versionTextView = view.findViewById(R.id.app_version_text_view) as TextView
        val aboutVersion = getString(R.string.about_version)
        val appVersion = getString(R.string.app_version)
        versionTextView.text = aboutVersion.format(appVersion)
    }

}