package com.nagarro.shubhamvashishth.readpin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.nagarro.shubhamvashishth.readpin.constants.HOME_GRAPH_ROUTE
import com.nagarro.shubhamvashishth.readpin.constants.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController,
    startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
        ){
        homeNavGraph(navHostController)
        discoverNavGraph(navHostController)
        userNavGraph(navHostController)
        viewBookNavGraph(navHostController)
        viewAuthorNavGraph(navHostController)
    }

}
