package com.fic.myapplicationfic;
import com.google.android.material.textfield.TextInputEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RestorePasswordActivity extends AppCompatActivity {
    private TextInputLayout tilNewPassword, tilConfirmNewPassword;
    private TextInputEditText etNewPassword, etConfirmNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restore_password);

        // Vincula los campos
        tilNewPassword = findViewById(R.id.tilnewPassword);
        tilConfirmNewPassword = findViewById(R.id.tilconfirmNewPassword);
        etNewPassword = findViewById(R.id.etnewPassword);
        etConfirmNewPassword = findViewById(R.id.etconfirmNewPassword);

        // Configura botón de restauración
        findViewById(R.id.btnRestorePassword).setOnClickListener(v -> {
            if (validatePasswordFields()) {
                // Muestra el mensaje de éxito
                Toast.makeText(RestorePasswordActivity.this, "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RestorePasswordActivity.this, LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                // Lógica de restauración (API o lógica local)

                finish();
            }
        });
    }

    private boolean validatePasswordFields() {
       
        String  newPassword = etNewPassword.getText().toString();

        String confirmPassword = etConfirmNewPassword.getText().toString();

        if (TextUtils.isEmpty(newPassword)) {
            tilNewPassword.setError("La contraseña no puede estar vacía");
            return false;
        }
        if (newPassword.length() < 8) {
            tilNewPassword.setError("La contraseña debe tener al menos 8 caracteres");
            return false;
        }
        if (!newPassword.equals(confirmPassword)) {
            tilConfirmNewPassword.setError("Las contraseñas no coinciden");
            return false;
        }
        tilNewPassword.setError(null);
        tilConfirmNewPassword.setError(null);
        return true;
    }

}