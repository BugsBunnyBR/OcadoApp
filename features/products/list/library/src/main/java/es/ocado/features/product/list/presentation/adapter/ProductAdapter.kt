package es.ocado.features.product.list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.ocado.features.product.list.R
import es.ocado.features.product.list.databinding.ListItemProductLayoutBinding
import es.ocado.features.product.list.domain.model.ProductEntity
import es.ocado.base.library.utils.loadImage

internal typealias OnProductClickListener = (item: ProductEntity) -> Unit

internal class ProductAdapter(
    private val data: List<ProductEntity>,
    private val onProductClickListener: OnProductClickListener
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(
        viewItem: View,
        private val onProductClickListener: OnProductClickListener
    ) : RecyclerView.ViewHolder(viewItem) {
        fun bind(product: ProductEntity) {
            val binding = ListItemProductLayoutBinding.bind(itemView)
            binding.productTitle.text = product.title
            binding.productImage.loadImage(product.imageUrl)
            binding.root.setOnClickListener {
                onProductClickListener(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_product_layout, parent, false)
        return ProductViewHolder(view, onProductClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
