package com.mdf.deklarasi.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        supportActionBar?.hide()
        setupLayout()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        binding.lyTheme.setOnClickListener {
            val intent = Intent(applicationContext, ThemeSettingActivity::class.java)
            startActivity(intent)
        }
        binding.lyAbout.setOnClickListener {

        }
    }
}