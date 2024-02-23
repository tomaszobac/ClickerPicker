package app.clickerpicker

import MainViewModel
import SaveData
import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ensureDirectoryAndFileExist
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import okio.Path.Companion.toPath
import showMenu
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val documentsPath = System.getProperty("user.home") + File.separator + "Documents"
            ensureDirectoryAndFileExist(documentsPath, "ClickerPicker", "saveData.json")
            val store: KStore<SaveData> = storeOf(file = (documentsPath +
                    File.separator +
                    "ClickerPicker" +
                    File.separator +
                    "saveData.json").toPath())

            val viewModel = MainViewModel(store)

            MaterialTheme{ showMenu(viewModel) }
        }
    }
}