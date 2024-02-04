package app.clickerpicker

import MainViewModel
import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import showMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = MainViewModel()
            MaterialTheme{ showMenu(viewModel) }
        }
    }
}