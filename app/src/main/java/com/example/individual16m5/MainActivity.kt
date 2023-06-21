package com.example.individual16m5

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.individual16m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countriesListView: ListView
    private lateinit var populationTextView: TextView

    private val countries = arrayOf(
        "Argentina", "Bolivia", "Brasil", "Chile", "Colombia",
        "Ecuador", "Paraguay", "Perú", "Uruguay", "Venezuela"
    )

    private val populations = mapOf(
        "Argentina" to 45000001,
        "Bolivia" to 11000002,
        "Brasil" to 211000003,
        "Chile" to 18000004,
        "Colombia" to 50340005,
        "Ecuador" to 17080006,
        "Paraguay" to 6900007,
        "Perú" to 32510008,
        "Uruguay" to 3500009,
        "Venezuela" to 28435949
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countriesListView = binding.list1
        populationTextView = binding.tv1

        countriesListView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        countriesListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedCountry = countries[position]
                val population = populations[selectedCountry]
                populationTextView.text =
                    "Población de $selectedCountry: $population habitantes"
            }
    }
}