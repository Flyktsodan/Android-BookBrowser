package flyktsodan.bookbrowser.decorations

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

data class Decoration(val isRead: Boolean) {

    companion object {
        @JvmStatic
        fun default() = Decoration(isRead = false)
    }
}

class DecorationRepository {

    // simple in-memory map
    private val memoryDecorationMap = MutableStateFlow<MutableMap<Int, Decoration>>(mutableMapOf())

    fun loadDecorations(bookId: Int): Flow<Decoration> = memoryDecorationMap.map { map ->
        map[bookId] ?: Decoration.default()
    }

    fun updateDecoration(bookId: Int, decoration: Decoration) {
        Log.d("TAG", "updateDecoration - bookId: $bookId, decoration: $decoration")
        // have to submit a new list to trigger a update in the StateFlow
        val newMap = mutableMapOf<Int, Decoration>()
        newMap.putAll(memoryDecorationMap.value)
        newMap[bookId] = decoration

        memoryDecorationMap.value = newMap
    }
}