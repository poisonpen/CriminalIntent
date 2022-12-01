package com.example.chapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter.databinding.ListItemChapterBinding

class ChapterHolder (
    val binding: ListItemChapterBinding
        ): RecyclerView.ViewHolder(binding.root)

class ChapterListAdapter (
    private val chapters: List<Chapter>
): RecyclerView.Adapter<ChapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemChapterBinding.inflate(inflater, parent, false)
        return ChapterHolder(binding)
    }

    override fun onBindViewHolder(holder: ChapterHolder, position: Int) {
        val chapter = chapters[position]
        holder.apply{
            binding.chapterTitle.text = chapter.strangeText
            binding.date.text = chapter.lastUpdated.toString()
        }
    }
    override fun getItemCount() = chapters.size
}