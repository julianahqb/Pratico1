package com.example.professor.pratico1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {
    ImageButton btnDownload;
    ImageView imgView;
    ProgressBar pgbProgresso;

    public DownloadTask(ImageButton btnDownload, ImageView imgView, ProgressBar pgbProgresso) {
        this.btnDownload = btnDownload;
        this.imgView = imgView;
        this.pgbProgresso = pgbProgresso;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;
        try {
            //faz o download da imagem
            InputStream in = new URL(url).openStream();
            //converte a InputStream do Java para Bitmap
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e) {
            Log.e("DownloadTask","Erro ao fazer download da imagem");
        }
        return bitmap;
    }

    @Override
    protected void onPreExecute() {
        btnDownload.setEnabled(false);
        imgView.setVisibility(View.INVISIBLE);
        pgbProgresso.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        pgbProgresso.setVisibility(View.INVISIBLE);
        imgView.setImageBitmap(bitmap);
        imgView.setVisibility(View.VISIBLE);
        btnDownload.setEnabled(true);
    }

}