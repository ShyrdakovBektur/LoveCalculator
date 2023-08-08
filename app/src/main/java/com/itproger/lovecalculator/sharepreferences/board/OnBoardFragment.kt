package com.itproger.lovecalculator.sharepreferences.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Insert
import com.google.android.material.tabs.TabLayoutMediator
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.databinding.FragmentOnBoardFragmentBinding
import com.itproger.lovecalculator.sharepreferences.board.adapter.OnBoardAdapter
import com.itproger.lovecalculator.sharepreferences.preferences.Preference
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {
@Inject
    lateinit var preference: Preference

    private lateinit var binding: FragmentOnBoardFragmentBinding
    private val adapter = OnBoardAdapter(this::click)


    private fun click(){
        preference.saveBoardState()
        findNavController().navigate(R.id.namesFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardFragmentBinding.inflate(inflater , container, false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.boardTabIndicator, binding.viewPager) {tag, _ ->
            tag.setIcon(R.drawable.tab_indicator)
        }.attach()
    }
}