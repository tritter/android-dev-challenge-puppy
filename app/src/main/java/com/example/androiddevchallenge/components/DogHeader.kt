/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
