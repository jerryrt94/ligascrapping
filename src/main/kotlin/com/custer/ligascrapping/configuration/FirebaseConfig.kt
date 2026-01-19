package com.custer.ligascrapping.configuration

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.*

@Configuration
class FirebaseConfig {

    @Value($$"${firebaseFile}")
    private val firebaseFile: String = ""

    @Bean
    @Throws(IOException::class)
    fun firestore(): Firestore {

        val decodedBytes = Base64.getDecoder().decode(firebaseFile)

        val serviceAccount = ByteArrayInputStream(decodedBytes)

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options)
        }

        return FirestoreClient.getFirestore()
    }
}