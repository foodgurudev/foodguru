package br.com.ufrpe.foodguru;

import com.google.firebase.auth.FirebaseAuth;

public final class FirebaseHelper {
    public static final String REFERENCIA_USUARIOS = "Usuarios";

    public FirebaseHelper(){
    }
    public static FirebaseAuth getFirebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    public static String getUidUsuario(){
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
