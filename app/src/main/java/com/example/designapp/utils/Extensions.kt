package com.example.designapp.utils

import android.content.res.Resources

fun Int.dp() = this * Resources.getSystem().displayMetrics.density