package com.agus18104002.pertemuan3.ui.setlistpokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.agus18104002.pertemuan3.R
import com.agus18104002.pertemuan3.models.PokemonSet
import com.agus18104002.pertemuan3.repositories.PokemonSetRepository
import kotlinx.android.synthetic.main.fragment_set_list.*

class SetListFragment : Fragment() {
    private val vm: SetListViewModel by viewModels {
        SetListFactory(
                PokemonSetRepository.instance
        )
    }
    private lateinit var adapter: SetListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_set_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SetListAdapter()
        rvSet.adapter = adapter

        val factory = SetListFactory(
            PokemonSetRepository.instance
        )
        vm.apply {
            viewState.observe(viewLifecycleOwner, Observer(this@SetListFragment::handleState))
            srlSet.setOnRefreshListener { getSets() }
        }
    }

    private fun handleState(viewState: SetListViewState?) {
        viewState?.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<PokemonSet>) {
        adapter.updateData(data)
        tvSetError.visibility = View.GONE
        rvSet.visibility = View.VISIBLE
    }

    private fun showError(error: Exception) {
        tvSetError.text = error.message
        tvSetError.visibility = View.VISIBLE
        rvSet.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {
        srlSet.isRefreshing = loading
    }
}