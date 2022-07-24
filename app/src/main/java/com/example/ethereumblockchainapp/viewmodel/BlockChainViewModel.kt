package com.example.ethereumblockchainapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ethereumblockchainapp.model.BlockChainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlockChainViewModel : ViewModel() {
    private val blockChainRepository = BlockChainRepository()

    val ethBalance = MutableLiveData<String>()
    val ethNonce = MutableLiveData<String>()

    fun getBlockChainDetails(ethAddress: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getETHBalance(ethAddress)
            getNonce(ethAddress)
        }
    }

    private fun getETHBalance(ethAddress: String) {
        ethBalance.postValue(blockChainRepository.getETHBalance(ethAddress))
    }

    private fun getNonce(ethAddress: String) {
        ethNonce.postValue(blockChainRepository.getETHNonce(ethAddress))
    }
}