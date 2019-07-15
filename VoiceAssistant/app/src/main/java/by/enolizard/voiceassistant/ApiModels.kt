package by.enolizard.voiceassistant

class ApixuResponse(val location: LocationResponse, val current: WeatherResponse)

class LocationResponse(val name: String, val country: String)

class WeatherResponse(val temp_c: Double, val condition: ConditionReponse)

class ConditionReponse(val text: String)
