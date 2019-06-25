package com.groundzero.legends.shared.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.groundzero.legends.R
import com.groundzero.legends.cards.viewmodel.CardsViewModel
import com.groundzero.legends.shared.dialogs.DecksDialog
import com.groundzero.legends.shared.listeners.CardToDeckListener
import com.groundzero.legends.shared.models.Card
import com.groundzero.legends.shared.utils.FragmentNavigationUtils
import kotlinx.android.synthetic.main.fragment_single_card.*
import kotlinx.android.synthetic.main.fragment_single_card.view.*

const val FRAGMENT_TITLE = "Single Card"

class SingleCardFragment : BaseFragment(FRAGMENT_TITLE), CardToDeckListener {

    private lateinit var viewModel: CardsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_single_card, container, false)
        viewModel = ViewModelProviders.of(activity!!, cardsViewFactory()).get(CardsViewModel::class.java)
        viewModel.getSelectedCard().observe(viewLifecycleOwner, Observer { card ->
            run {
                loadViews(card)
                loadViewListeners(view, card)
            }
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