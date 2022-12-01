package com.example.chapter

import androidx.lifecycle.ViewModel
import java.util.*

class ChapterListViewModel: ViewModel() {
    val chapters = mutableListOf<Chapter>()
    init {
        for (i in 0 until 100) {
            val chapter = Chapter (
                id = UUID.randomUUID(),
                strangeText = "Entry #$i",
                translationText = "",
                language = "",
                comment = "",
                lastUpdated = Date()
            )
            chapters += chapter
        }
    }
}