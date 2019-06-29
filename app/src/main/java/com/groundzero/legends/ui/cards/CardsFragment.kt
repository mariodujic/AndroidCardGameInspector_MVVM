package com.groundzero.legends.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.legends.R
import com.groundzero.legends.ui.shared.BaseFragment
import com.groundzero.legends.data.Card
import com.groundzero.legends.ui.shared.DecksDialog
import com.groundzero.legends.ui.shared.SingleCardListener
import com.groundzero.legends.utils.FragmentNavigationUtils
import kotlinx.android.synthetic.main.fragment_all_cards.view.*

const val FRAGMENT_TITLE = "All Cards"

class AllCardsFragment : BaseFragment(FRAGMENT_TITLE), SingleCardListener {

    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_all_cards, container, false)
        setRecyclerPreferences()
        subscribeCards()
        return mView
    }

    private fun setRecyclerPreferences() {
        val linearLayoutManager = GridLayoutManager(context, 2)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        mView.cards_recycler_view.setHasFixedSize(true)
        mView.cards_recycler_view.layoutManager = linearLayoutManager
    }

    private fun subscribeCards() {
        viewModel.getCards().observe(viewLifecycleOwner, Observer { result ->
            if (result != null) {
                mView.cards_recycler_view.adapter = CardsAdapter(context!!, this, result.cards)
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
