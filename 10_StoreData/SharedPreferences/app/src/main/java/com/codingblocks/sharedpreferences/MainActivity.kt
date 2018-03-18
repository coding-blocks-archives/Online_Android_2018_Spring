package com.codingblocks.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sPref = getPreferences(Context.MODE_PRIVATE)
        var color = sPref.getInt("COLOR", Color.WHITE)
        llBackground.setBackgroundColor(color)


        fun saveColor (color: Int) {
            var editor = sPref.edit()
            editor.putInt("COLOR", color)
            editor.apply()
        }

        btnBlue.setOnClickListener {
            llBackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }
        btnRed.setOnClickListener {
            llBackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)

        }
        btnGreen.setOnClickListener {
            llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)

        }
    }
}
