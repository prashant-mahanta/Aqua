package com.example.android.aqua;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;

import com.example.android.aqua.Bill.SixthActivity;
import com.example.android.aqua.Turbidity.ThirdActivity;
import com.example.android.aqua.Waterlevel.FifthActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SecondActivity extends AppCompatActivity implements
        View.OnClickListener {

    FirebaseDatabase mDatabase;
    DatabaseReference mReference1;
    DatabaseReference mReference2;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.turb).setOnClickListener(this);
        findViewById(R.id.waterlevel).setOnClickListener(this);
        findViewById(R.id.bill).setOnClickListener(this);
        findViewById(R.id.toggleButton).setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mReference1 = mDatabase.getReference("datas/" + user.getUid() + "/Notify/usercontrolwater");
        mReference2 = mDatabase.getReference("datas/" + user.getUid() + "/Notify/qualityTurbidity");

        mReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int usercontrolwater = dataSnapshot.getValue(Integer.class);
                ToggleButton toggleButton = findViewById(R.id.toggleButton);
                if (usercontrolwater == 0) {
                    toggleButton.setChecked(false);
                    notifications("Aqua User Control", "Water filling is Automatic");
                } else if (usercontrolwater == 1) {
                    toggleButton.setChecked(true);
                    notifications("Aqua User Control", "Water filling is Manual");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int qualityTurbidity = dataSnapshot.getValue(Integer.class);
                if (qualityTurbidity == 1) {
                    notifications("Aqua Water Control", "Water Quality is poor");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    public void DataActivity_1(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void DataActivity_3(View view) {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }

    public void DataActivity_4(View view) {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.turb) {
            DataActivity_1(view);
        } else if (i == R.id.waterlevel) {
            DataActivity_3(view);
        } else if (i == R.id.bill) {
            DataActivity_4(view);
        } else if (i == R.id.toggleButton) {
            if (((ToggleButton) view).isChecked()) {
                mReference1.setValue(1);
            } else {
                mReference1.setValue(0);
            }
        }
    }

    public void notifications(String title, String msg) {

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "channel_id")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.aqua)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.aqua))
                .setContentTitle(title)
                .setContentText(msg);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }

}
