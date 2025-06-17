package com.koistack.app.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.koistack.app.controller.TaskController
import kotlinx.datetime.Clock

//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable

@Composable
    fun Navbar(
    ) :String {

        var route by remember { mutableStateOf("user") }

    var mutatedButton by remember { mutableStateOf(Color.Magenta) }



     Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = NavDestinantion.Home.route,
                modifier = Modifier
                    .background(mutatedButton)
                    .clickable(
                        onClick = {
                            route = NavDestinantion.Home.route
                            if (mutatedButton == Color.Red){
                                mutatedButton = Color.Yellow
                            } else {mutatedButton = Color.Red}
                        }
                    )
            );

        Text(
            text = NavDestinantion.Tasks.route,
            modifier = Modifier
                .clickable(
                    onClick = {
                        route = NavDestinantion.Tasks.route
                    }
                )
        );

        Text(
            text = NavDestinantion.User.route,
            modifier = Modifier
                .clickable(
                    onClick = {
                        route = NavDestinantion.User.route
                    }
                )
        );

        Text(
            text = NavDestinantion.Calender.route,
            modifier = Modifier
                .clickable(
                    onClick = {
                        route = NavDestinantion.Calender.route

                    }
                )
        )
        }

    return route

    }
