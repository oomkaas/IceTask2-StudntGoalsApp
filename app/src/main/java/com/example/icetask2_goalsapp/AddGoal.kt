package com.example.icetask2_goalsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.icetask2_goalsapp.R
import com.example.icetask2_goalsapp.DBHelper
import com.example.icetask2_goalsapp.model.Goal


class AddGoalActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper // DBHelper to interact with the database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_goal)

        // Retrieve UI elements
        val txtGoalTitle = findViewById<EditText>(R.id.txtGoalTitle)
        val txtGoalDescription = findViewById<EditText>(R.id.txtGoalDescription)
        val btnSaveGoal = findViewById<Button>(R.id.btnSaveGoal)

        dbHelper = DBHelper(this)

        btnSaveGoal.setOnClickListener {
            val title = txtGoalTitle.text.toString()
            val description = txtGoalDescription.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                val goal = Goal(0, title, description, false)
                dbHelper.addGoal(goal)
                finish()  // Close the activity and return to the main screen
            } else {
                //show an error message
            }
        }
    }
}