package com.pobezhkin.starwars.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pobezhkin.starwars.presentation.detailsScreen.StarDetailsScreen
import com.pobezhkin.starwars.presentation.home.StarHomeScreen

@Composable
fun StarNavGraph(navController: NavHostController, modifier: Modifier = Modifier){
    NavHost(
        navController = navController,
        startDestination = StarNavigationScreens.HeroesList.starRoute
    ){
            composable(StarNavigationScreens.HeroesList.starRoute){
                StarHomeScreen(modifier= modifier,
                    onHeroesClick = {id ->
                        navController.navigate(
                            StarNavigationScreens.Herodetails.createStarRoute(id)
                        )

                    }
                )
            }

        composable( route = StarNavigationScreens.Herodetails.starRoute,
                arguments = listOf(
                    navArgument("heroName"){
                        type = NavType.StringType
                    }
                )
            ){backStack ->
            val heroName = backStack.arguments?.getString("heroName") ?: ""
            StarDetailsScreen(
                modifier = modifier,
                onBackClick = { navController.popBackStack() }
            )
        }
    }


}