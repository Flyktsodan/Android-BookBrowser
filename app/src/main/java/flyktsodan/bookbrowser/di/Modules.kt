package flyktsodan.bookbrowser.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import flyktsodan.bookbrowser.decorations.DecorationRepository
import flyktsodan.bookbrowser.inspiration.InspirationRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideInspirationRepository() = InspirationRepository()

    @Provides
    fun provideDecorationRepository() = DecorationRepository()
}