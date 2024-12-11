package com.fic.myapplicationfic.utils

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment

inline fun <reified T : Activity> Activity.goToActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    val x = 2;
    Log.i("PRUEBA", "equisde: ${x}")
    startActivity(intent)
}

inline fun <reified T : Activity> Fragment.goToActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(requireContext(), T::class.java)
    intent.init()
    startActivity(intent)
}