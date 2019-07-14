package by.yakivan.vkfriends

import android.app.Application
import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.utils.VKUtils
import org.jetbrains.annotations.TestOnly

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
//        getVKfingeprint()
    }

    fun getVKFingerprint() {
        var fingerprint = VKUtils.getCertificateFingerprint(this, packageName)
        ;
    }
}