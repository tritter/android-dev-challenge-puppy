package com.example.androiddevchallenge.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.model.Dog
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun DogHeader(dog: Dog, height: Dp, animate: Boolean = true) {
    var visible by remember { mutableStateOf(!animate) }
    val scope = rememberCoroutineScope()
    scope.launch {
        if (animate) {
            visible = true
        }
    }
    ConstraintLayout {
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth / 2 },
                animationSpec = tween(durationMillis = 500)
            ) + fadeIn(initialAlpha = 0.3f),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center).clip(CircleShape)
            ) {
                Box(
                    modifier = Modifier.size(height).background(dog.color)
                ) { }
            }
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 2 },
                animationSpec = tween(durationMillis = 500)
            ) + fadeIn(initialAlpha = 0.3f),
        ) {
            Image(
                painter = painterResource(dog.image),
                "dog",
                modifier = Modifier
                    .height(height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}
