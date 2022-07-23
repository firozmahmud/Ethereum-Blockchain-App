package com.example.ethereumblockchainapp.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ethereumblockchainapp.R
import com.example.ethereumblockchainapp.common.BaseFragment
import com.example.ethereumblockchainapp.databinding.FragmentHelpBinding


class HelpFragment : BaseFragment() {

    private lateinit var binding: FragmentHelpBinding
    private var clipboardManager: ClipboardManager? = null
    private var clipData: ClipData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHelpBinding.bind(view)

        clipboardManager = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        initListener()
    }

    private fun initListener() {
        binding.buttonCopyBlock1.setOnClickListener {
            clipData = ClipData.newPlainText("text", binding.textViewBlock1.text)
            clipboardManager?.setPrimaryClip(clipData as ClipData)
            showToast("Copied")
        }

        binding.buttonCopyBlock2.setOnClickListener {
            clipData = ClipData.newPlainText("text", binding.textViewBlock2.text)
            clipboardManager?.setPrimaryClip(clipData as ClipData)
            showToast("Copied")
        }

        binding.buttonClickToVisit.setOnClickListener {
            // Go to etherscan site
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://etherscan.io/"))
            startActivity(browserIntent)
        }
    }
}