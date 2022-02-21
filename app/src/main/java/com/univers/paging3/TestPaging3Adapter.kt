package com.univers.paging3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.univers.leetcodenote.R
import com.univers.paging3.model.Repo

class TestPaging3Adapter : PagingDataAdapter<Repo,TestPaging3Adapter.ViewHolder>(COMPARATOR){
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Repo>(){
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_text)
        val description: TextView = itemView.findViewById(R.id.description_text)
        val starCount: TextView = itemView.findViewById(R.id.star_count_text)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = getItem(position)
        if (repo!=null){
            holder.name.text = repo.name
            holder.description.text = repo.description
            holder.starCount.text = repo.starCount.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
        return ViewHolder(view)
    }
}