package com.koistack.app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.koistack.app.model.Task

@Composable
fun taskCard(task: Task) {

    val height:Int = 2;
    val width:Int = 2;


    return Card(
        modifier = Modifier
            .padding(5.dp),
        elevation = 5.dp
    ) {
         Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .background(Color.Magenta)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight()
                    .weight(8f)
                    .padding(5.dp),
            ) {
                task.title?.let { it1 -> Text(it1) };

                task.description?.let { it2 -> Text(it2) };

                Text("The due date is ${task.dueDate}");
            }
            Column(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    imageVector = task.symbol,
                    contentDescription = "task symbol",
                    modifier = Modifier
                        .align(Alignment.End)
                )
                Text(
                    text = task.status,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Red)
                )
            }

        }
    }
}
