package com.groundzero.legends.decks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.groundzero.legends.R
import com.groundzero.legends.shared.core.BaseFragment

const val FRAGMENT_TITLE = "Your Decks"

class DecksFragment : BaseFragment(FRAGMENT_TITLE) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_decks, container, false)
    }
}
