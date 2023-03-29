package com.nagarro.shubhamvashishth.readpin.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nagarro.shubhamvashishth.readpin.constants.HOME_GRAPH_ROUTE
import com.nagarro.shubhamvashishth.readpin.ui.components.homeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(startDestination = Screens.Home.route ,route = HOME_GRAPH_ROUTE)
    {
        composable(route=Screens.Home.route){
            homeScreen(navController)
        }
    }

}