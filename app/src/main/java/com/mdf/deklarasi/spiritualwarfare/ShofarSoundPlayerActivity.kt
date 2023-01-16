package com.mdf.deklarasi.spiritualwarfare

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mdf.deklarasi.R
import com.mdf.deklarasi.databinding.ActivityShofarSoundPlayerBinding

class ShofarSoundPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShofarSoundPlayerBinding

    private lateinit var title: String
    private lateinit var filename: String
    private lateinit var image: String

    private lateinit var mediaPlayer: MediaPlayer

    private var isPlay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shofar_sound_player)
        supportActionBar?.hide()

        getArguments()
        setupLayout()
    }

    private fun setupLayout() {
        binding.btnBack.setOnClickListener { onBackPressed() }
        binding.tvTitle.text = title
        setupImage()
        setupMediaPlayer()
    }

    private fun getArguments() {
        title = intent.getStringExtra("title").toString()
        filename = intent.getStringExtra("filename").toString()
        image = intent.getStringExtra("image").toString()
    }

    private fun setupMediaPlayer() {
        binding.btnPlay.setOnClickListener {
            if (isPlay) {
                isPlay = false
                stopMedia()
                binding.btnPlay.setImageResource(R.drawable.play_button)
            } else {
                isPlay = true
                playMedia()
                binding.btnPlay.setImageResource(R.drawable.stop_button)
            }
        }
    }

    private fun setupImage() {
        val imageFile = resources.getIdentifier(image, "drawable", packageName)
        binding.ivShofar.setImageResource(imageFile)
    }


    private fun playMedia() {
        val rawFileName = resources.getIdentifier(filename, "raw", packageName)
        mediaPlayer = MediaPlayer.create(applicationContext, rawFileName)
        mediaPlayer.setOnCompletionListener { mediaPlayer.stop() }
        mediaPlayer.setScreenOnWhilePlaying(true)
        mediaPlayer.start()
    }

    private fun stopMedia() {
        mediaPlayer.release()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
