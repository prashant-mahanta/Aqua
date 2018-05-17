package com.example.android.aqua.Bill;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.aqua.Models.User;
import com.example.android.aqua.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SixthActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    DatabaseReference mUsers;
    FirebaseUser user;
    float prevactualCost;

    TextView name;
    TextView phone;
    TextView gender;
    TextView cost;
    TextView predicted;
    TextView budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mUsers = mDatabase.getReference("users/"+user.getUid());
        mReference = mDatabase.getReference("datas/"+user.getUid());

        name = findViewById(R.id.user_name);
        phone = findViewById(R.id.user_phone);
        gender = findViewById(R.id.user_gender);
        cost = findViewById(R.id.user_cost);
        predicted = findViewById(R.id.predicted_cost);
        budget = findViewById(R.id.user_budget);

        mUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User obj = dataSnapshot.getValue(User.class);
                name.setText(getUsernameFromEmail("Name: "+obj.email));
                phone.setText("Phone no: "+obj.phone.toString());
                gender.setText("Gender: "+obj.sex);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cost.setText("Cost: "+dataSnapshot.child("actualCost").getValue(Float.class).toString());
                budget.setText("Budget: "+dataSnapshot.child("budget").getValue(Float.class).toString());
                predicted.setText("Predicted Cost: "+dataSnapshot.child("predictedPrice").getValue(Float.class).toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                float actualCost = dataSnapshot.child("actualCost").getValue(Float.class);
                if (prevactualCost != actualCost && actualCost > dataSnapshot.child("budget").getValue(Float.class)) {
                    notifications("Aqua Cost Control", "Oops! Your plan is over your budget");
                }
                prevactualCost = actualCost;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private String getUsernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
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
