package by.yakivan.vkfriends

import android.app.Application
import com.vk.api.sdk.VK

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
    }
}