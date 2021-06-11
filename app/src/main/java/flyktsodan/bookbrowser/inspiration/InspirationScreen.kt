package flyktsodan.bookbrowser.inspiration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import flyktsodan.bookbrowser.model.Book
import flyktsodan.bookbrowser.ui.composables.BookListRow
import flyktsodan.bookbrowser.ui.composables.Error
import flyktsodan.bookbrowser.ui.composables.Loader
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme

// Composable UI

@Composable
fun ColorfulListRow() {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Green,
                        Color.Blue
                    )
                )
            )
            .width(200.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Wazzuuuup")
    }
}

@Composable
fun HorizontalBookList(books: List<Book>) {
    LazyRow {
        items(items = books, itemContent = { book ->
            BookListRow(book)
        })
    }
}

@Composable
fun VerticalList(books: List<Book>) {
    LazyColumn {
        items(10, itemContent = {
            HorizontalBookList(books)
        })
    }
}

@Composable
fun InspirationScreen(viewModel: InspirationViewModel = InspirationViewModel()) {
    val inspirationResult: InspirationResult by viewModel.inspirationResult.observeAsState(InspirationResult.Loading)
    val result = inspirationResult
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        when (result) {
            is InspirationResult.Success -> VerticalList(books = result.books)
            is InspirationResult.Error -> Error(onRetryClicked = { viewModel.fetchBooks() })
            InspirationResult.Loading -> Loader()
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