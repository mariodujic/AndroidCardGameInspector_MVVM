package com.groundzero.legends.ui.decks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.groundzero.legends.R
import com.groundzero.legends.ui.shared.BaseFragment

class DecksFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTitleSubject.onNext(resources.getString(R.string.decks_fragment_title))
        return inflater.inflate(R.layout.fragment_decks, container, false)
    }
}
