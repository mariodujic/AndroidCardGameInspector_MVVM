package com.groundzero.legends.shared.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation

internal object FragmentNavigationUtils {

    fun openFragment(view: View, fragmentId: Int) {
        Navigation.findNavController(view).navigate(fragmentId)
    }

    fun openDialog(fragmentManager: FragmentManager, fragment: Fragment, fragmentId: String) {
        fragmentManager.beginTransaction().add(fragment, fragmentId).commit()
    }
}
