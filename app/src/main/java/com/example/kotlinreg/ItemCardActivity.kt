package com.example.kotlinreg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)

        val title: TextView = findViewById(R.id.item_list_titleOne)
        val text: TextView = findViewById(R.id.item_list_text)
        val cimage: ImageView = findViewById(R.id.item_card_image)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
    }
}