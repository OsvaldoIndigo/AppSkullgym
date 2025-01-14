package com.fic.myapplicationfic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailActivity extends AppCompatActivity {
    private TextView idClientDetail;
    private TextView nameDetail;
    private TextView telClientDetail;
    private TextView emailClientDetail;
    private TextView birthdateClientDetail;
    private TextView typeMemberClient;
    private TextView timeMembership;
    private TextView typeRoutine;
    private Button btnLogout; // Botón de cerrar sesión

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_detail);

        // Inicializar las vistas
        idClientDetail = findViewById(R.id.idClientDetail);
        nameDetail = findViewById(R.id.nameDetail);
        telClientDetail = findViewById(R.id.TelClientDetail);
        emailClientDetail = findViewById(R.id.emailClientDetail);
        birthdateClientDetail = findViewById(R.id.birthdateClientDetail);
        typeMemberClient = findViewById(R.id.typeMeberClient);
        timeMembership = findViewById(R.id.timeMebership);
        typeRoutine = findViewById(R.id.typerutine);
        btnLogout = findViewById(R.id.btnLogout); // Inicializar el botón

        // Simulación de datos
        String id = "12345";
        String name = "Juan Pérez";
        String phone = "555-1234";
        String email = "juan.perez@example.com";
        String birthdate = "01/01/1990";
        String membership = "Premium";
        String membershipExpiry = "31/12/2024";
        String routineType = "Fuerza";

        // Asignar datos a las vistas
        idClientDetail.setText("Tu ID: " + id);
        nameDetail.setText("Nombre: " + name);
        telClientDetail.setText("Número Telefónico: " + phone);
        emailClientDetail.setText("Correo Electrónico: " + email);
        birthdateClientDetail.setText("Cumpleaños: " + birthdate);
        typeMemberClient.setText("Membresía: " + membership);
        timeMembership.setText("Vence el: " + membershipExpiry);
        typeRoutine.setText("Tipo de Entrenamiento: " + routineType);

        // Configurar el botón de cerrar sesión
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al LoginActivity y limpiar el stack para evitar volver con el botón atrás
                Intent intent = new Intent(UserDetailActivity.this, LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
