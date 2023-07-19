package com.itproger.lovecalculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.databinding.FragmentNamesBinding


class NamesFragment : Fragment() {
    private lateinit var binding: FragmentNamesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send()
    }

    private fun send() {
        binding.btnLove.setOnClickListener {
            val fname = binding.edtFname.text.toString()
            val sname = binding.edtSname.text.toString()
            val bundle = Bundle()
            bundle.putString("fname", fname)
            bundle.putString("sname", sname)
            findNavController().navigate(R.id.compatibilityFragment, bundle)
        }
    }
}