package com.mutualmobile.praxis.manager

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.mutualmobile.praxis.BaseApplication

class PushNotificationService : FirebaseMessagingService() {
  override fun onNewToken(p0: String) {
    super.onNewToken(p0)
  }

  override fun onMessageReceived(p0: RemoteMessage) {
    super.onMessageReceived(p0)
  }

}