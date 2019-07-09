package com.groundzero.legends.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.legends.R
import com.groundzero.legends.data.shared.Card
import com.groundzero.legends.ui.shared.BaseFragment
import com.groundzero.legends.ui.shared.DecksDialog
import com.groundzero.legends.ui.shared.SingleCardListener
import com.groundzero.legends.utils.FragmentNavigationUtils
import kotlinx.android.synthetic.main.fragment_all_cards.view.*

class AllCardsFragment : BaseFragment(), SingleCardListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_cards, container, false)
        fragmentTitleSubject.onNext(resources.getString(R.string.cards_fragment_title))
        cardsViewModel.onActive()
        setRecyclerPreferences(view)
        subscribeCards(view)
        return view
    }

    private fun setRecyclerPreferences(view: View) {
        val linearLayoutManager = GridLayoutManager(context, 2)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        view.cards_recycler_view.setHasFixedSize(true)
        view.cards_recycler_view.layoutManager = linearLayoutManager
    }

    private fun subscribeCards(view: View) {
        cardsViewModel.getCards().observe(viewLifecycleOwner, Observer { result ->
            if (result != null) {
                view.cards_recycler_view.adapter = CardsAdapter(context!!, this, result.cards)
            } else {
                showErrorToast(resources.getString(R.string.error_unable_to_fetch_cards))
            }
        })
    }

    override fun openSingleCardListener(card: Card): View.OnClickListener {
        return View.OnClickListener { view ->
            run {
                cardsViewModel.onCardSelect(card)
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

    override fun onDestroy() {
        super.onDestroy()
        cardsViewModel.onClear()
    }
}
