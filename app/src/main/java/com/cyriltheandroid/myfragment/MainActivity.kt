package com.cyriltheandroid.myfragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var isBlue = false
    var fragmentRed = FragmentRed()
    var fragmentBlue = FragmentBlue()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.run {
            add(R.id.my_fragment_container_view, fragmentBlue)
            add(R.id.my_fragment_container_view, fragmentRed)
            hide(fragmentBlue)
            commit()
        }

        val button = findViewById<Button>(R.id.click_me_button)
        button.setOnClickListener {
            updateFragmentContainerView(isBlue)
            isBlue = !isBlue
        }
    }

    private fun updateFragmentContainerView(isBlue: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.run {
            hide(if (isBlue) fragmentRed else fragmentBlue)
            show(if (isBlue) fragmentBlue else fragmentRed)
            commit()
        }
    }
}