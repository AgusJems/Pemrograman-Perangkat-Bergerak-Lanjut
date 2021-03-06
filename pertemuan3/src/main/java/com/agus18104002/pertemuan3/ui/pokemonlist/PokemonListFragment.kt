package com.agus18104002.pertemuan3.ui.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.agus18104002.pertemuan3.R
import com.agus18104002.pertemuan3.models.PokemonCard
import com.agus18104002.pertemuan3.repositories.PokemonCardRepository
import kotlinx.android.synthetic.main.fragment_pokemon_list.*


class PokemonListFragment : Fragment() {
    private val vm: PokemonListViewModel by viewModels {
        PokemonListViewModelFactory(
                PokemonCardRepository.instance
        )
    }
    private lateinit var adapter: PokemonListAdapter

    private val args: PokemonListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PokemonListAdapter()
        rvCard.adapter = adapter

        val factory =
            PokemonListViewModelFactory(
                PokemonCardRepository.instance
            )
        vm.apply {
            viewState.observe(
                viewLifecycleOwner,
                Observer(this@PokemonListFragment::handleState)
            )
            if (viewState.value?.data == null) getPokemons(args.setName)
            srlCard.setOnRefreshListener { getPokemons(args.setName) }
        }
    }

    private fun handleState(viewState: PokemonListViewState?) {
        viewState?.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<PokemonCard>) {
        adapter.updateData(data)
        tvCardError.visibility = View.GONE
        rvCard.visibility = View.VISIBLE
    }

    private fun showError(error: Exception) {
        error.printStackTrace()
        tvCardError.text = error.message
        tvCardError.visibility = View.VISIBLE
        rvCard.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {
        srlCard.isRefreshing = loading
    }
}
