package com.nagarro.shubhamvashishth.readpin.ui.navigation

sealed class Screens(val route: String){
    object Home: Screens(route = "home_screen")
    object Discover: Screens("discover_screen")
    object UserProfile: Screens("user_profile_screen")
}