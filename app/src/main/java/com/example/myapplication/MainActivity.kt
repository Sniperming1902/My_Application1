package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reset()
        binding.btnReset.setOnClickListener { reset() }
        binding.btnSubmit.setOnClickListener { submit() }
    }

    private fun reset() {
        binding.edtName.text.clear()
        binding.edtAge.text.clear()

        binding.edtName.requestFocus()
    }

    private fun submit() {
        val name = binding.edtName.text.toString().trim()
        val age = binding.edtAge.text.toString().toIntOrNull() ?: 0

        if (name == "") {
            toast("Invalid name")
            return
        }

        if (age <= 1) {
            toast("Invalid age")
            return
        }

        val intent = Intent(this, SubActivity::class.java)
            .putExtra("name", name)
            .putExtra("age", age)
        startActivity(intent)
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}