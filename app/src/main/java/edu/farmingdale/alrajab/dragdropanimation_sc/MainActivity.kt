package edu.farmingdale.alrajab.dragdropanimation_sc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv1).setOnClickListener{
            startActivity(Intent(this, DragAndDropViews::class.java))
        }
    }
}