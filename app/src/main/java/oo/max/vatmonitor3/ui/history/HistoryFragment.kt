package oo.max.vatmonitor3.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import oo.max.vatmonitor3.R
import oo.max.vatmonitor3.databinding.FragmentHistoryBinding
import oo.max.vatmonitor3.ui.history.adapter.NipNumbersAdapter

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by hiltNavGraphViewModels(R.id.main_navigation)
    private var _binding: FragmentHistoryBinding? = null

    private val binding get() = _binding!!
    private var adapter: NipNumbersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        setupAdapter()

        historyViewModel.listOfNipNumbers.observe(viewLifecycleOwner, { data ->
            adapter?.updateItems(data)
        })

        return binding.root
    }

    private fun setupAdapter() {
        adapter = NipNumbersAdapter(requireContext())
        _binding?.nipNumbersRecycler?.adapter = adapter
        _binding?.nipNumbersRecycler?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        historyViewModel.viewLoaded()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}