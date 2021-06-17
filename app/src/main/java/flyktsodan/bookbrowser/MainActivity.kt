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
import flyktsodan.bookbrowser.di.ApiTrackerA
import flyktsodan.bookbrowser.di.LogcatTrackerA
import flyktsodan.bookbrowser.inspiration.InspirationScreen
import flyktsodan.bookbrowser.inspiration.InspirationViewModel
import flyktsodan.bookbrowser.tracking.Tracker
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val inspirationViewModel: InspirationViewModel by viewModels()

    @Inject
    @LogcatTrackerA
    lateinit var tracker: Tracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inspirationViewModel.fetchBooks()
        tracker.track("MainActivity created!")

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
        InspirationScreen()
    }
}