package me.amitshekhar.image.loading.issues

import android.app.Application
import android.graphics.Bitmap

class MainApplication : Application() {

    private val bitmapPool = arrayListOf<Bitmap>()

    fun addToBitmapPool(bitmap: Bitmap) {
        bitmapPool.add(bitmap)
    }

    fun getBitmapFromPool(height: Int, width: Int): Bitmap? {
        // code for checking the size of the bitmap
        // ....

        if (bitmapPool.size > 0) {
            return bitmapPool.removeAt(0)
        }

        return null
    }

}