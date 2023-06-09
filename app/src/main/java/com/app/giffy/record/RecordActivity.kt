package com.app.giffy.record

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.app.giffy.R
import kotlinx.android.synthetic.main.activity_record.*



class RecordActivity : AppCompatActivity() {
    companion object {
        fun newLaunchIntent(context: Context) = Intent(context, RecordActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_record)

        val routingFragment = RecordRoutingFragment.newInstance()

        if (savedInstanceState == null) {
            this.supportFragmentManager.beginTransaction()
                .replace(this.contentContainer.id, routingFragment, routingFragment.javaClass.simpleName)
                .commit()
        }
    }
}