package com.nagarro.shubhamvashishth.readpin.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nagarro.shubhamvashishth.readpin.constants.DISCOVER_GRAPH_ROUTE
import com.nagarro.shubhamvashishth.readpin.ui.components.discoverScreen
import com.nagarro.shubhamvashishth.readpin.ui.components.homeScreen

fun NavGraphBuilder.discoverNavGraph(
    navController: NavHostController
){
    navigation(startDestination = Screens.Discover.route ,route = DISCOVER_GRAPH_ROUTE)
    {
        composable(route= Screens.Discover.route){
            discoverScreen(navController)

        }
    }

}