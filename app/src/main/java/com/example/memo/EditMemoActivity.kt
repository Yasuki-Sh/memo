package com.example.memo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditMemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_memo)

        val memoId = intent.getIntExtra("memo_id", -1)
        val memoText = intent.getStringExtra("memo_text")

        val editText = findViewById<EditText>(R.id.editMemoInput)
        val saveButton = findViewById<Button>(R.id.saveMemoButton)
        val deleteButton = findViewById<Button>(R.id.deleteMemoButton)

        editText.setText(memoText)

        saveButton.setOnClickListener {
            val updatedText = editText.text.toString()
            if (updatedText.isNotBlank()) {
                val resultIntent = Intent().apply {
                    putExtra("memo_id", memoId)
                    putExtra("updated_text", updatedText)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }

        deleteButton.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("memo_id", memoId)
            }
            setResult(RESULT_CANCELED, resultIntent)
            finish()
        }
    }
}