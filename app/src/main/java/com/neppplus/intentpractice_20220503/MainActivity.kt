package com.neppplus.intentpractice_20220503

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NAME = 1001
    val REQ_FOR_NICKNAME = 1002
    val REQ_FOR_PHONENUM = 1003

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myIntent = Intent(this, SecondActivity::class.java)

        editNameBtn.setOnClickListener {
            startActivityForResult(myIntent, REQ_FOR_NAME)
        }

        editNickBtn.setOnClickListener {
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

        editPhoneBtn.setOnClickListener {
            startActivityForResult(myIntent, REQ_FOR_PHONENUM)
        }

        phoneNumTxt.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.ekkorr.cook")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val editData = data?.getStringExtra("inputData")

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQ_FOR_NAME -> { nameTxt.text = editData }
                REQ_FOR_NICKNAME -> { nickNameTxt.text = editData }
                REQ_FOR_PHONENUM -> { phoneNumTxt.text = editData }
            }
        }
    }
}