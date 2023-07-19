package com.itproger.lovecalculator.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.databinding.FragmentCompatibilityBinding
import com.itproger.lovecalculator.retrofit.LoveModel
import com.itproger.lovecalculator.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompatibilityFragment : Fragment() {
    private lateinit var binding: FragmentCompatibilityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompatibilityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        val arguments = arguments
        if (arguments != null) {
            binding.tvBoy.text = arguments.getString("fname")
            binding.tvGirl.text = arguments.getString("sname")

            val retrofitService = RetrofitService()
            retrofitService.api.getPercentage(
                binding.tvBoy.text.toString(), binding.tvGirl.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    binding.result.text = response.body()?.percentage
                }

                @SuppressLint("SetTextI18n")
                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    binding.result.text = "Error: ${t.message}"
                }
            })

            binding.callBack.setOnClickListener {
                findNavController().navigate(R.id.namesFragment)
            }
        }
    }
}
