import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.*

@Composable
@Preview
fun App() {

    val scope = rememberCoroutineScope()
    var route by remember { mutableStateOf<Route>(Route.Home) }

    MaterialTheme {
        when (route) {
            Route.Home -> HomeScreen(
                vm = HomeViewModel(scope),
                onCreateClick = { route = Route.Detail(it) })

            is Route.Detail -> NoteDetail(
                vm = NoteDetailViewModel(scope, (route as Route.Detail).id),
                onBackClick = { route = Route.Home })
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
