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
import android.widget.Spinner;

public class SingUpClientActivity extends AppCompatActivity {
    //declaracion d var
    private TextInputEditText etNameUser, etApellidoClient, etEditTextPhone, etEditTextEmailAddress, etEditTextDate, etDirectionClient;
    private Spinner spMembershipType, spExercisePlan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);

        // Vincular los elementos del XML con las variables
        etNameUser = findViewById(R.id.etNameUser);
        etApellidoClient = findViewById(R.id.etApellidoClient);
        etEditTextPhone = findViewById(R.id.etEditTextPhone);
        etEditTextEmailAddress = findViewById(R.id.etEditTextEmailAddress);
        etEditTextDate = findViewById(R.id.etEditTextDate);
        etDirectionClient = findViewById(R.id.etDirectionClient);

        spMembershipType = findViewById(R.id.spMembershipType);
        spExercisePlan = findViewById(R.id.spExercisePlan);

        //Configurar del botón para que capture los datos
        Button buttonSingUp = findViewById(R.id.buttonSingUp);
        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameUser = etNameUser.getText().toString();
                String apellidoClient = etApellidoClient.getText().toString();
                String phone = etEditTextPhone.getText().toString();
                String emailAddress = etEditTextEmailAddress.getText().toString();
                String birthDate = etEditTextDate.getText().toString();
                String directionClient = etDirectionClient.getText().toString();

                // Obtener las opciones seleccionadas
                String membershipType = spMembershipType.getSelectedItem().toString();
                String exercisePlan = spExercisePlan.getSelectedItem().toString();

                // Validar los campos y las selecciones
                if (TextUtils.isEmpty(nameUser) || TextUtils.isEmpty(apellidoClient) ||
                        TextUtils.isEmpty(phone) || TextUtils.isEmpty(emailAddress) ||
                        TextUtils.isEmpty(birthDate) || TextUtils.isEmpty(directionClient) ||
                        membershipType.equals("Seleccionar") || exercisePlan.equals("Seleccionar")) {
                    Toast.makeText(SingUpClientActivity.this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SingUpClientActivity.this, "Registro exitoso:\n" +
                            "Nombre: " + nameUser + "\n" +
                            "Apellido: " + apellidoClient + "\n" +
                            "Teléfono: " + phone + "\n" +
                            "Correo: " + emailAddress + "\n" +
                            "Fecha de Nacimiento: " + birthDate + "\n" +
                            "Dirección: " + directionClient + "\n" +
                            "Tipo de Membresía: " + membershipType + "\n" +
                            "Plan de Ejercicios: " + exercisePlan, Toast.LENGTH_LONG).show();

                    // Redirigir al LoginActivity
                    Intent intent = new Intent(SingUpClientActivity.this, LogInActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }

}