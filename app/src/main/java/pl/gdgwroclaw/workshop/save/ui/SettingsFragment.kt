package pl.gdgwroclaw.workshop.save.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_settings.*
import pl.gdgwroclaw.workshop.save.R

private const val USER_NAME_KEY = "user_name"
private const val NOTIFICATIONS_ENABLED_KEY = "notifications_enabled"

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = PreferenceManager.getDefaultSharedPreferences(requireContext())

        nameEditText.setText(preferences.getString(USER_NAME_KEY, null))
        notificationsCheckBox.isChecked = preferences.getBoolean(NOTIFICATIONS_ENABLED_KEY, false)

        saveButton.setOnClickListener {
            preferences.edit {
                putString(USER_NAME_KEY, nameEditText.text.toString())
                putBoolean(NOTIFICATIONS_ENABLED_KEY, notificationsCheckBox.isChecked)
            }
        }
    }
}
