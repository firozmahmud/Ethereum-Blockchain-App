package com.example.ethereumblockchainapp.common

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    /**
     * For common method and properties
     */
    protected fun showToast(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }
}