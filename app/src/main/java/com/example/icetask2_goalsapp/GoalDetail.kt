package com.example.icetask2_goalsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.icetask2_goalsapp.R
import com.example.icetask2_goalsapp.DBHelper

class GoalDetail : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper // DBHelper to interact with the database
    private var goalId: Int = 0 // ID of the goal being displayed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.goal_detail)

        // Retrieve UI elements
        val textViewGoalTitle = findViewById<TextView>(R.id.textViewGoalTitle)
        val textViewGoalDescription = findViewById<TextView>(R.id.textViewGoalDescription)
        val checkBoxCompleted = findViewById<CheckBox>(R.id.checkBoxCompleted)
        val btnDeleteGoal = findViewById<Button>(R.id.btnDeleteGoal)

        dbHelper = DBHelper(this)
        goalId = intent.getIntExtra("goal_id", 0)

        // Fetch the goal from the database and display its details
        val goal = dbHelper.getAllGoals().first { it.id == goalId }
        textViewGoalTitle.text = goal.title
        textViewGoalDescription.text = goal.description
        checkBoxCompleted.isChecked = goal.isCompleted

        // Update the goal's completed status when checkbox is clicked
        checkBoxCompleted.setOnCheckedChangeListener { _, isChecked ->
            dbHelper.updateGoal(goal.copy(isCompleted = isChecked))
        }

        btnDeleteGoal.setOnClickListener {
            dbHelper.deleteGoal(goalId)
            finish()
        }
    }
}