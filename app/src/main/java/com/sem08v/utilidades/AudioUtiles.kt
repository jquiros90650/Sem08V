package com.sem08v.utilidades

import android.app.Activity
import android.content.Context
import android.media.MediaRecorder
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import java.io.File

class AudioUtiles(
    private val actividad: Activity,
    private val contexto: Context,
    private val btAccion: ImageButton,
    private val btPlay: ImageButton,
    private val btDelete: ImageButton,
    private val msgInicioNotaAudio: String,
    private val msgDetieneNotaAudio: String
){
    init {
        btAccion.setOnClickListener{ grabaDetiene()}
        btPlay.setOnClickListener{reproducirAudio()}
        btDelete.setOnClickListener{eliminarAudio()}

        btDelete.isEnabled = false
        btPlay.isEnabled = false

    }



    private var mediaRecorder: MediaRecorder? = null
    private var grabando= false
    var audioFile: File = File.createTempFile("audio",".mp3")


    private fun grabaDetiene() {
        if(contextCompat.checkSelfPermission(contexto, manifest.permission.RECORD_AUDIO) !=packageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(actividad, permission, 0)
        }
        else {
            grabando = if(!grabando){

        }
        }
    }

    private fun reproducirAudio() {

    }

    private fun eliminarAudio() {

    }


}