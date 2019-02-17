package br.com.movilenext.pushnotification.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        const val TAG = "FMService"
    }

    override fun onNewToken(token: String?) {
        Log.e(TAG, token)

        FirebaseMessaging.getInstance().subscribeToTopic("MAIN")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val notification = remoteMessage.notification
        Log.e(TAG, "FCM Message ID: ${remoteMessage.messageId}")
        Log.e(TAG, "FCM Data Message: ${remoteMessage.data}")
        Log.e(TAG, "FCM Notification Message: $notification")

        notification?.let {
            val title = it.title ?: ""
            val body = it.body ?: ""

            Log.e(TAG, "FCM Notification Title: $title")
            Log.e(TAG, "FCM Notification Body: $body")

            NotificationCreation.create(this, title, body)
        }
    }

}
