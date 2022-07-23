package com.example.ethereumblockchainapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ethereumblockchainapp.R
import com.example.ethereumblockchainapp.databinding.FragmentResultBinding
import com.example.ethereumblockchainapp.viewmodel.BlockChainViewModel

class ResultFragment : Fragment() {

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
        blockChainViewModel.ethBalance.observe(viewLifecycleOwner) { balance ->
            if (balance.isNullOrEmpty()) {
                binding.textViewBlockChainBalance.text = "No balance found"
            } else {
                binding.textViewBlockChainBalance.text = "Balance: " + balance + " Ether"
            }
        }

        blockChainViewModel.nonce.observe(viewLifecycleOwner) { nonce ->
            if (nonce.isNullOrEmpty()) {
                binding.textViewNonce.text = "Nonce not found"
            } else {
                binding.textViewNonce.text = "Nonce: " + nonce
            }
        }
    }
}