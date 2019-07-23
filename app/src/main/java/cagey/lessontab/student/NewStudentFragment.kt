package cagey.lessontab.student

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import cagey.lessontab.R
import kotlinx.android.synthetic.main.fragment_new_student.view.*


class NewStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_student, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button_save)
        button.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(view.textview_firstname.text) || TextUtils.isEmpty(view.textview_lastname.text)) {
                activity?.setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val fName = view.textview_firstname.text.toString()
                val lName = view.textview_lastname.text.toString()
                replyIntent.putExtra(FIRST_NAME, fName)
                replyIntent.putExtra(LAST_NAME, lName)
                activity?.setResult(Activity.RESULT_OK, replyIntent)
            }
        }
    }

    companion object {
         @JvmStatic
        fun newInstance() = NewStudentFragment()

        const val FIRST_NAME = "cagey.student.first_name.REPLY"
        const val LAST_NAME = "cagey.student.last_name.REPLY"
    }
}
