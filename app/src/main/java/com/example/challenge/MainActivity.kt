package com.example.challenge

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.challenge.databinding.ActivityMainBinding
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.presentation.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var locationManager : LocationManager

    private var lat : Double? = null
    private var long : Double? = null
    private var isPermission : Boolean = false
    private var isProviderEnable : Boolean = true
    private var viewModel = WeatherViewModel()
    private var data : WeatherModel? = null
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        getGeoLocation()
        setupObservers()

        viewModel.getWeatherDataWithACityName("Rio Branco")

    }

    private fun setupObservers() {
        viewModel.weatherData.observe(this) {
            it?.let { weather2Model ->
                binding.locationTemperature.text = weather2Model.current.temp_c.toString()
                binding.locationName.text = weather2Model.location.name
                binding.weatherCondition.text = weather2Model.current.condition.text
                binding.feelslike.text = "${weather2Model.forecast.forecastday[0].day.mintemp_c}°" +
                        "/${weather2Model.forecast.forecastday[0].day.maxtemp_c}°" +
                        " Sensação térmica de ${weather2Model.current.feelslike_c}°"
            }

        }
    }

    private fun getGeoLocation() {

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (!isPermission) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
            ) {
                isPermission = true
            }
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0f,
            object : LocationListener {
                override fun onLocationChanged(p0: Location) {
                    p0.let {

                        if (lat != it.latitude && long != it.longitude && lat != null && long != null) {
                            viewModel.getWeatherDataWithACityName(q = "${it.latitude},${it.longitude}")
                        }

                        lat = it.latitude
                        long = it.longitude
                    }
                }

                override fun onProviderDisabled(provider: String) {
                    isProviderEnable = false
                }

                override fun onProviderEnabled(provider: String) {
                    isProviderEnable = true
                }

            })
    }
}