package com.roobics.chuck.welcome

import com.roobics.chuck.data.ChuckRepository
import com.roobics.chuck.ui.WelcomeViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class WelcomeViewModelTest {

    lateinit var welcomeViewModel: WelcomeViewModel

    lateinit var mockChuckRepository: ChuckRepository

    @Before
    fun before() {
        mockChuckRepository = mock(ChuckRepository::class.java)

        welcomeViewModel = WelcomeViewModel(mockChuckRepository)
    }

    @Test
    fun testGetMessages() {
       // `when`(mockChuckRepository.getJoke()).thenReturn(listOf("1", "2", "3"))

        mockChuckRepository.getJoke()
    }

}