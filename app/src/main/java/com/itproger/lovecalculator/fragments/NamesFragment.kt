package com.itproger.lovecalculator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.databinding.FragmentNamesBinding
import com.itproger.lovecalculator.room.LoveDao
import com.itproger.lovecalculator.mvvm.LoveViewModel
import com.itproger.lovecalculator.sharepreferences.preferences.Preference
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NamesFragment : Fragment() {

    @Inject
    lateinit var preference: Preference

    @Inject
    lateinit var loveDao: LoveDao
    private var _binding: FragmentNamesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         initiClicker()
        if (!preference.isBoardShow()) {
            findNavController().navigate(R.id.onBoardFragment)
        }
    }

    private fun initiClicker() {
        with(binding) {
         history.setOnClickListener {
             findNavController().navigate(R.id.historyActivity)
         }
           btnLove.setOnClickListener {
               viewModel.getLiveData(edtFname.text.toString(), edtSname.text.toString()).observe(viewLifecycleOwner) {loveModel ->
                   findNavController().navigate(R.id.compatibilityFragment, bundleOf(KEY to loveModel))
               }
           }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        const val KEY = "LoveModel"
    }
}