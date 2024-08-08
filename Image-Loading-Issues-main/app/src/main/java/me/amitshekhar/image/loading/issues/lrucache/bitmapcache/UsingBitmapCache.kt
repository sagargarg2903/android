package me.amitshekhar.image.loading.issues.lrucache.bitmapcache

import android.graphics.Bitmap
import androidx.collection.LruCache

fun main() {

    val bitmapCache: LruCache<String, Bitmap>

    val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
    val cacheSize = maxMemory / 8

    bitmapCache = object : LruCache<String, Bitmap>(cacheSize) {

        override fun sizeOf(key: String, bitmap: Bitmap): Int {
            return bitmap.byteCount / 1024
        }

    }

}