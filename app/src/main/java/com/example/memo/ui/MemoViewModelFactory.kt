package com.example.memo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.memo.data.MemoRepository

class MemoViewModelFactory(
    private val repository: MemoRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemoViewModel(repository) as T
    }
}