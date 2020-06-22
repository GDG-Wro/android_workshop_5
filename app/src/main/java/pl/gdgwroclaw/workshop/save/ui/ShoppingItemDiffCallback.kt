package pl.gdgwroclaw.workshop.save.ui

import androidx.recyclerview.widget.DiffUtil
import pl.gdgwroclaw.workshop.save.model.ItemWithShop

object ShoppingItemDiffCallback : DiffUtil.ItemCallback<ItemWithShop>() {
    override fun areItemsTheSame(oldItem: ItemWithShop, newItem: ItemWithShop) =
        oldItem.item.id == newItem.item.id

    override fun areContentsTheSame(oldItem: ItemWithShop, newItem: ItemWithShop) =
        oldItem == newItem
}
