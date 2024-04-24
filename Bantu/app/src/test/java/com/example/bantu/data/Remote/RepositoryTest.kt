package com.example.bantu.data.Remote

import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.Domain.Model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class RepositoryTest {

    // SUT
    private lateinit var repository: Repository

    //Dependencias
    private val remoteDataSource: RemoteDataSource = mockk()

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



    @Before
    fun setUp() {

        repository = Repository(
            remoteDataSource
        )

    }

    @Test
    fun `WHEN getUserById THEN SUCCESS return list remote with FAKE`() = runTest {

        // Given
        coEvery { remoteDataSource.getUserById("1") } returns user

        // When
        val actual1 = remoteDataSource.getUserById("1")


        // Then
        coVerify { remoteDataSource.getUserById("1") }


    }

    @Test
    fun `WHEN launchLogin THE SUCCESS return token String`()= runTest{
        val username = "username@hotmail.com"
        val password = "1237892"
        val authResponse = AuthResponse("222",1,"asad")

        //Given
        coEvery { remoteDataSource.launchLogin(username, password) } returns authResponse

        // When
        val actual = remoteDataSource.launchLogin(username, password)

        coVerify { remoteDataSource.launchLogin(username, password)}


    }


}

