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
import kotlin.random.Random
import kotlin.system.exitProcess

@Composable
fun run(viewModel: MainViewModel) {
    if (showGame) {
        Box(modifier = Modifier
            .width(800.dp)
            .height(800.dp)
            .clickable {
                miss++
            }) {
            basicCountdownTimer()
            Button(
                onClick = {
                    if (count == 20 && timeStopped) {
                        timeStopped = false
                    }
                    randomizePosition()
                    count--
                    if (count == 0) {
                        timeStopped = true
                        showGame = false
                        showWin()
                    }
                },
                modifier = Modifier.offset(x = offsetX, y = offsetY).clip(CircleShape).size(50.dp))
            {
                Text(count.toString(), fontSize = 12.sp)
            }
            Box(modifier = Modifier.align(Alignment.TopCenter)) {
                Text(text = "Time left: $timeLeft", color = if (timeLeft > 30) Color.Green else Color.Red)
            }
        }
    }
}