package com.example.ethereumblockchainapp.view

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ethereumblockchainapp.R
import com.example.ethereumblockchainapp.common.BaseFragment
import com.example.ethereumblockchainapp.databinding.FragmentInputBinding
import com.example.ethereumblockchainapp.viewmodel.BlockChainViewModel

class InputFragment : BaseFragment() {

    private lateinit var binding: FragmentInputBinding
    private val blockChainViewModel: BlockChainViewModel by activityViewModels()
    private var clipboardManager: ClipboardManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInputBinding.bind(view)

        clipboardManager =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?

        initListener()
    }

    private fun initListener() {
        binding.buttonClear.setOnClickListener {
            clearedEditTextField()
        }

        binding.buttonPaste.setOnClickListener {
            pasteCopiedDataToEditText()
        }

        binding.buttonGetBlockDetails.setOnClickListener {
            inputETHPublicAddressToGetInfo()
        }

        binding.buttonGetHelp.setOnClickListener {
            findNavController().navigate(R.id.action_inputFragment_to_helpFragment)
        }
    }

    private fun inputETHPublicAddressToGetInfo() {
        val ethAddress = binding.editTextETHAddress.text.toString().trim()
        if (ethAddress.isEmpty()) {
            binding.editTextETHAddress.error = "Input blockchain address"
            return
        }
        // Get blockchain information details and go to the details screen to show details
        blockChainViewModel.getBlockChainDetails(ethAddress)
        findNavController().navigate(R.id.action_inputFragment_to_resultFragment)
    }

    private fun clearedEditTextField() {
        binding.editTextETHAddress.text.clear()
        showToast("Cleared")
    }

    private fun pasteCopiedDataToEditText() {
        // Paste copied data into the edittext field
        val pasteItem = clipboardManager?.primaryClip?.getItemAt(0)
        val pasteValue = pasteItem?.text
        if (pasteValue?.isNotEmpty() == true) {
            binding.editTextETHAddress.text =
                Editable.Factory.getInstance().newEditable(pasteValue)
        } else {
            showToast("No value copied")
        }
    }

}