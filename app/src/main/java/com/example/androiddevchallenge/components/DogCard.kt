package com.example.androiddevchallenge.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
fun DogCard(dog: Dog){
    Column(Modifier.padding(15.dp, 15.dp)) {
        DogHeader(dog, 150.dp)
        Column(Modifier.padding(15.dp, 5.dp)) {
            Text(dog.name, style = MaterialTheme.typography.h1)
            Text(dog.description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AdoptButton(dog)
            }
        }
    }
}
