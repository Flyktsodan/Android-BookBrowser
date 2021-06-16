package flyktsodan.bookbrowser.inspiration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

// could be generic
sealed class InspirationResult {
    data class Success(val books: List<Book>) : InspirationResult()
    data class Error(val error: Throwable) : InspirationResult()
    object Loading : InspirationResult()
}

@HiltViewModel
class InspirationViewModel @Inject constructor(private val repository: InspirationRepository) : ViewModel() {

    private val _inspirationResult = MutableLiveData<InspirationResult>()
    val inspirationResult: LiveData<InspirationResult> = _inspirationResult

    var failCount = 0

    fun fetchBooks() {
        viewModelScope.launch {
            _inspirationResult.postValue(InspirationResult.Loading)
            val books = repository.fetchBooks()

            if (failCount > 0) {
                val success = InspirationResult.Success(books)
                _inspirationResult.postValue(success)
            } else {
                failCount++
                _inspirationResult.postValue(InspirationResult.Error(IOException()))
            }
        }
    }
}