package com.example.icetask2_goalsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper // DBHelper to interact with the database
    private lateinit var goalsAdapter: GoalsAdapter // Adapter for RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)
        goalsAdapter = GoalsAdapter(dbHelper.getAllGoals()) { goal ->       // Handle item click, start GoalDetail activity with the selected goal's ID
            val intent = Intent(this, GoalDetail::class.java)
            intent.putExtra("goal_id", goal.id)
            startActivity(intent)
        }

        val recyclerViewGoals = findViewById<RecyclerView>(R.id.recyclerViewGoals)
        recyclerViewGoals.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = goalsAdapter
        }

        // Set up Add Goal button to start AddGoalActivity
        val btnAddGoal = findViewById<Button>(R.id.btnAddGoal)
        btnAddGoal.setOnClickListener {
            startActivity(Intent(this, AddGoalActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        goalsAdapter.updateGoals(dbHelper.getAllGoals())
    }

}

