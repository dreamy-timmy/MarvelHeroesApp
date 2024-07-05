package com.example.marvelherosapp.utils


import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.marvelherosapp.R


fun getCharacterName(context: Context, index: Int): String {
    return when(index){
        0 -> context.getString(R.string.deadpool)
        1 -> context.getString(R.string.iron_man)
        else -> context.getString(R.string.hulk)
    }
}
@Composable
fun getImagePainter(index: Int): Painter
{
    val imageRes = when (index) {
        0 -> R.drawable.deadpool
        1 -> R.drawable.iron_man
        else -> R.drawable.hulk
    }
    return painterResource(id = imageRes)

}
