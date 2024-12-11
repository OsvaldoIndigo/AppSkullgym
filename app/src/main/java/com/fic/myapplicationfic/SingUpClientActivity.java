package com.fic.myapplicationfic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class SingUpClientActivity extends AppCompatActivity {
    //declaracion d var
    private TextInputEditText etNameUser, etApellidoClient, etEditTextPhone, etEditTextEmailAddress, etEditTextDate, etDirectionClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);

        //Vincular variables con los elementos del  XML usando findViewById en el método onCreate

        etNameUser = findViewById(R.id.etNameUser);
        etApellidoClient = findViewById(R.id.etApellidoClient);
        etEditTextPhone = findViewById(R.id.etEditTextPhone);
        etEditTextEmailAddress = findViewById(R.id.etEditTextEmailAddress);
        etEditTextDate = findViewById(R.id.etEditTextDate);
        etDirectionClient = findViewById(R.id.etDirectionClient);

        //Configurar del botón para que capture los datos
        Button buttonSingUp = findViewById(R.id.buttonSingUp);
        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Almacenar los datos ingresados en variables
                String nameUser = etNameUser.getText().toString();
                String apellidoClient = etApellidoClient.getText().toString();
                String phone = etEditTextPhone.getText().toString();
                String emailAddress = etEditTextEmailAddress.getText().toString();
                String birthDate = etEditTextDate.getText().toString();
                String directionClient = etDirectionClient.getText().toString();

                // Validar que todos los campos estén completos
                if (TextUtils.isEmpty(nameUser) || TextUtils.isEmpty(apellidoClient) ||
                        TextUtils.isEmpty(phone) || TextUtils.isEmpty(emailAddress) ||
                        TextUtils.isEmpty(birthDate) || TextUtils.isEmpty(directionClient)) {
                    Toast.makeText(SingUpClientActivity.this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar mensaje de éxito
                    Toast.makeText(SingUpClientActivity.this, "Registro exitoso:\n" +
                            "Nombre: " + nameUser + "\n" +
                            "Apellido: " + apellidoClient + "\n" +
                            "Teléfono: " + phone + "\n" +
                            "Correo: " + emailAddress + "\n" +
                            "Fecha de Nacimiento: " + birthDate + "\n" +
                            "Dirección: " + directionClient, Toast.LENGTH_LONG).show();

                    // Redirigir al LoginActivity
                    Intent intent = new Intent(SingUpClientActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish(); // Finalizar la actividad actual para que no pueda volver con el botón de atrás
                }
            }
        });
    }

}