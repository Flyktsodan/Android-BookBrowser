package flyktsodan.bookbrowser.tracking

import android.util.Log
import javax.inject.Inject

interface Tracker {
    fun track(eventName: String)
}

class LogcatTracker @Inject constructor() : Tracker {

    override fun track(eventName: String) {
        Log.d("Tracking", "Tracked: $eventName")
    }
}