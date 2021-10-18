package com.example.intenciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irHello(View view){
        Intent i=new Intent(this,hello.class);
        startActivity(i);
        // revisar bundle startActivity(i,);
    }
    public void abrirLink(View view){
        String pag= "https://www3.animeflv.net/";
        //Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(pag));
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(pag));
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }else{
            Log.d("click","No se encontro app");
        }
    }
    public void callPhone(View view){
        String num="3855943193";
        Intent i=new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+num));
        //como hacer que la app tenga el permiso sin necesidad de darcelo
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            //Log.d("click","no permisos");
            return ;
        }
        Log.d("click","no permisos");
        startActivity(i);
        /*
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }else{
            Log.d("click","No se encontro app");
        }
        */
    }
    //preguntar de recursos internos
    public void abrirImagen(View view){
        String img="//app/src/main/res/drawable/fate.jpg";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse(img),"image/*");
        startActivity(i);
    }
    public void abrirVideo(View view){
        String img="//app/src/main/res/drawable/fate.jpg";
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse(img),"video/*");
        startActivity(i);
    }
    public void abrirAudio(View view){
        String img="//app/src/main/res/drawable/fate.jpg";
        //findViewById(R.drawable.fate);
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse(img),"image/*");
        startActivity(i);
    }
    public void sendEmail(View view){
        //String email= "josef.ssj5@gmail.com";
        String email= ((Button) findViewById(R.id.button8)).getText().toString();
        Intent i=new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,email);

        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }else{
            Log.d("click","No se encontro app");
        }
    }
}