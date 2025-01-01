package com.example.watertimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.watertimer.ui.theme.WaterTimerTheme
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTimerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val consumed: ConsumedViewModel by viewModels()
                    val target: TargetViewModel by viewModels()
                    Greeting(
                        consumed,
                        target,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(consumed: ConsumedViewModel,
             target: TargetViewModel,
             modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            target.addValue(1)
        }) {
            Text(text = "Add 1 litre")
        }
        Button(onClick = {
            target.reduceValue(1)
        }) {
            Text(text = "Reduce 1 litre")
        }
        Button(onClick = {
            consumed.addValue(250)
        }) {
            Text(text = "Consumed 250 ml water")
        }
        Text(text = "Target for today ${target.getTarget()}")
        Text(text = "Consumed today = ${consumed.consumed.intValue * 0.001}")
    }
}