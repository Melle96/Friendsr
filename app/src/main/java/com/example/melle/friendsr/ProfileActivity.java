package com.example.melle.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    //instantiëren van variabelen
    TextView biography, name;
    ImageView photo;
    RatingBar rating;
    EditText editText;
    SharedPreferences.Editor editor;
    Friend FriendClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout activity_profile is hier van toepassing
        setContentView(R.layout.activity_profile);

        // intent wordt verkregen
        Intent intent = getIntent();
        // Friend die aangeklikt is wordt opgeslagen in FriendClicked
        FriendClicked = (Friend) intent.getSerializableExtra("clicked_friend");

        // variabelen met juiste textboxen, iamgeview en ratingbar verhouden
        photo = findViewById(R.id.imageView2);
        biography = findViewById(R.id.textView3);
        name = findViewById(R.id.textView2);
        rating = findViewById(R.id.ratingBar);
        editText = (EditText) findViewById(R.id.plain_text_input);

        // foto zetten
        photo.setImageDrawable(getResources().getDrawable(FriendClicked.getDrawableId()));
        // naam zetten

        name.setText(FriendClicked.getName());


        // voor de rating wordt de functie ratingchangelistener aangeroepen
        rating.setOnRatingBarChangeListener(new RatingChangeListener());

        // rating wordt aangeroepen
        editor = getSharedPreferences("ratingfriend", MODE_PRIVATE).edit();
        SharedPreferences prefs = getSharedPreferences("ratingfriend", MODE_PRIVATE);

        // ratingranking is een float aangezien er ook halve sterren kunnen worden gegeven
        Float ratingranking = prefs.getFloat(FriendClicked.getName(), 0);

        // als de rating nul oftewel leeg is
        if(ratingranking != 0) {
            rating.setRating(prefs.getFloat(FriendClicked.getName(), 0.0f));
            // rating wordt gezet op vorige rating
        }
        else {
            rating.setRating(0.0f);
            //rating wordt op nul gezet
        }
        editor.apply();

        // hier wordt de biografie geplaatst
        editor = getSharedPreferences("biofriend", MODE_PRIVATE).edit();
        SharedPreferences prefsbio = getSharedPreferences("biofriend", MODE_PRIVATE);

        // de string in biofriend uit sharedpreferences wordt opgeslagen in een sting
        String biofriend = prefsbio.getString(FriendClicked.getName(), null);

        // als biofriend niet leeg is
        if(biofriend != null) {
            FriendClicked.setBio(prefsbio.getString(FriendClicked.getName(), null));

        }
        else {
            FriendClicked.setBio(FriendClicked.getBio());
        }
        /// biografie tekst wordt meegegeven
        biography.setText(FriendClicked.getBio());
        editor.apply();
    }

    // ratingchanger wordt gemaakt
    private class RatingChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            // de sharedpreferences wordt geinstantieerd
            SharedPreferences prefs = getSharedPreferences("ratingfriend", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            // er wordt een float geput wordt de friend
            editor.putFloat(FriendClicked.getName(), v);
            editor.apply();
            // er wordt voor friend een rating geset
            FriendClicked.setRating(v);

        }
    }

    // deze functie wordt aangeroepen als de button geklikt wordt
    public void changebio(View view){
        // string van edittext wordt verkregen
        String string = editText.getText().toString();
        // biografie wordt gezet met string
        FriendClicked.setBio(string);
        biography.setText(FriendClicked.getBio());

        // de sharedpreferences wordt geinstantieerd
        SharedPreferences prefs = getSharedPreferences("biofriend", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        // nieuwe biografietekst wordt meegegeven
        editor.putString(FriendClicked.getName(), string);
        editor.apply();
    }

}