package com.gadware.android.snippetcollection

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter
import java.util.Locale

class ItemAdapter(
    context: Context,
    private val items: List<Item>
) : ArrayAdapter<Item>(context, android.R.layout.simple_dropdown_item_1line, items) {

    private val filter = ItemFilter()

    override fun getFilter(): Filter {
        return filter
    }

    private inner class ItemFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterResults = FilterResults()
            val queryString = constraint?.toString()?.lowercase(Locale.ROOT)

            val filteredItems = if (queryString.isNullOrEmpty()) {
                items
            } else {
                items.filter { it.name.lowercase(Locale.ROOT).contains(queryString) }
            }

            filterResults.values = filteredItems
            filterResults.count = filteredItems.size
            return filterResults
        }

        @Suppress("UNCHECKED_CAST")
        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            try {
                clear()
            }catch (e:Exception){}

            if (results != null && results.count > 0) {
                addAll(results.values as List<Item>)
            } else {
                notifyDataSetInvalidated()
            }
        }
    }
}
