package com.example.recycleviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.databinding.ListItemBinding


class StateAdapter(val context:Context, val layout:Int, val states:MutableList<State>,
                   var onClickListener:OnStateClickListener):
    RecyclerView.Adapter<StateAdapter.ViewHolder>()
{

    interface OnStateClickListener {
        fun onStateClick(state: State?, position: Int)
    }
    private var inflater: LayoutInflater? = null
    init {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener=onClickListener
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val surnameView: TextView
        val ampluaView: TextView
        val ageView: TextView
        val gamesView : TextView
        val goalsView: TextView
        init {
            val binding= view.let { ListItemBinding.bind(it) }
            surnameView = binding.surname
            ampluaView = binding.amplua
            ageView = binding.age
            gamesView = binding.games
            goalsView = binding.goals
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? = inflater?.inflate(layout, parent, false)
        return ViewHolder(view!!)
    }
    override fun getItemCount(): Int {
        return states.size;
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val state = states[position]
        holder.surnameView.text = state.surname
        holder.ampluaView.text = state.amplua
        holder.ageView.text = state.age.toString()
        holder.gamesView.text = state.games.toString()
        holder.goalsView.text = state.goals.toString()
        holder.itemView.setOnClickListener {
            onClickListener?.onStateClick(state, position);
        }
    }
}