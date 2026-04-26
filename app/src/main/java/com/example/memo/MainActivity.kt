package com.example.memo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memo.ui.MemoAdapter
import com.example.memo.ui.MemoViewModel
import com.example.memo.ui.MemoViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val app = application as MemoApplication
        val factory = MemoViewModelFactory(app.repository)
        val viewModel = ViewModelProvider(this, factory)[MemoViewModel::class.java]

        val memoInput = findViewById<EditText>(R.id.memoInput)
        val addButton = findViewById<Button>(R.id.addMemoButton)
        val memoList = findViewById<RecyclerView>(R.id.memoList)

        addButton.setOnClickListener {
            val text = memoInput.text.toString()
            if (text.isNotBlank()) {
                viewModel.insertMemo(text)
                memoInput.text.clear()
            }
        }

        val adapter = MemoAdapter()
        memoList.adapter = adapter
        memoList.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.memos.collect { memos ->
                    adapter.updateMemos(memos)
                }
            }
        }
    }
}