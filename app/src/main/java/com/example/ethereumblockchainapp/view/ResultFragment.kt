package com.example.ethereumblockchainapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.activityViewModels
import com.example.ethereumblockchainapp.R
import com.example.ethereumblockchainapp.common.BaseFragment
import com.example.ethereumblockchainapp.databinding.FragmentResultBinding
import com.example.ethereumblockchainapp.viewmodel.BlockChainViewModel

class ResultFragment : BaseFragment() {

    private lateinit var binding: FragmentResultBinding
    private val blockChainViewModel: BlockChainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)
    }

    override fun onResume() {
        super.onResume()
        initViews()
        observeLiveData()
    }

    private fun initViews() {
        // Init the screen when visible everytime
        setETHBalance("Getting balance...")
        setETHNonce("Getting nonce...")
        viewAllLoader()
    }

    override fun onStop() {
        super.onStop()
        blockChainViewModel.clear()
    }

    private fun observeLiveData() {
        // Observe blockchain balance
        blockChainViewModel.ethBalanceLiveData.observe(viewLifecycleOwner) { balance ->
            if (balance == null) return@observe
            setETHBalance(balance)
            hideLoader(binding.progressBarBalance)
        }

        // Observe blockchain nonce
        blockChainViewModel.ethNonceLiveData.observe(viewLifecycleOwner) { nonce ->
            if (nonce == null) return@observe
            setETHNonce(nonce)
            hideLoader(binding.progressBarNonce)
        }
    }

    private fun viewAllLoader() {
        binding.progressBarBalance.visibility = ProgressBar.VISIBLE
        binding.progressBarNonce.visibility = ProgressBar.VISIBLE
    }

    private fun hideLoader(progressBar: ProgressBar) {
        progressBar.visibility = ProgressBar.GONE
    }

    private fun setETHBalance(balance: String) {
        binding.textViewBlockChainBalance.text = balance
    }

    private fun setETHNonce(nonce: String) {
        binding.textViewNonce.text = nonce
    }
}
