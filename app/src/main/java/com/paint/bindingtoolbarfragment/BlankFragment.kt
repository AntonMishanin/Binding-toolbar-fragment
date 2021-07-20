package com.paint.bindingtoolbarfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.paint.bindingtoolbarfragment.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private var isVIewVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        initVIew()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initVIew() {
        binding.titleeee.text = "dsdsd"
        binding.layoutInFragment.buttonInLayout.setOnClickListener {
            if (isVIewVisible) {
                showView()
            } else {
                hideView()
            }
            isVIewVisible = !isVIewVisible
        }
    }

    private fun showView() {
        Log.d("WW", "SHOW")
        binding.titleeee.showWithAnimation()
    }

    private fun hideView() {
        Log.d("WW", "HIDE")
        binding.titleeee.hideWithAnimation()
    }
}