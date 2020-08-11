package com.droidco.alakazam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.droidco.alakazam.core.Alakazam

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun choosePhoto(view: View) {
        Alakazam()
            .requestCode(0)
            .fromActivity(this)
            .show()
    }
}