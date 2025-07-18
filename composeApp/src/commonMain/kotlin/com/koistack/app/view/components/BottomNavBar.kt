//package com.koistack.app.view.components
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ExperimentalLayoutApi
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScope
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.Dp
//import com.koistack.app.utils.ColorTheme
//import com.koistack.app.utils.CutOutShape
//import com.koistack.app.utils.Navigation
//import org.jetbrains.compose.resources.imageResource
//import org.jetbrains.compose.resources.painterResource
//import org.jetbrains.compose.resources.vectorResource
//
///*A general reusable Navbar that highlights the clicked "NavItem"
//* and returns the current/expected location
//**/
//
//
//
//@OptIn(ExperimentalComposeUiApi::class, ExperimentalLayoutApi::class)
//@Composable
//fun BottomNavBar(
//    mapOfNavItemToIcon: Map<String, Icons>,
//    buttonSize: Dp,
//    buttonAction: () -> Unit
//) {
//
//    //Outer Box holding all the elements
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//    ){
//        //Row Holding the NavItems
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .clip(shape = CutOutShape(buttonSize))
//        ){
//
//        }
//
//        //Floating Action Button
//        Button(
//            modifier = Modifier
//                .offset(y = (-buttonSize/2))
//                .size(buttonSize),
//            onClick = buttonAction
//
//        ){
//            Image(
//                imageVector = Icons.Default.Add,
//                contentDescription = "Add"
//            )
//        }
//    }
//
//
//    //This is the outer edge of the navigation bar
//    Row(
//        modifier = Modifier
//                .background(color = Color.Transparent)
//            .padding()
//            .fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.Bottom
//    ) {
//        //List of routes turned into columns
//        // All pressable & direct you to the required page
//        for (itemTextID in mapOfNavItemToIcon) {
//
//            itemTextID
//
//
//            if (listOfNavItems.indexOf(itemTextID) == 2) {
//                Column(
//                    modifier = Modifier
//                        .background(color = ColorTheme.topBackground)
//                        .weight(1f)
//                        .aspectRatio(1f)
//                ){
//                    Text(
//                        text = ("Click Me")
//                    )
//                }
//            }
//
//
//            NavItem(
//                itemTextID = itemTextID
//            )
//        }
//    }
//}
//
//
////Creates a navigational item based on the input data
////The RowScope interface allows the navItems to utilise the
////Modifier.weight of the future row composable they'll be added to
//@Composable
//private fun RowScope.NavItem(
//    itemTextID: String,
//) {
//
//    val colorTheme = ColorTheme
//    val navigation = Navigation
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly,
//        modifier = Modifier
//            .background(
//                color =
//                if(itemTextID == navigation.currentPosition){
//                    colorTheme.bottomBackground
//                } else {
//                    colorTheme.topBackground
//                }
//            )
//            .weight(1f)
//            .clickable(
//                onClick = {
//                    navigation.setNewPosition(itemTextID)
//                }
//            )
//    ) {
//        Text(
//            text = itemTextID,
//            color = colorTheme.text
//        )
//    }
//
//}
//
