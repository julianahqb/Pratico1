package com.example.professor.pratico1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnDownload;
    private EditText edtUrl;
    private ImageView imgView;
    private ProgressBar pgbProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = findViewById(R.id.btnDownload);
        edtUrl = findViewById(R.id.edtUrl);
        imgView = findViewById(R.id.imgView);
        pgbProgresso = findViewById(R.id.pgbProgresso);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask task = new DownloadTask(btnDownload, imgView, pgbProgresso);
                task.execute(edtUrl.getText().toString());
            }
        });

    }
}