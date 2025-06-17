package com.koistack.app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.koistack.app.controller.TaskController


@Composable
fun CreateTaskPage (
    taskController: TaskController,
    innerPadding: PaddingValues
){
    //Parameters
    var whatTask by remember { mutableStateOf("") }
    var noteTask by remember { mutableStateOf("") }



    // Outer Column with all the content to be seen in the scaffold
    Column(modifier = Modifier
        .padding(innerPadding),
    ){

        //First Column showing the input parameters
        Column(){
            //The WHAT?
            TextField(
                value = whatTask,
                onValueChange = {whatTask = it},
                placeholder = { Text("I want to...") },
                label = { Text("WHAT?") }
            )

            //THE NOTE/DESCRIPTION
            TextField(
                value = noteTask,
                onValueChange = {noteTask = it},
                placeholder = { Text("Add note...") },
                label = { Text("DESCRIPTION?") }
            )

            Button(
                onClick = { taskController.createTask(whatTask, noteTask) },
                content = { Text("SUBMIT") }
            )
        }
    }

}