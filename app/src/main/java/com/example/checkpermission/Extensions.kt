package com.example.checkpermission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


// показывает было ли получено разрешение от  пользователя (true or false)
fun Fragment.isPermissionGranted(p : String) : Boolean {

    return ContextCompat.checkSelfPermission(activity as AppCompatActivity, p) == PackageManager.PERMISSION_GRANTED

}