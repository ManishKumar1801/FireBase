package com.example.school

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var model:Detail
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private lateinit var arrayList: ArrayList<Detail>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        buildRecycler()

        with(binding) {
            fab.setOnClickListener {
                val intent = Intent(this@MainActivity, AddProduct::class.java)
                startActivity(intent)
            }

        }
    }

    private fun buildRecycler() {
        arrayList = ArrayList()
         model = Detail()

        db = FirebaseFirestore.getInstance()
        val fStore = db.collection("student")

        fStore.get().addOnSuccessListener {


            if (!it.isEmpty) {

                val list = it.documents

                for (d in list) {
                    model = d.toObject(Detail::class.java)!!
                   arrayList.add(model)
                    Log.d("dataaa",arrayList.toString())

                    adapter = MyAdapter(arrayList)
                    binding.recyclerview.adapter = adapter
                    binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }
        }.addOnFailureListener {
            Toast.makeText(this, "data not found", Toast.LENGTH_SHORT).show()
        }


//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Vipin","inactive"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Manish","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Rahul","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))
//        arrayList.add(Detail(
//            R.drawable.student,"10th","9123471296","Nitesh","active"
//        ))

    }
}