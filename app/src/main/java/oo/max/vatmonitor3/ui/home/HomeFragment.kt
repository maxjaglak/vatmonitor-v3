package oo.max.vatmonitor3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import oo.max.vatmonitor3.R
import oo.max.vatmonitor3.core.extension.gone
import oo.max.vatmonitor3.core.extension.visible
import oo.max.vatmonitor3.databinding.FragmentHomeBinding


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by hiltNavGraphViewModels(R.id.main_navigation)

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupLiveData()
        setupLayout()
        return binding.root
    }

    private fun setupLiveData() {
        homeViewModel.nipStatus.observe(viewLifecycleOwner, Observer {
            bindNipStatusData(it)
        })
        homeViewModel.progress.observe(viewLifecycleOwner, { showProgress ->
            if (showProgress) _binding?.progressContainer?.visible()
            else _binding?.progressContainer?.gone()
        })
    }

    private fun bindNipStatusData(nipStatusData: NipStatusData?) {
        if (nipStatusData == null) {
            _binding?.resultTextOk?.gone()
            _binding?.resultTextNotValid?.gone()
        } else {
            if (nipStatusData.isValidVatPayer) {
                _binding?.resultTextOk?.visible()
                _binding?.resultTextNotValid?.gone()
            } else {
                _binding?.resultTextOk?.gone()
                _binding?.resultTextNotValid?.visible()
            }
        }
    }

    private fun setupLayout() {
        _binding?.checkStatusButton?.setOnClickListener {
            _binding?.nipEdit?.let {
                val nip = it.text.toString()
                homeViewModel.checkButtonClicked(nip)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}