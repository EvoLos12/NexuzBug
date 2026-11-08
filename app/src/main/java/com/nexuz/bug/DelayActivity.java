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

public class DelayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_delay);
        EditText etNumber = findViewById(R.id.etNumber);
        EditText etCount = findViewById(R.id.etCount);
        Button start = findViewById(R.id.btnStart);
        start.setOnClickListener(v -> {
            String num = etNumber.getText().toString().trim();
            String cntStr = etCount.getText().toString().trim();
            if (num.isEmpty()) {
                Toast.makeText(this, "Nomor kosong", Toast.LENGTH_SHORT).show();
                return;
            }
            int count;
            try { count = Integer.parseInt(cntStr.isEmpty() ? "20" : cntStr); }
            catch (Exception e) { count = 20; }
            if (count > 500) count = 500;
            final String formatted = num.startsWith("62") ? num :
                    num.startsWith("0") ? "62" + num.substring(1) : num;
            final int total = count;
            Handler h = new Handler(Looper.getMainLooper());
            for (int i = 0; i < total; i++) {
                final int idx = i;
                h.postDelayed(() -> {
                    try {
                        Intent wa = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://wa.me/" + formatted + "?text="));
                        wa.setPackage("com.whatsapp");
                        startActivity(wa);
                        if (idx == total - 1)
                            Toast.makeText(this, "Delay selesai", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        if (idx == 0) Toast.makeText(this,
                                "WhatsApp gak ketemu", Toast.LENGTH_SHORT).show();
                    }
                }, i * 300L);
            }
        });
    }
}
