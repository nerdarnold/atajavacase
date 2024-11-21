package com.atacase.auth.config;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseConfig {

    public static void initializeFirebase() throws IOException {
        InputStream serviceAccount = FirebaseConfig.class.getClassLoader().getResourceAsStream("atajavacase.json");

        if (serviceAccount == null) {
            throw new IOException("Service account file not found in resources.");
        }

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(FirebaseConfig.getCredentials(serviceAccount))
                .setDatabaseUrl("https://atajavacase-default-rtdb.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
    }

    private static com.google.auth.oauth2.GoogleCredentials getCredentials(InputStream serviceAccount) throws IOException {
        return com.google.auth.oauth2.GoogleCredentials.fromStream(serviceAccount);
    }
}
