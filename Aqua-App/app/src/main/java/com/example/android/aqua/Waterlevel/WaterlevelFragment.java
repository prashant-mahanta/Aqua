package com.example.android.aqua.Waterlevel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.aqua.Models.object;
import com.example.android.aqua.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;


public class WaterlevelFragment extends Fragment {
    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    FirebaseUser user;

    ArrayList<object> WaterlevelList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.data_list, container, false);

        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mReference = mDatabase.getReference("datas/" + user.getUid() + "/Waterlevel");

        ValueEventListener dataListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                WaterlevelList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    WaterlevelList.add(dataSnapshot.getValue(object.class));
                }
                Collections.reverse(WaterlevelList);

                WaterlevelAdapter adapter = new WaterlevelAdapter(getActivity(), WaterlevelList);
                ListView listView = rootView.findViewById(R.id.list);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
            }
        };
        mReference.addValueEventListener(dataListener);

        return rootView;
    }
}