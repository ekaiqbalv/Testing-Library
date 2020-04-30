package com.example.testinglib

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import com.aksaramaya.handwritingrecognition.HandwritingRecognition

class MainActivity : AppCompatActivity() {
    lateinit var viewImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewImage = findViewById(R.id.image_view)
        viewImage.setImageResource(R.mipmap.coba_1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navMain: MenuInflater = menuInflater
        navMain.inflate(R.menu.navigation_draw, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId!!) {
            R.id.nav_predict -> {
                val bitmapDrawable = viewImage.drawable as BitmapDrawable
                val bitmap = bitmapDrawable.bitmap
                var result = "Hasil "
                result += HandwritingRecognition.recognition(this, bitmap)
                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
