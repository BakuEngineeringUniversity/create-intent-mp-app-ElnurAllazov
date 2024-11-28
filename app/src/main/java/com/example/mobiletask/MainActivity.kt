package com.example.mobiletask

import android.os.Bundle
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mediaPlayer = MediaPlayer.create(this, R.raw.vortexphonk2024_mix_239249)


        val emailText = findViewById<TextView>(R.id.emailText)
        emailText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:eellezov@std.beu.edu.az")
            }
            startActivity(intent)
        }


        val phoneText1 = findViewById<TextView>(R.id.phoneText1)
        phoneText1.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:0552478512")
            }
            startActivity(intent)
        }

        val phoneText2 = findViewById<TextView>(R.id.phoneText2)
        phoneText2.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:0505112611")
            }
            startActivity(intent)
        }


        val locationText = findViewById<TextView>(R.id.locationText)
        locationText.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=Azerbaijan Masazir")
            }
            startActivity(intent)
        }





        val playMusicButton = findViewById<Button>(R.id.playMusicButton)
        playMusicButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}