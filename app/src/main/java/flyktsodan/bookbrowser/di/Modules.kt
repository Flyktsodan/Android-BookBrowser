package flyktsodan.bookbrowser.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import flyktsodan.bookbrowser.decorations.DecorationRepository
import flyktsodan.bookbrowser.inspiration.InspirationRepository
import flyktsodan.bookbrowser.tracking.ApiTracker
import flyktsodan.bookbrowser.tracking.LogcatTracker
import flyktsodan.bookbrowser.tracking.Tracker
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideInspirationRepository() = InspirationRepository()

    @Provides
    fun provideDecorationRepository() = DecorationRepository()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiTrackerA

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LogcatTrackerA

//@Module
//@InstallIn(ActivityComponent::class)
//object AnalyticsModule {
//
//    @Provides
//    @LogcatTrackerA
//    fun provideLogcatTracker(): Tracker = LogcatTracker()
//
//    @Provides
//    @ApiTrackerA
//    fun providesApiTracker(): Tracker = ApiTracker()
//}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {

    @Binds
    @LogcatTrackerA
    abstract fun bindLogcatTracker(logcatTracker: LogcatTracker): Tracker

    @Binds
    @ApiTrackerA
    abstract fun bingApiService(apiTracker: ApiTracker): Tracker

}