package com.example.marvelherosapp


import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.layout.*

import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.compose.ui.text.font.FontWeight

import com.example.marvelherosapp.HeroApp
import com.example.marvelherosapp.utils.getImagePainter
import com.example.marvelherosapp.utils.getCharacterName

//import com.example.marvelherosapp.screens.MainScreen
//import com.example.marvelherosapp.screens.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var isMainScreen by remember { mutableStateOf(true) }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                isMainScreen = destination.route == "main"
            }

            HeroApp(isMainScreen) {

                NavHost(navController = navController, startDestination = "main") {
                    composable("main") { MainScreen(navController) }
                    composable("detail/{index}") { backStackEntry ->
                        val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
                        DetailScreen(navController, index)
                    }

                }
            }
        }
    }

    @Composable
        fun MainScreen(navController: NavHostController)
        {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()

            LaunchedEffect(listState) {
                snapshotFlow { listState.firstVisibleItemIndex }
                    .collect { index ->
                        coroutineScope.launch {
                            listState.animateScrollToItem(index)
                        }
                    }
            }

            LazyRow(
                state = listState,
                modifier = Modifier.fillMaxSize()
            )
            {
                items(3) { index ->
                    Box(
                        modifier = Modifier
                            .height(300.dp)
                            .width(300.dp)
                            .padding(8.dp)
                            .clickable
                            {
                                navController.navigate("detail/$index")
                            }
                    ) {
                        Image(
                            painter = getImagePainter(index),
                            contentDescription = "Hero number $index",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)

                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .background(Color.Black.copy(alpha = 0.7f))
                                .fillMaxWidth()
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = getCharacterName(getMainActivityContext(), index),
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

            }
        }

    @Composable
    fun DetailScreen(navController: NavHostController, index: Int)
    {
        val imagePainter = getImagePainter(index)
        val description = when (index) {
            0 -> getString(R.string.deadpool_description)
            1 -> getString(R.string.iron_man_description)
            else -> getString(R.string.hulk_description)
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
                    text = getCharacterName(getMainActivityContext(), index),
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
//    companion object {
        fun getMainActivityContext(): Context {
            return this@MainActivity
        }
//    }

//    private fun getCharacterName(index: Int): String {
//        return when(index){
//            0 -> getString(R.string.deadpool)
//            1 -> getString(R.string.iron_man)
//            else -> getString(R.string.hulk)
//        }
//    }
//
//    @Composable
//    fun getImagePainter(index: Int): Painter
//        {
//            val imageRes = when (index) {
//                0 -> R.drawable.deadpool
//                1 -> R.drawable.iron_man
//                else -> R.drawable.hulk
//            }
//            return painterResource(id = imageRes)
//
//    }
}