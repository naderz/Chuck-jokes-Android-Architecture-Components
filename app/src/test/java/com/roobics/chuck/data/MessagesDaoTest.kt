package com.roobics.chuck.data

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MessagesDaoTest {

    lateinit var chuckRepository: ChuckRepository

    @Before
    fun before() {
      //  chuckRepository = ChuckRepository.getInstance()
    }

    @Test
    fun testGetMessages() {
        val result = chuckRepository.getJoke()

        assertEquals(listOf("Welcome", "to", "ADO"), result)
    }
}