package com.example.cybersail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cybersail.MainActivity
import com.example.cybersail.databinding.TabBinding
import com.google.android.material.snackbar.Snackbar

class TabAdapter(private val context: Context, private val dialog: androidx.appcompat.app.AlertDialog) : RecyclerView.Adapter<TabAdapter.MyHolder>() {

    class MyHolder(binding: TabBinding) : RecyclerView.ViewHolder(binding.root) {
        val cancelBtn =binding.cancelBtn
        val name = binding.tabName
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(TabBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return MainActivity.tabsList.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text=MainActivity.tabsList[position].name
        holder.root.setOnClickListener{
            MainActivity.myPager.currentItem=position
            dialog.dismiss()
        }
        holder.cancelBtn.setOnClickListener {
            if(MainActivity.tabsList.size==1||position==MainActivity.myPager.currentItem)
                Snackbar.make(MainActivity.myPager,"Can't remove this tab",3000).show()
            else{
                MainActivity.tabsList.removeAt(position)
                notifyDataSetChanged()
                MainActivity.myPager.adapter?.notifyItemRemoved(position)
            }
        }
    }
}