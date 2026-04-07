package com.pobezhkin.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pobezhkin.starwars.presentation.detailsScreen.StarDetailsScreen
import com.pobezhkin.starwars.presentation.home.StarHomeScreen
import com.pobezhkin.starwars.presentation.navigation.StarNavGraph
import com.pobezhkin.starwars.ui.theme.StarWarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            StarWarsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    StarNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

