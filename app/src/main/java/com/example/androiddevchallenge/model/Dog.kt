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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import java.util.Random

@Immutable
data class Dog(
    val name: String,
    var description: String,
    val phone: String,
    @DrawableRes
    val image: Int,
    val color: Color
)

fun randomColor(): Color {
    val random = Random()
    return Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), 255)
}

var dogs = listOf(
    Dog(
        name = "Bella",
        description = "Beautiful dog on the west-side of life.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog1,
        color = randomColor()
    ),
    Dog(
        name = "Charlie",
        description = "Needs a new owner! I can't handle this one anymore.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog2,
        color = randomColor()
    ),
    Dog(
        name = "Luna",
        description = "Like the moon in the dark.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog3,
        color = randomColor()
    ),
    Dog(
        name = "Lucy",
        description = "Sometimes biting when the light goes off.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog4,
        color = randomColor()
    ),
    Dog(
        name = "Max",
        description = "Searching a new house.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog5,
        color = randomColor()
    ),
    Dog(
        name = "Bailey",
        description = "Barking at night for the rest a calm dog.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog6,
        color = randomColor()
    ),
    Dog(
        name = "Cooper",
        description = "Nobody is drifting like this cooper.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog7,
        color = randomColor()
    ),
    Dog(
        name = "Daisy",
        description = "A lady like always, hard to handle.",
        phone = "+1 (555) 555-1234",
        image = R.drawable.dog8,
        color = randomColor()
    )
)
