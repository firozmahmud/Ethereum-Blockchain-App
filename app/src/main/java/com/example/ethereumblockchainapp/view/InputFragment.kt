package com.example.ethereumblockchainapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ethereumblockchainapp.R
import com.example.ethereumblockchainapp.databinding.FragmentInputBinding
import com.example.ethereumblockchainapp.viewmodel.BlockChainViewModel

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding
    private val blockChainViewModel: BlockChainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInputBinding.bind(view)

        initListener()
    }

    private fun initListener() {
        binding.buttonGetBlockDetails.setOnClickListener {
            val ethAddress = binding.editTextETHAddress.text.toString().trim()
            if (ethAddress.isEmpty()) {
                binding.editTextETHAddress.error = "Input blockchain address"
                return@setOnClickListener
            }

            blockChainViewModel.getBlockChainDetails(ethAddress)
            findNavController().navigate(R.id.action_inputFragment_to_resultFragment)
        }
    }

}