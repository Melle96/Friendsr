package com.example.melle.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// in FriendsAdapter wordt een element list van Friends gematcht met de gridview
public class FriendsAdapter extends ArrayAdapter<Friend> {

    // naam persoon en foto worden geinstantieerd
    public TextView PersonName;
    public ImageView PersonPhoto;


    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
    }


    // method in which will be determined what will be shown on the screen
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // de friend wordt opgemaakt
        Friend friend = getItem(position);
        // de id wordt opgeslagen
        int id = friend.getDrawableId();

        // view leeg is
        if (convertView == null) {
            // layout van grid_item wordt ingeladen
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // naam persoon instantiëren
        PersonName = convertView.findViewById(R.id.textView);
        // foto persoon instantiëren
        PersonPhoto = convertView.findViewById(R.id.imageView);

        // foto persoon om gegeven foto zetten
        PersonPhoto.setImageDrawable(getContext().getResources().getDrawable(id));
        // naam aan persoon meegeven
        PersonName.setText(friend.getName());

        // return deze layout
        return convertView;
    }
}
