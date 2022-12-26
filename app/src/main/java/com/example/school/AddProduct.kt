package com.example.school

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.school.databinding.ActivityAddProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddProduct : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product)

        with(binding){
            send.setOnClickListener {
                addProduct()
            }



        }


    }

    private fun addProduct(){
        with(binding){
            db= FirebaseFirestore.getInstance()
           // val name=binding.name.text
            val name=name.text
            val phone=phone.text
            val classe=classe.text
            val status=status.text

            val model=Detail()
            model.Image=R.drawable.student
            model.name=name.toString()
            model.classname=classe.toString()
            model.status=status.toString()
            model.phone=phone.toString()

            val fStore=db.collection("student")

            fStore.document().set(model).addOnSuccessListener {
                Toast.makeText(this@AddProduct, "data add successfuly", Toast.LENGTH_SHORT).show()
                val intent= Intent(this@AddProduct,MainActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this@AddProduct, "somethin went wrong", Toast.LENGTH_SHORT).show()
            }


        }


    }
}