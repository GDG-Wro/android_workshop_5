package pl.gdgwroclaw.workshop.save.ui

import androidx.recyclerview.widget.DiffUtil
import pl.gdgwroclaw.workshop.save.model.Item

object ShoppingItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}
