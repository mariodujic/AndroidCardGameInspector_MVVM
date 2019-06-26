package com.groundzero.legends.cards.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.legends.R
import com.groundzero.legends.cards.adapters.CardsAdapter
import com.groundzero.legends.cards.viewmodel.CardsViewModel
import com.groundzero.legends.shared.ui.dialogs.DecksDialog
import com.groundzero.legends.shared.ui.fragments.BaseFragment
import com.groundzero.legends.shared.listeners.RecyclerViewListener
import com.groundzero.legends.shared.models.Card
import com.groundzero.legends.shared.utils.FragmentNavigationUtils

const val FRAGMENT_TITLE = "All Cards"

class AllCardsFragment : BaseFragment(FRAGMENT_TITLE), RecyclerViewListener {

    private lateinit var viewModel: CardsViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_cards, container, false)
        viewModel = ViewModelProviders.of(activity!!, cardsViewFactory()).get(CardsViewModel::class.java)

        recyclerView = view.findViewById(R.id.cards_recycler_view)
        setRecyclerPreferences()
        subscribeCards()

        return view
    }

    private fun setRecyclerPreferences() {
        val linearLayoutManager = GridLayoutManager(context, 2)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
    }

    private fun subscribeCards() {
        viewModel.getCards().observe(viewLifecycleOwner, Observer { result ->
            if (result != null) {
                recyclerView.adapter = CardsAdapter(context!!, this, result.cards)
            } else {
                showErrorToast(resources.getString(R.string.error_unable_to_fetch_cards))
            }
        })
    }

    override fun openSingleCardListener(card: Card): View.OnClickListener {
        return View.OnClickListener { view ->
            run {
                viewModel.onCardSelect(card)
                FragmentNavigationUtils.openFragment(view, R.id.singleCardFragment)
            }
        }
    }

    override fun addCardToDeckListener(card: Card): View.OnClickListener {
        return View.OnClickListener {
            run {
                FragmentNavigationUtils.openDialog(fragmentManager!!, DecksDialog(), "deck_dialog")
            }
        }
    }
}
