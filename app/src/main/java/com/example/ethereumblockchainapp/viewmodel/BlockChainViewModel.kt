package com.example.ethereumblockchainapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ethereumblockchainapp.model.BlockChainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlockChainViewModel : ViewModel() {
    private val blockChainRepository = BlockChainRepository()

    val ethBalanceLiveData = MutableLiveData<String>()
    val ethNonceLiveData = MutableLiveData<String>()

    fun getBlockChainDetails(ethAddress: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getETHBalance(ethAddress)
            getNonce(ethAddress)
        }
    }

    private fun getETHBalance(ethAddress: String) {
        var balance = blockChainRepository.getETHBalance(ethAddress)
        balance = when (balance.trim().isEmpty()) {
            true -> "No balance found. Please try again."
            else -> "Balance: $balance Ether"
        }
        ethBalanceLiveData.postValue(balance)
    }

    private fun getNonce(ethAddress: String) {
        var nonce = blockChainRepository.getETHNonce(ethAddress)
        nonce = when (nonce.trim().isEmpty()) {
            true -> "Nonce not found"
            else -> "Nonce: $nonce"
        }
        ethNonceLiveData.postValue(nonce)
    }

    fun clear() {
        ethBalanceLiveData.value = null
        ethNonceLiveData.value = null
    }
}