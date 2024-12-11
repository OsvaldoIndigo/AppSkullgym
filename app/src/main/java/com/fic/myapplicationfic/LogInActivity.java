package com.fic.myapplicationfic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogInActivity extends AppCompatActivity {

    TextInputLayout tilEmail = null;
    TextInputEditText emailEditText = null;
    TextView singup = null;
    EditText passwordEditText = null;
    Button btnLogin = null;
    Button btnSignUp = null;
    TextView recoveryPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        btnSignUp = findViewById(R.id.singUp);
        btnSignUp.setOnClickListener(view -> {
            // Crear el Intent para abrir la nueva actividad
            Intent intent = new Intent(LogInActivity.this, SingUpClientActivity.class);
            startActivity(intent);  // Iniciar la nueva actividad
        });


        Log.i("prueba", "onCreate");
        //Toast.makeText(LogInActivity.this, "Se ha ejecutado: onCreate ", Toast.LENGTH_SHORT).show();

        setUI();
        actions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("prueba", "onResume");
        // Toast.makeText(LogInActivity.this, "Se ha ejecutado: onResume ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("prueba", "onStart");
        // Toast.makeText(LogInActivity.this, "Se ha ejecutado: onStart ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("prueba", "onRestart");
        //  Toast.makeText(LogInActivity.this, "Se ha ejecutado: onRestart ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("prueba", "onPause");
        // Toast.makeText(LogInActivity.this, "Se ha ejecutado: onPause ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("prueba", "onStop");
        //Toast.makeText(LogInActivity.this, "Se ha ejecutado: onStop ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("prueba", "onDestroy");
        // Toast.makeText(LogInActivity.this, "Se ha ejecutado: onDestroy ", Toast.LENGTH_SHORT).show();
    }

    private void setUI() {
        //declarar variable boton para interacion
        btnLogin = findViewById(R.id.btnLogin);

        tilEmail = findViewById(R.id.tilEmail);
        emailEditText = findViewById(R.id.etEmail);
        passwordEditText = findViewById(R.id.etPassword);
        singup = findViewById(R.id.singUp);
        recoveryPass = findViewById(R.id.recoveryPass);
    }

    private void actions() {
        btnLogin.setOnClickListener(view -> userSearch());
        recoveryPass.setOnClickListener(view -> {
            Intent intent = new Intent(LogInActivity.this, RestorePasswordByEmailTelActivity.class);
            startActivity(intent);  // Iniciar la nueva actividad
        });
    }

    private void userSearch() {
        //captura de textos en campos
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        //validar que campos no esten vacios
        if (email.isEmpty() || password.isEmpty()) {

            if (email.isEmpty())
                tilEmail.setError("Dato necesario");
            Toast.makeText(LogInActivity.this, "Por favor, complete ambos campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LogInActivity.this, UserDetailActivity.class);
            startActivity(intent);
        }

        Log.i("chi", "email: " + emailEditText.getText());
    }
}