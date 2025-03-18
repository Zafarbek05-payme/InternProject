package com.example.stopwatch.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stopwatch.weather.navigation.MenuItem
import com.example.stopwatch.weather.navigation.menuItems

@Composable
fun AppDrawer(onDestinationClicked: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Mini Apps",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Divider()
        menuItems.forEach {item ->
            DrawerItem(item=item) {
                onDestinationClicked(item.route)
            }
        }
    }
}

@Composable
fun DrawerItem(item: MenuItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.title, fontSize = 18.sp)
    }
}