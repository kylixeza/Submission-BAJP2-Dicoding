package com.kylix.submissionbajp2.ui.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.kylix.submissionbajp2.R

class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title
    }
}