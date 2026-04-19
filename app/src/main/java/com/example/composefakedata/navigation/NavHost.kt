package com.example.composefakedata.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composefakedata.presentation.PostDetailsScreen
import com.example.composefakedata.presentation.PostScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "post_screen"
    ) {
        composable("post_screen") {
            PostScreen(navController)
        }

        composable(
            route = "details_screen/{postId}",
            arguments = listOf(
                navArgument("postId") { type = NavType.StringType }
            )
        ) {
            backStackEntry ->

            val postId = backStackEntry.arguments?.getString("postId")

            PostDetailsScreen(postId = postId)
        }

    }
}


