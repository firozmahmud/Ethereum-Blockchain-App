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

        observeLiveData()
    }

    private fun observeLiveData() {
        // Observe blockchain balance
        blockChainViewModel.ethBalance.observe(viewLifecycleOwner) { balance ->
            if (balance == null) {
                binding.textViewBlockChainBalance.text = "No balance found. Please try again."
            } else {
                binding.textViewBlockChainBalance.text = "Balance: " + balance + " Ether"
            }
            binding.progressBarBalance.visibility = ProgressBar.GONE
        }

        // Observe blockchain nonce
        blockChainViewModel.ethNonce.observe(viewLifecycleOwner) { nonce ->
            if (nonce == null) {
                binding.textViewNonce.text = "Nonce not found"
            } else {
                binding.textViewNonce.text = "Nonce: " + nonce
            }
            binding.progressBarNonce.visibility = ProgressBar.GONE
        }
    }
}