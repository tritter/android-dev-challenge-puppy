package com.example.androiddevchallenge.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.tooling.CompositionGroup
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
