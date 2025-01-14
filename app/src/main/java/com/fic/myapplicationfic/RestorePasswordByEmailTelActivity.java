package com.fic.myapplicationfic;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
public class RestorePasswordByEmailTelActivity extends AppCompatActivity
{

    private Button btnRestorePassword;
    private TextInputLayout tilEmailTelRestore;
    private TextInputEditText etEmailTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restore_password_by_email_tel);

        // Inicializar los elementos de la vista
        btnRestorePassword = findViewById(R.id.btnRestorePassword);
        tilEmailTelRestore = findViewById(R.id.tilEmailTelRestore);
        etEmailTel = findViewById(R.id.etEmailTel);

        // Configurar la acción del botón
        btnRestorePassword.setOnClickListener(view -> {
            if (validateEmailOrPhone()) {
                // Si la validación es exitosa, pasa a la siguiente actividad
                Intent intent = new Intent(RestorePasswordByEmailTelActivity.this, ValidateCodRestorePassword.class);
                startActivity(intent);
             }
        });

    }
    private boolean validateEmailOrPhone() {
        String emailOrPhone = etEmailTel.getText().toString().trim();

        if (emailOrPhone.isEmpty()) {
            tilEmailTelRestore.setError("Dato necesario");
            return false;
        } else if (!isValidEmailOrPhone(emailOrPhone)) {
            tilEmailTelRestore.setError("Correo o teléfono no válido");
            return false;
        } else {
            tilEmailTelRestore.setError(null); // Limpiar errores
            return true;
        }
    }

    // Método de prueba para simular la validación de un correo o teléfono
    private boolean isValidEmailOrPhone(String emailOrPhone) {
        // Definir valores de prueba para simulación
        String testEmail = "prueba@gmail.com";
        String testPhone = "6675250066";

        return emailOrPhone.equals(testEmail) || emailOrPhone.equals(testPhone);
    }
}
