package pl.gdgwroclaw.workshop.save.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings.*
import pl.gdgwroclaw.workshop.save.R

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText.setText("TODO")
        notificationsCheckBox.isChecked = true

        saveButton.setOnClickListener {
            //TODO
        }
    }
}
