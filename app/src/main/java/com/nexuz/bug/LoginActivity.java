package com.nexuz.bug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private static final String USER = "nexuz";
    private static final String PASS = "bug123";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);
        EditText etUser = findViewById(R.id.etUser);
        EditText etPass = findViewById(R.id.etPass);
        Button btn = findViewById(R.id.btnLogin);
        btn.setOnClickListener(v -> {
            String u = etUser.getText().toString().trim();
            String p = etPass.getText().toString().trim();
            if (u.isEmpty() || p.isEmpty()) {
                Toast.makeText(this, "Isi dulu darling~", Toast.LENGTH_SHORT).show();
                return;
            }
            if (u.equals(USER) && p.equals(PASS)) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Salah, coba lagi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
