import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun basicCountdownTimer(viewModel: MainViewModel) {
    LaunchedEffect(key1 = viewModel.timeStopped.value) {
        while (!viewModel.timeStopped.value && viewModel.timeLeft.value > 0) {
            viewModel.timeLeft.value--
            delay(1000L)
        }
        if (viewModel.timeLeft.value <= 0) {
            viewModel.timeStopped.value = true
            viewModel.showGame.value = false
        }
    }
}