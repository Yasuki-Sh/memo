package com.example.memo

import android.app.Application
import com.example.memo.data.MemoDatabase
import com.example.memo.data.MemoRepository

class MemoApplication : Application() {
    val database by lazy { MemoDatabase.getDatabase(this) }
    val repository by lazy { MemoRepository(database.memoDao()) }
}