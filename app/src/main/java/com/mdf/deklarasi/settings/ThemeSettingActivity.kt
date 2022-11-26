package com.mdf.deklarasi.settings

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivityThemeSettingBinding

class ThemeSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemeSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_theme_setting)
        supportActionBar?.hide()
        setupLayout()
    }

    private fun checkAppliedTheme() {
        when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> {
                binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_checked))
                binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_unchecked))
                binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_unchecked))
            }
            AppCompatDelegate.MODE_NIGHT_YES -> {
                binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_unchecked))
                binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_checked))
                binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_unchecked))
            }
            else -> {
                binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_unchecked))
                binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_unchecked))
                binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_checked))
            }
        }
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
        checkAppliedTheme()
        binding.lightMode.setOnClickListener {
            binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_checked))
            binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_unchecked))
            binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_unchecked))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        binding.darkMode.setOnClickListener {
            binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_unchecked))
            binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_checked))
            binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_unchecked))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        binding.systemDefault.setOnClickListener {
            binding.lightMode.setImageDrawable(resources.getDrawable(R.drawable.light_mode_unchecked))
            binding.darkMode.setImageDrawable(resources.getDrawable(R.drawable.dark_mode_unchecked))
            binding.systemDefault.setImageDrawable(resources.getDrawable(R.drawable.system_mode_checked))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}