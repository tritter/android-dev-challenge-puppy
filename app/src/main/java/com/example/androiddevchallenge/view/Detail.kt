package com.example.androiddevchallenge.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.components.DogCard
import com.example.androiddevchallenge.model.Dog

@ExperimentalAnimationApi
@Composable
fun Detail(dog: Dog) {
    DogCard(dog)
}