package com.example.criminalinent

import java.util.*

class CrimeListViewModel {
    val crimes = mutableListOf<Crime>()
    init {
        for (i in 0 until 100) {
            val crime = Crime (
                id = UUID.randomUUID() ,
                title = "Crime #$i",
                date = Date() ,
                isSolved = i % 2 == 0
            )
            crimes += crime
        }
    }
}