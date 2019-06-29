package com.groundzero.legends.ui.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.groundzero.legends.R

/**
 * Shows all the decks in local database. User can add new deck from this dialog.
 */

class DecksDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_fragment_decks, container, false)

        return view
    }
}