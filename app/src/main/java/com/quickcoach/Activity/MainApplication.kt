package com.quickcoach.Activity

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MainApplication : Application() {
    companion object {
        lateinit var instance: MainApplication
//        lateinit var dataBaseRoot: DatabaseReference

    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        instance = this

//        dataBaseRoot = FirebaseDatabase.getInstance().reference
//        FirebaseApp.initializeApp(instance)
       // Util.setToken()

//        BaseActivity.dLocale = Locale(Pref.getStringValue(Pref.PREF_LANGUAGE, DEFAULT_LANGUAGE).toString())

    }
}