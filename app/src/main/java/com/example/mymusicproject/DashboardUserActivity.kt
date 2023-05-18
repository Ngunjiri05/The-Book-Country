package com.example.mymusicproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.mymusicproject.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardUserBinding

    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var BtnAdmin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dashboard_user)
        BtnAdmin = findViewById(R.id.mBtnAdmin)

        BtnAdmin.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)}

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        startActivity(Intent(this, MainActivity::class.java))




    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            binding.mEdtEm.text = "Not logged in"

        }else{
            val email = firebaseUser.email

            binding.mEdtEm.text = email
    }
} }