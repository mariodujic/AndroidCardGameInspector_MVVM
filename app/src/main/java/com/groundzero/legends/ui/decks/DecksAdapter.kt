package com.groundzero.legends.ui.decks

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.legends.R
import com.groundzero.legends.data.persistence.decks.DeckEntity
import kotlinx.android.synthetic.main.item_decks.view.*

class DecksAdapter(
    private val context: Context,
    private val decks: List<DeckEntity>
) : RecyclerView.Adapter<DecksAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(context)
        return CustomViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return decks.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, index: Int) {
        val deck: DeckEntity = decks[index]
        holder.bind(deck)
    }

    class CustomViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_decks, parent, false)) {
        private var name: TextView = itemView.name

        fun bind(deck: DeckEntity) {
            name.text = deck.name
        }
    }
}