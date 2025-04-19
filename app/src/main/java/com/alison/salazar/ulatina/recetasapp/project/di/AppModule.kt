package com.alison.salazar.ulatina.recetasapp.project.di

import android.content.Context
import androidx.room.Room
import com.alison.salazar.ulatina.recetasapp.project.data.database.AppDatabase
import com.alison.salazar.ulatina.recetasapp.project.data.database.interfaces.FavoriteRecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "recetas_db"
        ).build()
    }

    @Provides
    fun provideFavoriteRecipeDao(db: AppDatabase): FavoriteRecipeDao {
        return db.favoriteRecipeDao()
    }
}