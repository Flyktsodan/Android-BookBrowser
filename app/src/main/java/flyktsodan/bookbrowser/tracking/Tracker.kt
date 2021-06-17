package flyktsodan.bookbrowser.tracking

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

interface Tracker {
    fun track(eventName: String)
}

class LogcatTracker @Inject constructor(
    @ActivityContext private val context: Context
) : Tracker {

    override fun track(eventName: String) {
        Log.d("LogcatTracker", "LogcatTracker: $eventName, with context $context")
    }
}

class ApiTracker @Inject constructor() : Tracker {

    override fun track(eventName: String) {
        Log.d("ApiTracker", "API tracking: $eventName")
    }

}