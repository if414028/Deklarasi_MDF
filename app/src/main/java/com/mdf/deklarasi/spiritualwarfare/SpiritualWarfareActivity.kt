package com.mdf.deklarasi.spiritualwarfare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivitySpiritualWarfareBinding

class SpiritualWarfareActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpiritualWarfareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spiritual_warfare)
        supportActionBar?.hide()

        setupLayout()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        binding.cardShofarSound.setOnClickListener {
            val intent = Intent(applicationContext, ShofarShoundActivity::class.java)
            startActivity(intent)
        }
    }
}