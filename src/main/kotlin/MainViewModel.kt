import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainViewModel {
    var count = mutableStateOf(20)
    var miss = mutableStateOf(0)
    var offsetX = mutableStateOf(Random.nextInt(0, 400).dp)
    var offsetY = mutableStateOf(Random.nextInt(0, 400).dp)
    var showMenu = mutableStateOf(true)
    var showGame = mutableStateOf(true)
    var showWinScreen = mutableStateOf(false)
    var timeLeft = mutableStateOf(20)
    var timeStopped = mutableStateOf(true)

    fun randomizePosition() {
        offsetX.value = Random.nextInt(0, 400).dp
        offsetY.value = Random.nextInt(0, 400).dp
    }

    fun restart() {
        count.value = 20
        miss.value = 0
        randomizePosition()
        timeLeft.value = 20
        showGame.value = true
        showWinScreen.value = false
        timeStopped.value = true
    }
}
