package com.example.marvelherosapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroApp(isMainScreen: Boolean, content: @Composable () -> Unit)
{
    MaterialTheme {
        Surface{
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            )
            {
//                    Image(
//                        painter = painterResource(id = R.drawable.black_bg),
//                        contentDescription = null,
//                        modifier = Modifier.fillMaxSize()
//                    )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isMainScreen)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.marvel_studios),
                            contentDescription = "Marvel Studios Icon",
                            modifier = Modifier
                                .width(300.dp)
                                .height(200.dp)
                                .padding(20.dp)
                        )
                        Text(
                            text = "CHOOSE YOUR HERO!",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    content()
                }
            }
        }
    }
}
