package by.enolizard.voiceassistant

import android.os.Build
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.function.Consumer

class Weather(apixu: ApixuResponse) {
    private var condition: String
    private var temperature: Double
    private val country: String
    private val city: String

    init {
        country = apixu.location.country
        city = apixu.location.name
        temperature = apixu.current.temp_c
        condition = apixu.current.condition.text
    }

    fun getTextInfo(): String {
        return "In $country, $city about $temperature C and $condition there"
    }

    interface WeatherService {
        @GET("/v1/current.json?key=02c35a83d17546cdb41112529192507")
        fun getCurrentWeather(@Query("q") city: String): Call<ApixuResponse>
    }

    companion object {
        fun get(city: String) {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.apixu.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val call = retrofit.create(WeatherService::class.java).getCurrentWeather(city)

            call.enqueue(object : Callback<ApixuResponse> {
                override fun onFailure(call: Call<ApixuResponse>, t: Throwable) {
                    Log.e("TEST Weather", t.message)

                }

                override fun onResponse(call: Call<ApixuResponse>, response: Response<ApixuResponse>) {
                    val result = Weather(response.body()!!).getTextInfo()
                    Log.e("TEST Weather", result)
                }
            })

        }
    }
}
