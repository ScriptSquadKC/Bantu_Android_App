package com.example.bantu.ui.Home

import app.cash.turbine.test
import com.example.bantu.Domain.Model.User
import com.example.bantu.data.Remote.RemoteDataSource
import com.example.bantu.data.Remote.Repository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime


class HomeViewModelTest{
    private lateinit var homeViewModel: HomeViewModel
    private val repository: Repository = mockk()
    private val testDispatcher = TestCoroutineDispatcher()
    private val remoteDataSource: RemoteDataSource = mockk()

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        homeViewModel = HomeViewModel(repository)

    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @OptIn(ExperimentalTime::class)

    fun `WHEN getUserById THEN success`()=  testDispatcher.runBlockingTest{
        val user = User(
            "TestUsuario",
            "est@email.es",
            "TestApellido1",
            "TestApellido2",
            1,
            1,
            "TestPoblación",
            "9999",
            "TestAvatar",
            "",
            true,
            null
        )

        // Given
        coEvery { homeViewModel.getUserById() } just runs

        // When
        val actual1 = homeViewModel.getUserById()

        coVerify { homeViewModel.getUserById() }
    }

}