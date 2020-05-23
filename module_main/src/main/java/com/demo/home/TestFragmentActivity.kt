package com.demo.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.home.ui.mainactivity2.MainActivity2Fragment

class TestFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainActivity2Fragment.newInstance())
                .commitNow()
        }
    }
}
