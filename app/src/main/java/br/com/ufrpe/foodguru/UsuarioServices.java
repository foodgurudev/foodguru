package br.com.ufrpe.foodguru;
import com.google.firebase.auth.FirebaseAuth;


public class UsuarioServices {
    private FirebaseAuth mAuth;
    public UsuarioServices(){
        mAuth = FirebaseAuth.getInstance();
    }


}
