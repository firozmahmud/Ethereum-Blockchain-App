package com.example.ethereumblockchainapp.model

import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetTransactionCount
import org.web3j.protocol.http.HttpService
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeoutException

class BlockChainRepository {
    /**
     * API KEY
     * 79437ae17dfd4a2dae17531caa28598f
     * Ethereum server
     * https://mainnet.infura.io/v3/79437ae17dfd4a2dae17531caa28598f
     */

    private val web3jClient: Web3j =
        Web3j.build(HttpService("https://mainnet.infura.io/v3/79437ae17dfd4a2dae17531caa28598f"))

    fun getETHBalance(ethAddress: String?): String {
        var ethBalance = ""

        try {
            val balanceResponse =
                web3jClient.ethGetBalance(ethAddress, DefaultBlockParameterName.LATEST)
                    .sendAsync().get()

            val unscaledBalance = balanceResponse.balance
            val scaledBalance = BigDecimal(unscaledBalance)
                .divide(BigDecimal(1000000000000000000L), 18, RoundingMode.HALF_UP)

            ethBalance = "" + scaledBalance
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } catch (e: TimeoutException) {
            e.printStackTrace()
        }
        return ethBalance
    }

    fun getETHNonce(ethAddress: String?): String {
        var ethGetTransactionCount: EthGetTransactionCount? = null

        try {
            ethGetTransactionCount = web3jClient.ethGetTransactionCount(
                ethAddress, DefaultBlockParameterName.LATEST
            ).sendAsync().get()
        } catch (e: ExecutionException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        var ethNonce: BigInteger? = null
        if (ethGetTransactionCount != null) {
            ethNonce = ethGetTransactionCount.transactionCount
        }
        return "" + ethNonce
    }
}