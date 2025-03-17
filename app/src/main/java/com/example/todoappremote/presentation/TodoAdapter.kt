package com.example.todoappremote.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoappremote.databinding.ItemTodoBinding
import com.example.todoappremote.domain.models.ToDoItem

class TodoAdapter: Adapter<TodoAdapter.MyViewHolder>() {
    private var list : List<ToDoItem> = emptyList()

    class MyViewHolder(val binding : ItemTodoBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        holder.binding.textContent.text = item.title
        holder.binding.textWeekday.text = item.weekday
    }

    fun updateList(newData : List<ToDoItem>){
        list = newData
        notifyDataSetChanged()
    }
}