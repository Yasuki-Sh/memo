package com.example.memo.data

import com.example.memo.domain.MemoEntity

class MemoRepository(private val memoDao: MemoDao) {
    val memos = memoDao.getAll()

    suspend fun insertMemo(memo: MemoEntity){
        memoDao.insert(memo)
    }
    suspend fun updateMemo(memo: MemoEntity){
        memoDao.update(memo)
    }
    suspend fun deleteMemo(memo: MemoEntity){
        memoDao.delete(memo)
    }
}