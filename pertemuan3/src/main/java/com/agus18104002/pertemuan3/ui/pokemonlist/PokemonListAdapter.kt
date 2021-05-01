package com.agus18104002.pertemuan3.ui.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.agus18104002.pertemuan3.R
import com.agus18104002.pertemuan3.models.PokemonCard
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_pokemon.view.*


class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    private val pokemonCards = mutableListOf<PokemonCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        )

    override fun getItemCount() = pokemonCards.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokemonCards[position])
    }

    fun updateData(newPokemonCards: MutableList<PokemonCard>) {
        pokemonCards.clear()
        pokemonCards.addAll(newPokemonCards)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(pokemonCard: PokemonCard) {
            Glide.with(containerView!!)
                .load(pokemonCard.image)
                .into(itemView.ivCardLogo)

            itemView.tvCardName.text = pokemonCard.name
            itemView.tvCardRarity.text = pokemonCard.rarity

            containerView?.setOnClickListener { view ->
                val action =
                    PokemonListFragmentDirections.actionPokemonListFragmentToPokemonCardDetailFragment(
                        pokemonCard,
                        pokemonCard.name!!
                    )
                view.findNavController().navigate(action)
            }
        }
    }
}