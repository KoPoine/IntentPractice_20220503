package com.neppplus.intentpractice_20220503

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
            goBtn.setOnClickListener {
                val inputData = editDataEdt.text.toString()
                val resultIntent = Intent ()
                resultIntent.putExtra("inputData", inputData)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
    }
}