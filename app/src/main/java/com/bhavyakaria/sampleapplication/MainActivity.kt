package com.bhavyakaria.sampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bhavyakaria.com.sampleapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intents
        intents()

        // toastAndSnackbar
        toastAndSnackbar()

        // dialogs
        dialogs()
    }

    private fun dialogs() {
        btn_open_dialog.setOnClickListener {
            alert("A sample dialog box opened by Anko") {
                yesButton { toast("Selected Yes") }
                noButton { toast("Selected No") }
            }.show()
        }

        // Similarly you can use is it for selector and progress dialog
    }

    private fun intents() {
        // simple intent
        btn_simple_intent.setOnClickListener {
            startActivity<SecondActivity>()
        }

        // intent with flags
        btn_intent_with_flags.setOnClickListener {
            startActivity(intentFor<SecondActivity>("id" to 5).singleTop())
        }

        // intent with data
        btn_intent_with_data.setOnClickListener {
            startActivity<SecondActivity>(
                "id" to 5,
                "city" to "Bombay",
                "state" to "Maharashtra"
            )
        }

        // implicit intent
        btn_implicit_intent.setOnClickListener {
            browse("https://www.google.com")
        }
    }


    private fun toastAndSnackbar() {
        btn_show_toast.setOnClickListener {
            toast("A sample toast")
        }

        btn_show_snackbar.setOnClickListener {
            scrollView.snackbar("Sample snackbar example")
        }
    }
}
