package flyktsodan.bookbrowser.inspiration

import kotlinx.coroutines.delay
import kotlin.random.Random

class InspirationRepository {

    suspend fun fetchBooks(): List<Book> {
        delay(3000)
        return getBooks()
    }

    private fun getBooks(): List<Book> {
        val books = mutableListOf<Book>()
        for (i in 0..100) {
            books.add(availableBooks[Random.nextInt(0, 3)])
        }
        return books
    }
}

data class Book(val bookId: Int, val title: String, val author: String, val imageUrl: String)

val availableBooks = listOf(
    Book(
        bookId = 1,
        title = "Den saknade systern",
        author = "Lucinda Reiley", "https://prod-bb-images.akamaized" +
                ".net/book-covers/coverimage-9789180060509-bonnierforlagen-2021-05-19.jpg?w=200&format=jpg&quality=85"
    ),
    Book(
        bookId = 2,
        title = "Den sista spiken",
        author = "Fabian Risk",
        "https://prod-bb-images.akamaized.net/book-covers/coverimage-9789137155715-bonnierforlagen-2021-05-27.jpg?w=200&format=jpg&quality=85"
    ),
    Book(
        bookId = 3,
        title = "Där kräftorna sjunger",
        author = "Anna Maria Käll",
        "https://prod-bb-images.akamaized.net/book-covers/coverimage-9789178275625-bonnierforlagen-2021-02-28.jpg?w=200&format=jpg&quality=85"
    ),
)