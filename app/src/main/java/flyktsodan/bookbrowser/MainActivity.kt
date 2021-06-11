package flyktsodan.bookbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import flyktsodan.bookbrowser.inspiration.InspirationScreen
import flyktsodan.bookbrowser.inspiration.InspirationViewModel
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme


class MainActivity : ComponentActivity() {

    // TODO inject with hilt
    private val viewModel = InspirationViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchBooks()

        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InspirationScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        InspirationScreen()
    }
}