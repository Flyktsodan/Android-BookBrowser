package flyktsodan.bookbrowser.inspiration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import flyktsodan.bookbrowser.decorations.Decoration
import flyktsodan.bookbrowser.decorations.DecorationsViewModel
import flyktsodan.bookbrowser.ui.composables.BookListRow
import flyktsodan.bookbrowser.ui.composables.Error
import flyktsodan.bookbrowser.ui.composables.Loader
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme

@Composable
fun InspirationScreen(viewModel: InspirationViewModel = viewModel()) {
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
        HorizontalBookList(availableBooks)
    }
}

@Composable
private fun HorizontalBookList(
    books: List<Book>,
    decorationsViewModel: DecorationsViewModel = viewModel()
) {

    LazyRow {

        items(items = books, itemContent = { book ->

            val decorations by decorationsViewModel.loadDecorationForBook(book).observeAsState(Decoration(false))

            BookListRow(
                book = book,
                decorations = decorations,
                onClick = {
                    decorationsViewModel.updateDecoration(book, decorations)
                })
        })
    }
}

@Composable
private fun VerticalList(books: List<Book>) {
    LazyColumn {
        items(100, itemContent = {
            HorizontalBookList(books)
        })
    }
}