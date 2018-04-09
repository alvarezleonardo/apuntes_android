package com.example.leonardo.momadh.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leonardo.momadh.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

public class DetalleActivity extends AppCompatActivity {
    private TextView txtArtista;
    private TextView txtnombrePintura;
    private ImageView imgImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();

        String pintor = unBundle.getString("PINTOR");
        String nombreImagen = unBundle.getString("NAMEIMG");
        String rutaImagen = unBundle.getString("IMG");


        txtArtista = (TextView) findViewById(R.id.detalleArtista);
        txtnombrePintura = (TextView)  findViewById(R.id.detallePintura);
        imgImagen = (ImageView) findViewById(R.id.detalleImagen);

        txtArtista.setText(pintor);
        txtnombrePintura.setText(nombreImagen);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://momadh-58d56.appspot.com");
        StorageReference imagesRef = storageRef.child(rutaImagen);
        try {
            final File localFile = File.createTempFile("images", "png");
            imagesRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    imgImagen.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    //Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Compartir (View view){
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.setPackage("com.twitter.android");
        share.putExtra(Intent.EXTRA_TEXT, "El moma es muy bueno");
        startActivity(Intent.createChooser(share, "Compartir pintura"));
    }

}
