package flyktsodan.bookbrowser.decorations

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import flyktsodan.bookbrowser.inspiration.Book
import javax.inject.Inject

@HiltViewModel
class DecorationsViewModel @Inject constructor(private val repository: DecorationRepository) : ViewModel() {

    init {
        Log.d("TAG","DecorationsViewModel init!")
    }

    fun loadDecorationForBook(book: Book) = repository.loadDecorations(book.bookId).asLiveData()

    fun updateDecoration(book: Book, decoration: Decoration) {
        val newDecoration = Decoration(!decoration.isRead)
        repository.updateDecoration(book.bookId, newDecoration)
    }
}