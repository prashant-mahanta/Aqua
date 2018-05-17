package com.example.android.aqua.Turbidity;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class TurbidityFragment extends Fragment {

    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    FirebaseUser user;

    ArrayList<object> TurbList =  new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView =  inflater.inflate(R.layout.data_list, container, false);

        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mReference = mDatabase.getReference("datas/"+user.getUid()+"/Turbidity");

        ValueEventListener dataListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                TurbList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    TurbList.add(dataSnapshot.getValue(object.class));
                }
                Collections.reverse(TurbList);

                TurbAdapter adapter = new TurbAdapter(getActivity(), TurbList);
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
