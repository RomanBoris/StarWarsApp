package com.pobezhkin.starwars.presentation.navigation

sealed class StarNavigationScreens(val starRoute: String) {
    object HeroesList: StarNavigationScreens("hero_list")
    object Herodetails : StarNavigationScreens("hero_detail/{heroName}"){
        fun createStarRoute(heroName: String) ="hero_detail/$heroName"
    }
}