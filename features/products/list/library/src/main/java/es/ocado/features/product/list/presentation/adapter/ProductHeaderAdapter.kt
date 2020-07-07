package es.ocado.features.product.list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.ocado.features.product.list.R

internal class ProductHeaderAdapter(
    private val tag: String
) :
    RecyclerView.Adapter<ProductHeaderAdapter.HeaderViewHolder>() {

    class HeaderViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        fun bind(tag: String) {
            itemView.findViewById<TextView>(R.id.header).text = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_header_layout, parent, false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(tag)
    }
}
