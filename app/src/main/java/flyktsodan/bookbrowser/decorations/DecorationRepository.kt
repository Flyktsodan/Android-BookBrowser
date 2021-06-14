package flyktsodan.bookbrowser.decorations

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

data class Decoration(val isRead: Boolean)

class DecorationRepository {

    private val _memoryStoreMap = MutableStateFlow<MutableMap<Int, Decoration>>(mutableMapOf())

    fun loadDecorations(bookId: Int): Flow<Decoration> = _memoryStoreMap.map { map ->
        map[bookId] ?: Decoration(false)
    }

    fun updateDecoration(bookId: Int, decoration: Decoration) {
        Log.d("TAG", "update value invoked")

        val oldDecoration = _memoryStoreMap.value[bookId]
        val newDecoration = if (oldDecoration != null) {
            val isRead = oldDecoration.isRead
            Decoration(isRead = !isRead)
        } else {
            Decoration(true)
        }
        val newMap = mutableMapOf<Int, Decoration>()
        newMap.putAll(_memoryStoreMap.value)
        newMap[bookId] = newDecoration

        // have to submit a new list to trigger a update
        _memoryStoreMap.value = newMap
    }
}