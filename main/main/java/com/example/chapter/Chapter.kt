package com.example.chapter

import java.util.*

data class Chapter (
        val id: UUID,
        val strangeText: String,
        val translationText: String,
        val language: String,
        val comment: String,
        val lastUpdated: Date
)
