package com.itproger.lovecalculator.sharepreferences.board.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.itproger.lovecalculator.R
import com.itproger.lovecalculator.databinding.ItemBoardBinding
import com.itproger.lovecalculator.sharepreferences.board.BoardModel

class OnBoardAdapter(val click: () -> Unit) : Adapter<OnBoardAdapter.OnBoardingViewHolder>() {

    private val list = listOf (
        BoardModel("Title1", "Description1", R.raw.animation_1),
        BoardModel("Title2","Description2", R.raw.animation_2),
        BoardModel("Title3", "Description3", R.raw.animation_3),
        BoardModel("Title4", "Description4", R.raw.animation_4)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
           return OnBoardingViewHolder(
               ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
           )
    }
    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.Onbind(list[position])
    }

    override fun getItemCount(): Int = list.size


    inner class OnBoardingViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun Onbind(onBoardModel: BoardModel) {
            with(binding) {
                titleBoard.text = onBoardModel.title
                descriptionBoard.text = onBoardModel.description
                lottieAnimation.setAnimation(onBoardModel.image)
                buttonBoard.isVisible = adapterPosition == list.lastIndex
                buttonBoard.setOnClickListener {
                    click()
                }
            }
        }
    }
}