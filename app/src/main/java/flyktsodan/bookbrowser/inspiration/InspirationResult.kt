package flyktsodan.bookbrowser.inspiration

import flyktsodan.bookbrowser.model.Book

// could be generic
sealed class InspirationResult {
    data class Success(val books: List<Book>) : InspirationResult()
    data class Error(val error: Throwable): InspirationResult()
    object Loading: InspirationResult()
}