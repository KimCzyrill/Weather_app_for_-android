package com.example.weather_app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class WeatherUpdateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            NotificationUtils.scheduleDailyWeatherUpdate(context)
            return
        }

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("weather_channel", "Weather Updates", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, "weather_channel")
            .setContentTitle("Daily Weather Forecast")
            .setContentText("Today's forecast: Sunny with a high of 28°C")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()

        notificationManager.notify(1, notification)
    }
}