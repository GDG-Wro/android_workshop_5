package pl.gdgwroclaw.workshop.save.ui

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import pl.gdgwroclaw.workshop.save.model.ItemWithShop

class ShoppingListItemAdapter :
    ListAdapter<ItemWithShop, ShoppingItemViewHolder>(ShoppingItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShoppingItemViewHolder(
            TextView(
                parent.context
            )
        )

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
