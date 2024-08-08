package me.amitshekhar.image.loading.issues

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.amitshekhar.image.loading.issues.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var main: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val options = BitmapFactory.Options()
        options.inMutable = true
        main = BitmapFactory.decodeResource(resources, R.drawable.main, options)
        binding.imageView.setImageBitmap(main)
    }

    fun startNextActivity(view: View) {
        startActivity(Intent(this@MainActivity, NextActivity::class.java))
        (applicationContext as MainApplication).addToBitmapPool(main)
        finish()
    }

}