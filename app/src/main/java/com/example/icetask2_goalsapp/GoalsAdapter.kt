package com.example.icetask2_goalsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.icetask2_goalsapp.R
import com.example.icetask2_goalsapp.model.Goal

// Adapter to manage the data and bind it to the RecyclerView
class GoalsAdapter(
    private var goals: List<Goal>,
    private val onItemClick: (Goal) -> Unit
) : RecyclerView.Adapter<GoalsAdapter.GoalViewHolder>() {

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val goalTitle = itemView.findViewById<TextView>(R.id.textViewGoalTitle)
        private val goalDescription = itemView.findViewById<TextView>(R.id.textViewGoalDescription)

        fun bind(goal: Goal) {
            goalTitle.text = goal.title
            goalDescription.text = goal.description
            itemView.setOnClickListener { onItemClick(goal) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.goal_item, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        holder.bind(goals[position])
    }

    override fun getItemCount(): Int = goals.size

    fun updateGoals(newGoals: List<Goal>) {
        this.goals = newGoals
        notifyDataSetChanged()
    }
}