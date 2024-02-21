package com.example.kotlinreg

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<com.example.kotlinreg.Item>()

        items.add(Item(1,"cat_poop", "Кошачья жижа", "Отвратительна на вкус и мерзко пахнет", "Натуральный продукт. Изготовлено исключительно из домашних кошек естественного происхождения. Беречь от детей! Содержание алкоголя 75%", 200))
        items.add(Item(2, "bone","Кость динозавра","Товар б/у много лет","Откопано живой собакой 100% настоящий не имитация", 1200))
        items.add(Item(3, "pod", "Подушка", "Гиппоалергенная", "Обыкновенная подушка, вообще ничего особенного", 600))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}