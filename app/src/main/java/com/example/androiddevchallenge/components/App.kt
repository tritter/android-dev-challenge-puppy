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

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Repository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.view.Detail
import com.example.androiddevchallenge.view.Feed

@ExperimentalAnimationApi
@Composable
fun App() {
    val repository = Repository
    val navController = rememberNavController()
    val title = stringResource(R.string.app_name)
    MyTheme {
        Column() {
            TopAppBar(title = { Text(title) })
            NavHost(navController = navController, startDestination = "feed") {
                composable("feed") {
                    Feed(
                        repository.all(),
                        onClick = { name ->
                            navController.navigate("detail/$name")
                        }
                    )
                }
                composable(
                    "detail/{name}",
                    arguments = listOf(navArgument("name") { type = NavType.StringType })
                ) { backStackEntry ->
                    Detail(repository.get(backStackEntry.arguments?.get("name") as String)!!)
                }
            }
        }
    }
}
