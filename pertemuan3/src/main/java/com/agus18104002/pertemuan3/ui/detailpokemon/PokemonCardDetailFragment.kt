package com.agus18104002.pertemuan3.ui.detailpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.agus18104002.pertemuan3.R
import com.agus18104002.pertemuan3.models.PokemonCard
import kotlinx.android.synthetic.main.fragment_pokemon_card_detail.*


class PokemonCardDetailFragment : Fragment() {
    private val vm: PokemonCardDetailViewModel by viewModels()

    private val args: PokemonCardDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_pokemon_card_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonCard = args.pokemonCard
        vm.apply {
            viewState.observe(
                viewLifecycleOwner,
                Observer(this@PokemonCardDetailFragment::handleState)
            )
            pokemonCard?.let {
                setData(pokemonCard)
            }
        }
    }

    private fun handleState(viewState: PokemonCardDetailViewState) {
        viewState.data?.let { showDetail(it) }
    }

    private fun showDetail(data: PokemonCard) {
        Glide.with(this)
            .load(data.image)
            .into(ivLogo)

        tvName.text = data.name
        tvRarity.text = data.rarity
        tvSeries.text = data.series
    }
}
