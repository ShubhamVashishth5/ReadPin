package com.nagarro.shubhamvashishth.readpin.ui.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.nagarro.shubhamvashishth.readpin.constants.VIEW_AUTHOR_ROUTE
import com.nagarro.shubhamvashishth.readpin.constants.VIEW_BOOK_ROUTE
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.viewAuthorById
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.viewBookById

fun NavGraphBuilder.viewAuthorNavGraph(
    navController: NavHostController
){
    navigation(startDestination = Screens.ViewAuthorByID.route ,route = VIEW_AUTHOR_ROUTE)
    {
        composable(route= Screens.ViewAuthorByID.route,
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

            viewAuthorById(navController, olId?:"")
        }
    }

}