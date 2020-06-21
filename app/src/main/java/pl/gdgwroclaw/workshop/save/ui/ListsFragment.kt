package pl.gdgwroclaw.workshop.save.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_lists.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.gdgwroclaw.workshop.save.R
import pl.gdgwroclaw.workshop.save.database.ShoppingListDatabase

class ListsFragment : Fragment(R.layout.fragment_lists) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = ShoppingListDatabase.getDatabase(requireContext()).dao()
        addButton.setOnClickListener {
            lifecycleScope.launch {
                dao.insert(ItemLibrary.items.random())
            }
        }

        val shoppingListItemAdapter = ShoppingListItemAdapter()
        shoppingRecyclerView.adapter = shoppingListItemAdapter

        lifecycleScope.launch {
            dao.getItems().collect {
                shoppingListItemAdapter.submitList(it)
            }
        }
    }
}
