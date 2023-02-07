import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.notesClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch
import ui.HomeScreen
import ui.HomeViewModel

@Composable
@Preview
fun App() {

    val scope = rememberCoroutineScope()
    MaterialTheme {
        HomeScreen(vm = HomeViewModel(scope))
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
