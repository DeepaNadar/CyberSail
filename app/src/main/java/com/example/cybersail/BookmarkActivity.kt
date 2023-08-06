package com.example.cybersail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybersail.adapter.BookmarkAdapter
import com.example.cybersail.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvBookmark.setItemViewCacheSize(5)
        binding.rvBookmark.hasFixedSize()
        binding.rvBookmark.layoutManager=LinearLayoutManager(this)
        binding.rvBookmark.adapter=BookmarkAdapter(this, isActivity = true)
    }
}