package pl.gdgwroclaw.workshop.save.ui

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.gdgwroclaw.workshop.save.model.ItemWithShop

class ShoppingItemViewHolder(private val rootView: TextView) : RecyclerView.ViewHolder(rootView) {

    fun bind(itemWithShop: ItemWithShop) {
        val item = itemWithShop.item
        rootView.text =
            "${item.name}: ${item.quantity.amount} ${item.quantity.unitOfMeasurement} ${itemWithShop.shop.name}"
    }
}
