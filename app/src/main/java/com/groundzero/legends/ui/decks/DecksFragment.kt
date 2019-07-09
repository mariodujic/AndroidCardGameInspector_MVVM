package com.groundzero.legends.ui.decks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.legends.R
import com.groundzero.legends.ui.cards.CardsAdapter
import com.groundzero.legends.ui.shared.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_cards.view.*
import kotlinx.android.synthetic.main.fragment_decks.*
import kotlinx.android.synthetic.main.fragment_decks.view.*

class DecksFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_decks, container, false)
        fragmentTitleSubject.onNext(resources.getString(R.string.decks_fragment_title))
        decksViewModel.onActive()
        setRecyclerPreferences(view)
        subscribeDecks(view)
        view.insert_deck.setOnClickListener{onInsert()}
        return view
    }

    private fun setRecyclerPreferences(view: View) {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        view.decks_recycler_view.setHasFixedSize(true)
        view.decks_recycler_view.layoutManager = linearLayoutManager
    }

    private fun subscribeDecks(view: View) {
        decksViewModel.getDecksLiveData().observe(viewLifecycleOwner, Observer { result ->
            if (result != null) {
                view.decks_recycler_view.adapter = DecksAdapter(context!!, result)
            } else {
                showErrorToast(resources.getString(R.string.error_unable_to_fetch_cards))
            }
        })
    }

    private fun onInsert() {
        decksViewModel.onInsert()
    }

    override fun onDestroy() {
        super.onDestroy()
        decksViewModel.onClear()
    }
}
