package com.example.android.aqua.Waterlevel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.aqua.Models.object;
import com.example.android.aqua.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class waterlevelgraphFragment extends Fragment {

    private LineChart mChart;
    FirebaseDatabase mDatabase;
    DatabaseReference mReference;
    FirebaseUser user;
    private ArrayList<object> array;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_waterlevelgraph, container, false);

        mChart = view.findViewById(R.id.linechartTurb);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setHighlightPerDragEnabled(true);
        mChart.setHighlightPerTapEnabled(true);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);

        YAxis yAxis = mChart.getAxisRight();
        yAxis.setEnabled(false);

        mChart.setVisibleXRangeMaximum(100);

        LineData data = new LineData();
        mChart.setData(data);

        array = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        mReference = mDatabase.getReference("datas/" + user.getUid() + "/Waterlevel");

        ValueEventListener dataListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    object ob = dataSnapshot.getValue(object.class);
                    array.add(ob);
                }

                ArrayList<Entry> entry = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    entry.add(new Entry(array.get(i).Time, array.get(i).Value));
                }

                LineData data = mChart.getData();
                LineDataSet set1 = new LineDataSet(entry, "Dataset 1");
                set1.setFillAlpha(110);
                set1.setColor(Color.YELLOW);
                set1.setLineWidth(3f);
                set1.setValueTextSize(10f);
                set1.setCircleColor(Color.RED);
                set1.setCircleRadius(3f);
                set1.setHighlightEnabled(true);
                set1.setHighLightColor(Color.RED);
                set1.setValueTextColor(Color.BLACK);

                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1);

                data.removeDataSet(0);
                data.addDataSet(dataSets.get(0));

                mChart.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
            }
        };
        mReference.addValueEventListener(dataListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mChart.notifyDataSetChanged();
    }

    public int createChart(ArrayList<object> values) {

        ArrayList<Entry> entry = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            entry.add(new Entry(values.get(i).Time, values.get(i).Value));
        }

        LineData data = mChart.getData();
        LineDataSet set1 = new LineDataSet(entry, "Dataset 1");
        set1.setFillAlpha(110);
        set1.setColor(Color.RED);
        set1.setLineWidth(3f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.YELLOW);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);


        data.removeDataSet(0);
        data.addDataSet(dataSets.get(0));

        mChart.notifyDataSetChanged();

        return 0;
    }
}
