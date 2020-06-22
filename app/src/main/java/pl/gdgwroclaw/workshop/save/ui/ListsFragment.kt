package pl.gdgwroclaw.workshop.save.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lists.*
import kotlinx.coroutines.launch
import pl.gdgwroclaw.workshop.save.R

class ListsFragment : Fragment(R.layout.fragment_lists) {

    private val shoppingListItemAdapter = ShoppingListItemAdapter()
    private val itemTouchHelper =
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //TODO
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton.setOnClickListener {
            //TODO
        }

        shoppingRecyclerView.adapter = shoppingListItemAdapter
        itemTouchHelper.attachToRecyclerView(shoppingRecyclerView)

        lifecycleScope.launch {
            //TODO
        }
    }
}
