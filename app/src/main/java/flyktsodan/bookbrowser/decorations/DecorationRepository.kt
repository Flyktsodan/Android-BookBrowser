package flyktsodan.bookbrowser.decorations

import flyktsodan.bookbrowser.model.Book
import kotlinx.coroutines.delay

data class Decoration(val isRead: Boolean)

class DecorationRepository {

    suspend fun fetchDecorationForBook(book: Book): Decoration {
        delay(1500)
        return Decoration(true)
    }
}