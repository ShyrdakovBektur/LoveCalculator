package com.itproger.lovecalculator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.itproger.lovecalculator.databinding.ActivityHistoryBinding
import com.itproger.lovecalculator.mvvm.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private val loveViewModel: LoveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loveViewModel.getAll().observe(this@HistoryActivity) { loveData ->
            val data = sortDataAlphadetically(loveData)
            binding.textView.text = data
        }
    }

    private fun sortDataAlphadetically(data: String): String {
        val lines = data.split("\n\n")
        val sortedLines = lines.sorted()
        return sortedLines.joinToString("\n\n")
    }
}