package com.example.memo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.memo.domain.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Insert
    suspend fun insert(memo: MemoEntity)

    @Query("SELECT * FROM MemoEntity")
    fun getAll(): Flow<List<MemoEntity>>

    @Query("SELECT * FROM MemoEntity WHERE id = :id")
    suspend fun getMemo(id: Int): MemoEntity

    @Update
    suspend fun update(memo: MemoEntity)

    @Query("DELETE FROM MemoEntity WHERE id = :id")
    suspend fun delete(id: Int)
}