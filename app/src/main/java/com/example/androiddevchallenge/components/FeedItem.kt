package com.example.androiddevchallenge.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog

@ExperimentalAnimationApi
@Composable
fun FeedItem(dog: Dog, onClick:(name:String) -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onClick(dog.name) })
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DogHeader(dog = dog, height = 50.dp, false)
                Text(
                    dog.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h6
                )
        }
    }
}