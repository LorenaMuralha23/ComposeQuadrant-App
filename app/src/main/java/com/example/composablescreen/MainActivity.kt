package com.example.composablescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablescreen.ui.theme.ComposableScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposablePreview()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.weight(1f)) {// Cria uma linha com peso 1 (irá ocupar o espaço disponível igualmente com outras linhas)
            ComposableInfoCard(title = stringResource(id = R.string.first_title),
                description = stringResource(id = R.string.sec_title), background = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f))
            ComposableInfoCard(title = stringResource(id = R.string.sec_title),
                description = stringResource(id = R.string.sec_description),
                background = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(title = stringResource(id = R.string.third_title),
                description = stringResource(id = R.string.third_title),
                background = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f))
            ComposableInfoCard(title = stringResource(id = R.string.third_title),
                description = stringResource(id = R.string.sec_description),
                background = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f))
        }
    }

}

@Composable
fun ComposableInfoCard(title : String, description : String,
    background : Color, modifier: Modifier = Modifier){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(//title
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(//card description
            text = description,
            textAlign = TextAlign.Justify
        )
    }


}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    ComposableScreenTheme {
        ComposeQuadrantApp()
    }
}