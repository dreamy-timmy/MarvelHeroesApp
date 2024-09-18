package com.example.marvelherosapp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.example.marvelherosapp.R

import com.example.marvelherosapp.utils.getCharacterName
import com.example.marvelherosapp.utils.getImagePainter



@Composable
fun DetailScreen(context: Context, navController: NavHostController, index: Int)
{

    val imagePainter = getImagePainter(index)
    val description = when (index) {
        0 -> context.getString(R.string.deadpool_description)
        1 -> context.getString(R.string.iron_man_description)
        else -> context.getString(R.string.hulk_description)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_to_menu),
                    modifier = Modifier.size(60.dp),
                    contentDescription = "Back",
                    tint = Color.White,
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 50.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Character close-up",
                modifier = Modifier
//                          .fillMaxSize()
                    .height(400.dp)
                    .width(400.dp)
//                        .padding(10.dp)
            )
            Text(
                text = getCharacterName(context, index),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(10.dp)
            )
            Text(
                text = description,
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}
