package com.example.chapter

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter.databinding.FragmentChapterListBinding

private const val TAG = "ChapterListFragment"

class ChapterListFragment : Fragment() {
    private var _binding: FragmentChapterListBinding? = null
    private val binding
    get() = checkNotNull(_binding) {
        "Cannot access binding [null reference]"
    }
    private val chapterListViewModel: ChapterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${chapterListViewModel.chapters.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChapterListBinding.inflate(inflater, container, false)
        binding.chapterRecyclerView.layoutManager = LinearLayoutManager(context)
        val chapters = chapterListViewModel.chapters
        val adapter = ChapterListAdapter(chapters)
        binding.chapterRecyclerView.adapter = adapter
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

