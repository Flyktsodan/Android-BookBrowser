package flyktsodan.bookbrowser.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import flyktsodan.bookbrowser.decorations.DecorationRepository
import flyktsodan.bookbrowser.inspiration.InspirationRepository
import flyktsodan.bookbrowser.tracking.LogcatTracker
import flyktsodan.bookbrowser.tracking.Tracker

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideInspirationRepository() = InspirationRepository()

    @Provides
    fun provideDecorationRepository() = DecorationRepository()
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(logcatTracker: LogcatTracker): Tracker
}