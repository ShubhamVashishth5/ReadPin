package com.nagarro.shubhamvashishth.readpin.ui.components

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import com.nagarro.shubhamvashishth.readpin.constants.VIEW_BOOK_ROUTE

@Composable
fun discoverScreen(navHostController: NavHostController){
    Button(onClick = { navHostController.navigate("view/"+14) },  Modifier.fillMaxSize()) {
        Text(text = navHostController.currentDestination?.route!!)
    }
}