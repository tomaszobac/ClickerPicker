import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun run(viewModel: MainViewModel) {
    if (viewModel.showGame.value) {
        Box(modifier = Modifier
            .width(800.dp)
            .height(800.dp)
            .clickable {
                viewModel.miss.value++
            }) {
            basicCountdownTimer(viewModel)
            Button(
                onClick = {
                    if (viewModel.count.value == 20 && viewModel.timeStopped.value) {
                        viewModel.timeStopped.value = false
                    }
                    viewModel.randomizePosition()
                    viewModel.count.value--
                    if (viewModel.count.value == 0) {
                        viewModel.timeStopped.value = true
                        viewModel.showGame.value = false
                        viewModel.showWinScreen.value = true
                    }
                },
                modifier = Modifier.offset(x = viewModel.offsetX.value, y = viewModel.offsetY.value).clip(CircleShape).size(50.dp))
            {
                Text(viewModel.count.value.toString(), fontSize = 12.sp)
            }
            Box(modifier = Modifier.align(Alignment.TopCenter)) {
                Text(text = "Time left: ${viewModel.timeLeft.value}", color = if (viewModel.timeLeft.value > 30) Color.Green else Color.Red)
            }
        }
    }
    if (!viewModel.showGame.value) winScreen(viewModel)
}