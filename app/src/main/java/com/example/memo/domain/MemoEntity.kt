package com.example.memo.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val memo: String
)