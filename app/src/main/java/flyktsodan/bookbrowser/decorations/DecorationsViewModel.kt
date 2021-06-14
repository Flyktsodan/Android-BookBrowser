package flyktsodan.bookbrowser.decorations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import flyktsodan.bookbrowser.inspiration.Book

object Singleton {
    val repository = DecorationRepository()
    val viewModel = DecorationsViewModel()
}

class DecorationsViewModel(private val repository: DecorationRepository = Singleton.repository) : ViewModel() {

    fun loadDecorationForBook(book: Book) = repository.loadDecorations(book.bookId).asLiveData()

    fun updateDecoration(book: Book) = repository.updateDecoration(book.bookId, Decoration(true))
}