package flyktsodan.bookbrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import flyktsodan.bookbrowser.inspiration.InspirationScreen
import flyktsodan.bookbrowser.inspiration.InspirationViewModel
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val inspirationViewModel: InspirationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inspirationViewModel.fetchBooks()

        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InspirationScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
//        InspirationScreen()
    }
}