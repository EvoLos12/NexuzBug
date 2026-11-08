package com.nexuz.bug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        Button delay = findViewById(R.id.btnDelay);
        Button fc = findViewById(R.id.btnFc);
        delay.setOnClickListener(v -> startActivity(new Intent(this, DelayActivity.class)));
        fc.setOnClickListener(v -> startActivity(new Intent(this, ForceCloseActivity.class)));
    }
}
