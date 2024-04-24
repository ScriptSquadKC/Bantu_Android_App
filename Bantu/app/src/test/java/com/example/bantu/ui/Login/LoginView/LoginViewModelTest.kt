package com.example.bantu.ui.Login.LoginView

import app.cash.turbine.test
import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.data.Remote.Repository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime


@ExperimentalCoroutinesApi
class LoginViewModelTest {

    private lateinit var loginviewModel: LoginViewModel
    private val repository: Repository = mockk()
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        loginviewModel = LoginViewModel(repository)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `whe launchLogin THEN success and return token String`() =  testDispatcher.runBlockingTest  {
        // Given
        val userName = "user"
        val password = "password"
        val responseLogin = "Ok login"
        coEvery { repository.launchLogin(userName, password) } returns responseLogin

        // When
        loginviewModel.launchLogin(userName, password)

        // Then
        loginviewModel.state.test {
            assertEquals(LoginState.Success(responseLogin), awaitItem())

        }
    }
}
