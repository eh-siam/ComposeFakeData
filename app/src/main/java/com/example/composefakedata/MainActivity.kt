package com.example.composefakedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.composefakedata.navigation.AppNavHost
import com.example.composefakedata.ui.theme.ComposeFakeDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFakeDataTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
