package com.example.prueba.di

import android.app.Application
import androidx.room.Room
import com.example.prueba.data.local.SudokuDao
import com.example.prueba.data.local.SudokuDatabase
import com.example.prueba.data.remote.SudokuApiService
import com.example.prueba.data.repository.SudokuRepositoryImpl
import com.example.prueba.domain.repository.SudokuRepository
import com.example.prueba.domain.usecase.*
import com.example.prueba.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSudokuApi(): SudokuApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SudokuApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): SudokuDatabase {
        return Room.databaseBuilder(
            app,
            SudokuDatabase::class.java,
            "sudoku_db"
        ).build()
    }

    @Provides
    fun provideDao(db: SudokuDatabase): SudokuDao = db.sudokuDao()

    @Provides
    @Singleton
    fun provideRepository(api: SudokuApiService, dao: SudokuDao): SudokuRepository {
        return SudokuRepositoryImpl(api, dao)
    }

    @Provides
    fun provideUseCases(repository: SudokuRepository): SudokuUseCases {
        return SudokuUseCases(
            generateSudoku = GenerateSudokuUseCase(repository),
            checkSudokuSolution = CheckSudokuSolutionUseCase(),
            saveSudoku = SaveSudokuUseCase(repository),
            loadSudoku = LoadSudokuUseCase(repository)
        )
    }
}
