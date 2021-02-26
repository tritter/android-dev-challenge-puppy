package com.example.androiddevchallenge.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Repository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.view.Detail
import com.example.androiddevchallenge.view.Feed

@ExperimentalAnimationApi
@Composable
fun App() {
    val repository = Repository;
    val navController = rememberNavController()
    val title = stringResource(R.string.app_name)
    MyTheme {
        Column()
        {
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
                )
                { backStackEntry ->
                    Detail(repository.get(backStackEntry.arguments?.get("name") as String)!!)
                }
            }
        }
    }
}