package com.example.jetpackcomposeplayground.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.unit.dp
import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.core.VectorImageButton

class BottomAppBarActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldWithBottomBarAndCutout()
        }
    }
}

private val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)

@Composable
fun ScaffoldWithBottomBarAndCutout() {
    val scaffoldState = remember { ScaffoldState() }
    // Consider negative values to mean 'cut corner' and positive values to mean 'round corner'
    val fabShape = RoundedCornerShape(50)

    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = { TopAppBar(title = { Text("Scaffold Examples") }) },
        bottomAppBar = { fabConfiguration ->
            BottomAppBar(fabConfiguration = fabConfiguration, cutoutShape = fabShape) { _: String ->
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = fabShape,
                color = MaterialTheme.colors().secondary
            ) {
                VectorImageButton(id = R.drawable.ic_baseline_favorite_24, onClick = {})
            }
        },
        floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked,
        bodyContent = { modifier ->
            VerticalScroller {
                Column(modifier) {
                    repeat(100) {
                        Card(color = colors[it % colors.size],
                            shape = RoundedCornerShape(8.dp),
                            modifier = LayoutPadding(8.dp)) {
                            Spacer(modifier = LayoutWidth.Fill + LayoutHeight(200.dp))
                        }
                    }
                }
            }
        }
    )
}