package pl.gdgwroclaw.workshop.save.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lists.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.gdgwroclaw.workshop.save.R
import pl.gdgwroclaw.workshop.save.database.ShoppingListDatabase
import pl.gdgwroclaw.workshop.save.model.Shop

class ListsFragment : Fragment(R.layout.fragment_lists) {

    private val dao by lazy { ShoppingListDatabase.database.dao() }
    private val shoppingListItemAdapter = ShoppingListItemAdapter()
    private val itemTouchHelper =
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                lifecycleScope.launch {
                    dao.delete(shoppingListItemAdapter.currentList[viewHolder.adapterPosition].item.id)
                }
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShoppingListDatabase.initialize(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton.setOnClickListener {
            lifecycleScope.launch {
                dao.insert(ItemLibrary.items.random())
            }
        }

        shoppingRecyclerView.adapter = shoppingListItemAdapter
        itemTouchHelper.attachToRecyclerView(shoppingRecyclerView)

        lifecycleScope.launch {
            dao.insertShop(Shop(id = 1, name = "Biedronka", address = "x"))
            dao.insertShop(Shop(id = 2, name = "Lidl", address = "y"))
            dao.getItemsWithShops().collect {
                shoppingListItemAdapter.submitList(it)
            }
        }
    }
}
