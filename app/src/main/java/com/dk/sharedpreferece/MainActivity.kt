package com.dk.sharedpreferece

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * 로컬에 유저 성별을 저장
 * 남성복 -> M
 * 여성복 -> W
 * 이런 경우에 SharedPreferece
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val sv1 = findViewById<Button>(R.id.sv1Btn)
        sv1.setOnClickListener {

            val editTxt1 = findViewById<EditText>(R.id.editTxt1)
            with(sharedPref.edit()){
                putString(MyTestClass.SHARED_VAL_1, editTxt1.text.toString())
                apply()
            }
        }

        val read1 = findViewById<Button>(R.id.read1Btn)
        read1.setOnClickListener {
            val sharedVal = sharedPref.getString(MyTestClass.SHARED_VAL_1, "default Val1")
            val readTxt1 = findViewById<TextView>(R.id.readTxt1)
            readTxt1.text = sharedVal
        }

        val sv2 = findViewById<Button>(R.id.sv2Btn)
        sv2.setOnClickListener {

            val editTxt2 = findViewById<EditText>(R.id.editTxt2)
            with(sharedPref.edit()){
                putString(MyTestClass.SHARED_VAL_2, editTxt2.text.toString())
                apply()
            }
        }

        val read2 = findViewById<Button>(R.id.read2Btn)
        read2.setOnClickListener {
            val sharedVal = sharedPref.getString(MyTestClass.SHARED_VAL_2, "default Val2")
            val readTxt2 = findViewById<TextView>(R.id.readTxt2)
            readTxt2.text = sharedVal
        }
    }
}