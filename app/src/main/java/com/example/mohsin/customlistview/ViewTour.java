package com.example.mohsin.customlistview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class ViewTour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tour);
//        setSupportActionBar(findViewById(R.id.toolbar));

//        get values passed from hte list view
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        final String location = intent.getStringExtra("location");
        final String phone = intent.getStringExtra("phone");
        String lodges = intent.getStringExtra("lodges");
        String desc = intent.getStringExtra("desc");
        String distance = intent.getStringExtra("distance");
        Bundle bundle = getIntent().getExtras();

        int image = bundle.getInt("image");

        TextView Title, Location, Phone, Lodge, Desc, Distance;
        Title = findViewById(R.id.tourName);
        Title.setText(title);

        Location = findViewById(R.id.tourLoc);
        Location.setText("Location: "+location);

        Phone = findViewById(R.id.phone);
        Phone.setText("Phone: "+phone);

        Lodge = findViewById(R.id.lodge);
        Lodge.setText("Lodges : "+lodges);

        Desc = findViewById(R.id.desc);
        Desc.setText(desc);

        Distance = findViewById(R.id.distance);
        Distance.setText("Distance: " +distance);


        ImageView Image = findViewById(R.id.tourImage);
        Image.setImageResource(image);

//        Button to open call dial to call for a booking
        Button callButton = findViewById(R.id.call_now);
        callButton.setMaxWidth(100);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone));

                if (ContextCompat.checkSelfPermission(ViewTour.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ViewTour.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);

                } else {
                    //You already have permission
                    try {
                        startActivity(callIntent);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        Button to open google maps so as to display the toursit location
        Button locateButton = findViewById(R.id.locate_btn);

        locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=" + location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

}