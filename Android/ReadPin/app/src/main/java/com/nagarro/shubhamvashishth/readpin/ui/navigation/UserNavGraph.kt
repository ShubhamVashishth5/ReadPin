package com.nagarro.shubhamvashishth.readpin.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nagarro.shubhamvashishth.readpin.constants.USER_PROFILE_ROUTE
import com.nagarro.shubhamvashishth.readpin.ui.components.discoverScreen
import com.nagarro.shubhamvashishth.readpin.ui.components.userScreen

fun NavGraphBuilder.userNavGraph(
    navController: NavHostController
){
    navigation(startDestination = Screens.UserProfile.route ,route = USER_PROFILE_ROUTE)
    {
        composable(route= Screens.UserProfile.route){
            userScreen(navController)
        }
    }

}