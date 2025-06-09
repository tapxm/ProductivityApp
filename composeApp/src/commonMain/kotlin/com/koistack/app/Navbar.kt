package com.koistack.app

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



object Navbar {
    var calenderIcon:String = "Calender";
    var settingsIcon:String = "Settings";
    var homeIcon:String = "Home";
    var taskIcon:String = "Task";
    var addIcon:String = "Add";

    @Composable
    fun setNavBar(){
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(homeIcon);
            Text(taskIcon);
            Text(addIcon);
            Text(calenderIcon);
            Text(settingsIcon);
        }

    }
}