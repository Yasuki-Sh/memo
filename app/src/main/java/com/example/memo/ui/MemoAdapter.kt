package com.example.memo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memo.R
import com.example.memo.domain.MemoEntity

class MemoAdapter : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private var memos = listOf<MemoEntity>()

    class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memoText: TextView = itemView.findViewById(R.id.memoText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memo, parent, false)
        return MemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.memoText.text = memos[position].memo
    }

    override fun getItemCount(): Int = memos.size

    fun updateMemos(newMemos: List<MemoEntity>) {
        memos = newMemos
        notifyDataSetChanged()
    }
}