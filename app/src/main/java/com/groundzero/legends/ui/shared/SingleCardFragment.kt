package com.groundzero.legends.ui.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.groundzero.legends.R
import com.groundzero.legends.data.shared.Card
import com.groundzero.legends.utils.FragmentNavigationUtils
import kotlinx.android.synthetic.main.fragment_single_card.*
import kotlinx.android.synthetic.main.fragment_single_card.view.*

class SingleCardFragment : BaseFragment(), CardToDeckListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_single_card, container, false)
        fragmentTitleSubject.onNext(resources.getString(R.string.single_card_fragment_title))
        cardsViewModel.getSelectedCard().observe(viewLifecycleOwner, Observer { card ->
            loadViews(card)
            loadViewListeners(view, card)
        })
        return view
    }

    private fun loadViews(card: Card) {

        card_title.text = resources.getString(R.string.card_title, card.name)
        card_rarity.text = resources.getString(R.string.card_rarity, card.rarity)
        card_type.text = resources.getString(R.string.card_type, card.type)
        card_soul_summon.text = resources.getString(R.string.card_soul_summon, card.soulSummon)
        card_soul_trap.text = resources.getString(R.string.card_soul_trap, card.soulTrap)

        Glide.with(this)
            .load(card.imageUrl)
            .placeholder(R.drawable.loading_image)
            .into(card_image)
    }

    private fun loadViewListeners(view: View, card: Card) {
        view.add_to_deck.setOnClickListener(addCardToDeckListener(card))
    }

    override fun addCardToDeckListener(card: Card): View.OnClickListener {
        return View.OnClickListener {
            run {
                FragmentNavigationUtils.openDialog(fragmentManager!!, DecksDialog(), "deck_dialog")
            }
        }
    }
}