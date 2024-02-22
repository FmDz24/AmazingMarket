package com.example.kotlinreg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ItemCardActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemCardActivity> {
        override fun createFromParcel(parcel: Parcel): ItemCardActivity {
            return ItemCardActivity(parcel)
        }

        override fun newArray(size: Int): Array<ItemCardActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)


        val title: TextView = findViewById(R.id.item_list_titleOne)
        val text: TextView = findViewById(R.id.item_list_text)
        val btn: Button = findViewById(R.id.item_list_button)
        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
    }
}