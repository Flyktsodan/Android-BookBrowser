package flyktsodan.bookbrowser.model

data class Book(val title: String, val author: String, val imageUrl: String)

val availableBooks = listOf(
    Book(
        title = "Den saknade systern", author = "Lucinda Reiley", "https://prod-bb-images.akamaized" +
                ".net/book-covers/coverimage-9789180060509-bonnierforlagen-2021-05-19.jpg?w=200&format=jpg&quality=85"
    ),
    Book(
        title = "Den sista spiken",
        author = "Fabian Risk",
        "https://prod-bb-images.akamaized.net/book-covers/coverimage-9789137155715-bonnierforlagen-2021-05-27.jpg?w=200&format=jpg&quality=85"
    ),
    Book(
        title = "Där kräftorna sjunger",
        author = "Anna Maria Käll",
        "https://prod-bb-images.akamaized.net/book-covers/coverimage-9789178275625-bonnierforlagen-2021-02-28.jpg?w=200&format=jpg&quality=85"
    ),
)