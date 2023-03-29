package com.nagarro.shubhamvashishth.readpin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun TopAppBar(navController: NavHostController){
    var ok by remember{ mutableStateOf("") }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.height(50.dp).fillMaxWidth()){
    Column{
        Text(text = "ReadPin",  fontSize = 30.sp,
            fontWeight = FontWeight.Bold,)
      //  TextField(value = ok, onValueChange = { ok= it } )
    }
    }
}
