package flyktsodan.bookbrowser.inspiration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import flyktsodan.bookbrowser.model.Book
import flyktsodan.bookbrowser.model.availableBooks
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class InspirationViewModel : ViewModel() {

    private val _inspirationResult = MutableLiveData<InspirationResult>()
    val inspirationResult: LiveData<InspirationResult> = _inspirationResult

    fun fetchBooks() {
        viewModelScope.launch {
            _inspirationResult.postValue(InspirationResult.Loading)
            // simulate a slow api call
            delay(5000)
            val success = InspirationResult.Success(getBooks())
            _inspirationResult.postValue(success)
        }
    }

    private fun getBooks(): List<Book> {
        val books = mutableListOf<Book>()
        for (i in 0..100) {
            books.add(availableBooks[Random.nextInt(0, 3)])
        }
        return books
    }
}