package com.example.mymusicproject

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.TreeMap

class LoginActivity : AppCompatActivity() {
    lateinit var edtmail: EditText
    lateinit var edtPassw: EditText
    lateinit var btnLogin: Button
    lateinit var btnSignUp: Button
    lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtmail = findViewById(R.id.mEdtEmail)
        edtPassw = findViewById(R.id.mEdtPass)
        btnLogin = findViewById(R.id.mBtnLogin)
        btnSignUp = findViewById(R.id.mBtnsignUp)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing Up")
        progressDialog.setMessage("Loading...")

        btnLogin.setOnClickListener {
            val mail = edtmail.text.toString().trim()
            val password = edtPassw.text.toString().trim()

            if (mail.isEmpty()) {
                edtmail.setError("Please fill this input")
                edtmail.requestFocus()
            } else if (password.isEmpty()) {
                edtPassw.setError("Please fill this input")
                edtPassw.requestFocus()
            } else {
                progressDialog.show()

                FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, password)
                    .addOnCompleteListener { task ->
                        progressDialog.dismiss()
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!

                            Toast.makeText(
                                this@LoginActivity, "You are logged in successfully",
                                Toast.LENGTH_LONG
                            ).show()

                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        //FirebaseDatabase
        fun checkUser() {
            progressDialog.setMessage("Check User...")


            val firebaseUser = firebaseAuth.currentUser!!

            val ref = FirebaseDatabase.getInstance().getReference("Users")
            ref.child(firebaseUser.uid)
            progressDialog.dismiss()


            }
        btnLogin.setOnClickListener {
            val intent = Intent(this, DashboardUserActivity::class.java)
            startActivity(intent)

        }
    }
}




















