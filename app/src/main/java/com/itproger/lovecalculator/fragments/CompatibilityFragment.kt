package com.itproger.lovecalculator.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itproger.lovecalculator.databinding.FragmentCompatibilityBinding
import com.itproger.lovecalculator.retrofit.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("DEPRECATION")
class CompatibilityFragment : Fragment() {

    private var _binding: FragmentCompatibilityBinding? = null
    private val binding get() = _binding!!
    private var loveModel: LoveModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompatibilityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loveModel = arguments?.getSerializable(NamesFragment.KEY) as LoveModel
        initTextView()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            callBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun initTextView() {
        with(binding) {
            tvBoy.text = loveModel?.firstName.toString()
            tvGirl.text = loveModel?.secondName.toString()
            result.text = loveModel?.percentage.toString() + "%"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

