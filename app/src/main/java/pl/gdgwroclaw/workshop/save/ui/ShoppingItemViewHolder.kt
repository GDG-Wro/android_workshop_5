package pl.gdgwroclaw.workshop.save.ui

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.gdgwroclaw.workshop.save.model.Item

class ShoppingItemViewHolder(private val rootView: TextView) : RecyclerView.ViewHolder(rootView) {

    fun bind(item: Item) {
        rootView.text = "${item.name}: ${item.quantity.amount} ${item.quantity.unitOfMeasurement}"
    }
}
