package me.amitshekhar.image.loading.issues

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.amitshekhar.image.loading.issues.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    private lateinit var next: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val options = BitmapFactory.Options()
        options.inBitmap = (applicationContext as MainApplication).getBitmapFromPool(400, 711)

        next = BitmapFactory.decodeResource(resources, R.drawable.next, options)
        binding.imageView.setImageBitmap(next)
    }

}