package com.example.mymusicproject

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
class SignupActivity : AppCompatActivity() {
    lateinit var edtName: EditText
    lateinit var edtLast: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPass: EditText
    lateinit var edtRepass: EditText
    lateinit var edtPhone:  EditText
    lateinit var progressDialog: ProgressDialog
    lateinit var SignUpBtn: Button
    lateinit var LogBtn: Button
    lateinit var CheckAdim: CheckBox
    lateinit var CheckUser: CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        edtName = findViewById(R.id.mEdtName)
        edtLast = findViewById(R.id.mEdtLastName)
        edtEmail = findViewById(R.id.mEdtMail)
        edtPhone = findViewById(R.id.mEdtPhone)
        edtPass = findViewById(R.id.mEdtPassword)
        edtRepass = findViewById(R.id.mEdtRePass)
        SignUpBtn = findViewById(R.id.mBtnSignUp)
        LogBtn = findViewById(R.id.mBtnLog)

        progressDialog = ProgressDialog (this)
        progressDialog.setTitle("Signing Up")
        progressDialog.setMessage("Loading...")
        LogBtn.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        SignUpBtn.setOnClickListener {
            var name = edtName.text.toString().trim()
            var email = edtEmail.text.toString().trim()
            var phone = edtPhone.text.toString().trim()
            var repass = edtRepass.text.toString().trim()
            var password = edtPass.text.toString().trim()



            if (name.isEmpty()){
                edtName.error = "Please fill this input."
                edtName.requestFocus()
            }else if (email.isEmpty()){
                edtEmail.error = "Please fill this input"
                edtEmail.requestFocus()
            } else if (password.isEmpty()){
                edtPass.error = "Please fill this input"
                edtPass.requestFocus()
            } else if (repass.isEmpty()) {
                edtRepass.error = "Please fill this input"
                edtRepass.requestFocus()
            }else if( password != repass){
                Toast.makeText(this,"Password doesn't match...", Toast.LENGTH_SHORT).show()
            } else if (phone.isEmpty()) {
                edtPhone.error = "Please fill in this input"
                edtPhone.requestFocus()
            }
            else{
                //Firebase Auth
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(
                        { task ->
                            // if the registration is successfully done
                            if (task.isSuccessful) {
                                // Firebase registered user
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this@SignupActivity,"You are registered successfully",
                                    Toast.LENGTH_LONG).show()

                            }else
                              // if the signing up is not successfull
                                Toast.makeText(
                                    this@SignupActivity,
                                task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT).show()
                        }
                    )
                //FirebaseDatabase
                 fun updateUserInfo(){
                    progressDialog.setMessage("Saving user info...")
                }
                val timestamp = System.currentTimeMillis()

                val firebaseAuth = FirebaseAuth.getInstance()


                val uid = firebaseAuth.uid


                val hashMap : HashMap<String, Any?> = HashMap()
                hashMap["uid"] = uid
                hashMap["email"] = email
                hashMap["name"] = name
                hashMap["profileImage"] = ""
                hashMap["userTYpe"] = "user"
                hashMap["timestamp"] = timestamp

                val ref = FirebaseDatabase.getInstance().getReference("Users")
                ref.child(uid!!)
                    .setValue(hashMap)
                    .addOnSuccessListener {
                        progressDialog.dismiss()
                        Toast.makeText(this, "Account created...", Toast.LENGTH_LONG).show()
                        SignUpBtn.setOnClickListener {
                        startActivity(Intent(this@SignupActivity, DashboardUserActivity::class.java))
                        finish()}
                    }
                    .addOnFailureListener{
                       progressDialog.dismiss()
                        val e: Exception = Exception("Your error message")
                        Toast.makeText(this, "Failed saving user info due to ${e.message}", Toast.LENGTH_LONG).show()


                    }
            }
        }
    }
}