package com.example.android.aqua.Waterlevel;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.aqua.Models.object;
import com.example.android.aqua.R;

import java.util.ArrayList;
import java.util.Locale;

public class WaterlevelAdapter extends ArrayAdapter<object> {

    public WaterlevelAdapter(Activity context, ArrayList<object> waterlevelArrayList) {
        super(context, 0, waterlevelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_waterlevel, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        object currentItem = getItem(position);

        LinearLayout linearLayout = listItemView.findViewById(R.id.linear);
        linearLayout.removeAllViews();

        TextView item = new TextView(getContext());
        String s = String.format(Locale.ENGLISH, "%f", currentItem.Value) + " at time -- " + String.format(Locale.ENGLISH, "%f", currentItem.Time);
        item.setTextSize(20);
        item.setText(s);
        item.setPadding(15, 15, 19, 15);
        linearLayout.addView(item);

        return listItemView;
    }

}
