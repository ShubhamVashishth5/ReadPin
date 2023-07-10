package com.nagarro.shubhamvashishth.readpin.ui.navigation

sealed class Screens(val route: String){
    object Home: Screens("home_screen")
    object Discover: Screens("discover_screen")
    object UserProfile: Screens("user_profile_screen")
    object ViewBookById: Screens("book_by_id_screen/{olId}/{cover_id}")
    object ViewAuthorByID: Screens("author_by_id_screen/{olID}/{cover_id}")
}