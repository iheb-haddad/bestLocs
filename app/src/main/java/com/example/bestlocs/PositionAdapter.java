package com.example.bestlocs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PositionAdapter extends ArrayAdapter<Position> {

    private final Context context;
    private final List<Position> positions;

    public PositionAdapter(Context context, List<Position> positions) {
        super(context, R.layout.list_item_custom, positions);
        this.context = context;
        this.positions = positions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate or reuse the custom layout
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_custom, parent, false);
        }

        // Get the current Position object
        Position currentPosition = positions.get(position);

        // Bind data to the views
        TextView pseudoTextView = convertView.findViewById(R.id.item_pseudo);
        TextView numeroTextView = convertView.findViewById(R.id.item_numero);
        TextView locationTextView = convertView.findViewById(R.id.item_location);

        pseudoTextView.setText(currentPosition.getPseudo());
        numeroTextView.setText("Number: " + currentPosition.getNumero());
        locationTextView.setText(
                "Location: " + currentPosition.getLongitude() + ", " + currentPosition.getLatitude()
        );

        return convertView;
    }
}
