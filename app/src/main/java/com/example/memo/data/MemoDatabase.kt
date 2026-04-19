package com.example.memo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.memo.domain.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class MemoDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao
}