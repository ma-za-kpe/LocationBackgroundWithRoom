package com.maku.testapp.ui.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maku.testapp.R
import com.maku.testapp.db.Locationstuff

class WordListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Locationstuff>() // Cached copy of words


    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.latitude)
        val long: TextView = itemView.findViewById(R.id.longitude)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        Log.d("TAG", "location ..." + current.latitude.toString())
        holder.wordItemView.text = current.latitude.toString()
        holder.long.text = current.longitude.toString()

    }

    internal fun setWords(words: List<Locationstuff>) {
        this.words = words as ArrayList<Locationstuff>
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size
}