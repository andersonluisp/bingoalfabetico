package com.example.bingoalfabetico

import android.app.Activity
import android.media.Image
import android.service.voice.VoiceInteractionSession

data class HomeMenu (
        var name: String,
        var image: Int,
        var activity: Activity,
        var ativo: Boolean
)