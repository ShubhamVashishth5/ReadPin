package com.nagarro.shubhamvashishth.readpin.ui.components.reusable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun featureLockedLogin() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(220.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(color = Color(4293062901)), contentAlignment = Alignment.Center
    ){
        Column() {
            Text(text = "Please login to see your recent books")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
    }
    
}

@Preview
@Composable 
fun prevComponent(){
    featureLockedLogin()
}