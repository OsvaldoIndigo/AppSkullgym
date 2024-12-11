package com.fic.myapplicationfic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ValidateCodRestorePassword extends AppCompatActivity {
    // Inicializar los elementos de la vista
    private Button restorePass;
    private TextInputLayout clValidatorCode;
    private TextInputEditText etValidatorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validate_cod_restore_password);
        // Inicializar los elementos de la vista
        restorePass = findViewById(R.id.btnRestorePassword);
        clValidatorCode = findViewById(R.id.clValidatorCode);
        etValidatorCode = findViewById(R.id.etValidatorCode);

        // Configurar la acción del botón
        restorePass.setOnClickListener(view -> {
            if (validateCode()) {
                // Si la validación es exitosa, pasa a la siguiente actividad
                Intent intent = new Intent(ValidateCodRestorePassword.this, RestorePasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para validar el código de restauración
    private boolean validateCode() {
        String enteredCode = etValidatorCode.getText().toString().trim();

        // Verifica si el campo está vacío o si el código no es correcto
        if (enteredCode.isEmpty()) {
            clValidatorCode.setError("Dato necesario");
            return false;
        } else if (!enteredCode.equals("1234")) { // Código de prueba
            clValidatorCode.setError("Código incorrecto");
            return false;
        } else {
            clValidatorCode.setError(null); // Limpiar errores
            return true;
        }
    }

}