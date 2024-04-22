package com.example.dummyproject

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyproject.data.response.InformationItem
import com.example.dummyproject.databinding.RowItemBinding

class MainAdapter(val userList: List<InformationItem>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.titleTv.text = currentItem.name
        holder.binding.subTitleTv.text = currentItem.username
        holder.binding.tvAddress.text = currentItem.address.toString()

        if (currentItem.isExpanded) {
            holder.binding.btnAction.rotation = 180f
            //holder.binding.btnAction.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
            holder.binding.dropDownView.visibility = VISIBLE
        } else {
            holder.binding.btnAction.rotation = 0f
            //holder.binding.btnAction.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            holder.binding.dropDownView.visibility = GONE

        }

        holder.binding.btnAction.setOnClickListener {
            updateSelection(position)
        }
    }

    class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    // selected item is only expandable

    private fun updateSelection(position: Int) {
        userList.forEachIndexed { index, informationItem ->
            if(index == position){
                informationItem.isExpanded = !informationItem.isExpanded
            }else {
                informationItem.isExpanded = false
            }
        }
        notifyItemRangeChanged(0,userList.size)
    }
}