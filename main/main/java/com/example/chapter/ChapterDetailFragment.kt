package com.example.chapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.chapter.databinding.FragmentChapterDetailBinding
import java.util.*

class ChapterDetailFragment: Fragment() {
    private lateinit var chapter: Chapter
    private lateinit var binding: FragmentChapterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chapter = Chapter(
            id = UUID.randomUUID(),
            strangeText = "",
            translationText = "",
            language = "",
            comment = "",
            lastUpdated = Date()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChapterDetailBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            chapterTitle.doOnTextChanged {
                text, _,_,_ ->
                chapter = chapter.copy(strangeText = text.toString())
            }
            dateof.apply {
                // text = chapter.date.toString()
                isEnabled = false
            }
        }
     }
}