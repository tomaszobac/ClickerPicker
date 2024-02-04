import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.system.exitProcess

@Composable
fun winScreen(viewModel: MainViewModel) {
    if (viewModel.showWinScreen.value) {
        Box(modifier = Modifier.width(800.dp).height(800.dp)) {
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("SCORE: ${viewModel.timeLeft.value - viewModel.miss.value}", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                Row {
                    Text("Time Left: ${viewModel.timeLeft.value}", color = Color.Green)
                }
                Row {
                    Text("Miss-clicks: ${viewModel.miss.value}", color = Color.Red)
                }
                Row {
                    Button(onClick = { exitProcess(0) }) {
                        Text("Exit")
                    }
                    TabRowDefaults.Divider(modifier = Modifier.width(10.dp), color = Color.Transparent)
                    Button(onClick = { viewModel.restart() }) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}