import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.extensions.storeOf
import io.github.xxfast.kstore.file.storeOf
import okio.Path.Companion.toPath
import java.awt.Dimension
import java.io.File

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        resizable = false,
        title = "ClickerPicker") {
        val windowSize = Dimension(800,400)
        window.maximumSize = windowSize
        window.minimumSize = windowSize

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