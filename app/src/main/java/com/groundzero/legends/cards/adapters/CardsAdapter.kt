package com.groundzero.legends.cards.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.groundzero.legends.R
import com.groundzero.legends.shared.listeners.RecyclerViewListener
import com.groundzero.legends.shared.models.Card

class CardsAdapter(
    private val context: Context,
    private val listener: RecyclerViewListener,
    private val cards: List<Card>
) : RecyclerView.Adapter<CardsAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(context)

        return CustomViewHolder(inflater, parent, listener)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, index: Int) {
        val card: Card = cards[index]
        holder.bind(card)

        holder.itemView.setOnClickListener(listener.openSingleCardListener(card))
    }

    class CustomViewHolder(inflater: LayoutInflater, parent: ViewGroup, private var listener: RecyclerViewListener) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_all_cards, parent, false)) {
        private var image: ImageView? = null
        private var button: Button? = null

        init {
            image = itemView.findViewById(R.id.image)
            button = itemView.findViewById(R.id.add_to_deck)
        }

        fun bind(card: Card) {

            Glide.with(itemView)
                .load(card.imageUrl)
                .placeholder(R.drawable.loading_image)
                .into(image!!)

            button!!.setOnClickListener(listener.addCardToDeckListener(card))
        }
    }
}