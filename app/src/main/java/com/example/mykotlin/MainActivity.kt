package com.example.mykotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mykotlin.ui.theme.MyKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var moneyCounter = remember {
        mutableIntStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "$${moneyCounter.value}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Spacer(modifier = Modifier.height(130.dp))

            CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                moneyCounter.value = newValue
            }
        }

    }
}
//  create state without by keyword
//@Preview
@Composable
fun CreateCircle(
    moneyCounter: Int = 0,
    updateMoneyCounter: (Int) -> Unit
) {
    // //move it up to its parent
    //var moneyCounter = remember {
    //    mutableIntStateOf(0)
    //}
    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            updateMoneyCounter(moneyCounter + 1)
        },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = "Tap"
            )
        }

    }
}

//@Preview
//@Composable
//fun CreateCircle() {
//    var moneyCounter by remember {
//        mutableIntStateOf(0)
//    }
//    Card(modifier = Modifier
//        .padding(3.dp)
//        .size(105.dp)
//        .clickable {
//            moneyCounter += 1
//            Log.d("counter", "$moneyCounter")
//        },
//        shape = CircleShape,
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                modifier = Modifier,
//                text = "Tap $moneyCounter"
//            )
//        }
//
//    }
//}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyKotlinTheme {
        MyApp()
    }
}