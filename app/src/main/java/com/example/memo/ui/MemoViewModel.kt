package com.example.memo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memo.data.MemoRepository
import com.example.memo.domain.MemoEntity
import kotlinx.coroutines.launch

class MemoViewModel(
    private val repository: MemoRepository
): ViewModel() {
    val memos = repository.memos

    fun insertMemo(memo: String) {
        val memoEntity = MemoEntity(id = 0, memo = memo)
        viewModelScope.launch {
            repository.insertMemo(memoEntity)
        }
    }
    fun updateMemo(memo: MemoEntity) {
        viewModelScope.launch {
            repository.updateMemo(memo)
        }
    }
    fun deleteMemo(memo: MemoEntity) {
        viewModelScope.launch {
            repository.deleteMemo(memo)
        }
    }
}