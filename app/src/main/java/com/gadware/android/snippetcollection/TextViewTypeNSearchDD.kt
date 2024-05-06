package com.gadware.android.snippetcollection

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gadware.android.snippetcollection.databinding.ActivityTextViewTypeNsearchDdBinding


class TextViewTypeNSearchDD : AppCompatActivity() {
    private lateinit var binding: ActivityTextViewTypeNsearchDdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTextViewTypeNsearchDdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDDContents()
        setDDContentsObject()
    }

    private fun setDDContentsObject() {
        val items = listOf(
            Item(1, "Item 1"),
            Item(2, "Item 2"),
            Item(3, "Item 3"),
            // Add more items as needed
        )
        val adapter = ItemAdapter(this, items)
//        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        binding.inputCat2 .setAdapter(adapter)
        binding.inputCat2.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            // Handle the selected item here
            Toast.makeText(this, "Selected: ${selectedItem?.name}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setDDContents() {
        val categList: MutableList<String?> = ArrayList()
        categList.add("General")
        categList.add("Exclusive")
        //categList.addAll(categoryList)
        val categAdapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, categList)
        categAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        binding.inputCat.setAdapter(categAdapter)
    }
}