package by.enolizard.dota2info

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(this.context).inflate(layoutId, this, attachToRoot)

fun ImageView.loadImg(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun debug(text: String) {
    Log.d("Debug", text)
}