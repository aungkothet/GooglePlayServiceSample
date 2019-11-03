package io.github.aungkothet.padc.googleplayservicesample.root

import android.app.Application
import io.github.aungkothet.padc.googleplayservicesample.utils.GoogleAPIClientHelper

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-06-13.
 */
class GooglePlayServiciesPADCApp: Application() {
    override fun onCreate() {
        super.onCreate()

        GoogleAPIClientHelper.initGoogleApiClientHelper(
            applicationContext
        )
    }
}