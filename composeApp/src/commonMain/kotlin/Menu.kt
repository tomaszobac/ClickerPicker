import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
fun showMenu(viewModel: MainViewModel) {
    if (viewModel.showMenu.value) {
        MaterialTheme {
            Box(modifier = Modifier.width(800.dp).height(800.dp)) {
                Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("CLICKER", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold)
                    Text("PICKER", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold)
                    TabRowDefaults.Divider(modifier = Modifier.height(20.dp), color = Color.Transparent)
                    Button(onClick = { viewModel.showMenu.value = false }) {
                        Text("Start")
                    }
                    Button(onClick = { exitProcess(0) }) {
                        Text("Exit")
                    }
                }
            }
        }
    }
    if (!viewModel.showMenu.value) run(viewModel)
}
