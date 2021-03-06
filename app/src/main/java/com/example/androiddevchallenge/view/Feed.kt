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
fun Feed(dogs: List<Dog>, onClick: (name: String) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 110.dp)
    ) {
        items(dogs) { dog ->
            FeedItem(dog, onClick)
        }
    }
}
