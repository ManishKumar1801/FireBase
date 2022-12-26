package com.example.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.school.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var arrayList: ArrayList<Detail>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        arrayList= ArrayList()
        arrayList.add(Detail(
           R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Vipin","inactive"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Manish","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Rahul","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        arrayList.add(Detail(
            R.drawable.student,"10th","9123471296","Nitesh","active"
        ))
        with(binding){
            adapter= MyAdapter(arrayList)
            recyclerview.adapter=adapter
            recyclerview.layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }
}