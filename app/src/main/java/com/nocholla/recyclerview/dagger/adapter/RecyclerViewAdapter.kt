package com.nocholla.recyclerview.dagger.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nocholla.recyclerview.dagger.R
import com.nocholla.recyclerview.dagger.model.StarWars
import java.util.ArrayList
import javax.inject.Inject

class RecyclerViewAdapter @Inject
constructor(clickListener: ClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val data: MutableList<StarWars.People>
    private val clickListener: ClickListener = clickListener

    init {
        data = ArrayList<StarWars.People>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = data[position].name
        holder.txtBirthYear.text = "Birth Year : " + data[position].birthYear
        holder.txtGender.text = "Gender : " + data[position].gender
        holder.txtHeight.text = "Height : " + data[position].height
        holder.txtMass.text = "Mass : " + data[position].mass
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtBirthYear: TextView = itemView.findViewById(R.id.txtBirthYear)
        val txtGender: TextView = itemView.findViewById(R.id.txtGender)
        val txtHeight: TextView = itemView.findViewById(R.id.txtHeight)
        val txtMass: TextView = itemView.findViewById(R.id.txtMass)
        private val constraintLayoutContainer: ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

        init {

            constraintLayoutContainer.setOnClickListener {
                clickListener.launchIntent(
                    data[adapterPosition].films!![0]
                )
            }
        }
    }

    interface ClickListener {
        fun launchIntent(filmName: String)
    }

    fun setData(data: List<StarWars.People>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}

