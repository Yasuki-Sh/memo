package com.example.memo.data

import androidx.room.Database
import com.example.memo.domain.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class MemoDatabase {
    abstract fun memoDao(): MemoDao
}