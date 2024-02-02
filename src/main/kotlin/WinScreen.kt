import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.system.exitProcess



private var showWinScreen by remember { mutableStateOf(false) }

fun showWin() = !showWinScreen

@Composable
fun winScreen() {
    if (showWinScreen) {
        Box(modifier = Modifier.width(800.dp).height(800.dp)) {
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("SCORE: ${timeLeft - miss}", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                Row {
                    Text("Time Left: $timeLeft", color = Color.Green)
                }
                Row {
                    Text("Miss-clicks: $miss", color = Color.Red)
                }
                Row {
                    Button(onClick = { exitProcess(0) }) {
                        Text("Exit")
                    }
                    TabRowDefaults.Divider(modifier = Modifier.width(10.dp), color = Color.Transparent)
                    Button(onClick = { restart() }) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}