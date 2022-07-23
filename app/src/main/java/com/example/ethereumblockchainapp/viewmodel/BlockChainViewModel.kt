package com.example.ethereumblockchainapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ethereumblockchainapp.model.BlockChainRepository

class BlockChainViewModel : ViewModel() {
    private val blockChainRepository = BlockChainRepository()

    val ethBalance = MutableLiveData<String>()
    val nonce = MutableLiveData<String>()

    fun getBlockChainDetails(ethAddress: String) {
        getETHBalance(ethAddress)
        getNonce(ethAddress)
    }

    private fun getETHBalance(ethAddress: String) {
        ethBalance.postValue(blockChainRepository.getETHBalance(ethAddress))
    }

    private fun getNonce(ethAddress: String) {
        nonce.postValue(blockChainRepository.getETHNonce(ethAddress))
    }
}