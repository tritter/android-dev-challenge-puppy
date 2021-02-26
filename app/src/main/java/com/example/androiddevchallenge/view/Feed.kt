package com.example.androiddevchallenge.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.FeedItem
import com.example.androiddevchallenge.model.Dog

@ExperimentalAnimationApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Feed(dogs: List<Dog>, onClick: (name: String) -> Unit){
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 110.dp)
    ) {
        items(dogs) { dog ->
            FeedItem(dog, onClick)
        }
    }
}