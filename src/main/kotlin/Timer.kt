import androidx.compose.runtime.*
import kotlinx.coroutines.delay

var timeLeft by remember { mutableStateOf(20) }
var timeStopped by remember { mutableStateOf(true) }

@Composable
fun basicCountdownTimer(viewModel: MainViewModel) {
    LaunchedEffect(key1 = timeStopped) {
        while (!timeStopped && timeLeft > 0) {
            timeLeft--
            delay(1000L)
        }
        if (timeLeft <= 0) {
            timeStopped = true
            showGame = false
        }
    }
}