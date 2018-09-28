package br.com.ufrpe.foodguru;
import com.google.firebase.auth.FirebaseAuth;


public class UsuarioDAO {
    private FirebaseAuth mAuth;
    public UsuarioDAO(){
        mAuth = FirebaseAuth.getInstance();
    }


}
