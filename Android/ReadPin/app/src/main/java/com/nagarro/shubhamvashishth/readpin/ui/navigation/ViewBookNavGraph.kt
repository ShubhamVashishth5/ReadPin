package com.nagarro.shubhamvashishth.readpin.ui.navigation

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.nagarro.shubhamvashishth.readpin.constants.DISCOVER_GRAPH_ROUTE
import com.nagarro.shubhamvashishth.readpin.constants.VIEW_BOOK_ROUTE
import com.nagarro.shubhamvashishth.readpin.ui.components.discoverScreen
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.viewBookById

fun NavGraphBuilder.viewBookNavGraph(
    navController: NavHostController
){
    navigation(startDestination = Screens.ViewBookById.route ,route = VIEW_BOOK_ROUTE)
    {
        composable(route= Screens.ViewBookById.route,
            arguments = listOf(
            navArgument("olId"){
                type = NavType.StringType
            },
                navArgument(name = "cover_id"){
                    type= NavType.StringType
                }
            )
        ){
                backStackEntry ->
            var olId= backStackEntry.arguments?.getString("olId")
            var coverId= backStackEntry.arguments?.getString("cover_id")

            viewBookById(navController, olId?:"", coverId?:"")
        }
    }

}