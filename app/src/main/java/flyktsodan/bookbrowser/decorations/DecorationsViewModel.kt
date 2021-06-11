package flyktsodan.bookbrowser.decorations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import flyktsodan.bookbrowser.model.Book

class DecorationsViewModel(
    private val repository: DecorationRepository = DecorationRepository()
) : ViewModel() {

    fun loadDecorationForBook(book: Book) = liveData {
        emit(repository.fetchDecorationForBook(book))
    }
}