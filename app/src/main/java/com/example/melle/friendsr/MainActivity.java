package com.example.melle.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // roep de activity_main layout aan
        setContentView(R.layout.activity_main);

        // maak een list van vrienden
        ArrayList<Friend> friendlist = new ArrayList<>();

        // er wordt 10 maal een class vriend gemaakt hierbij hoort een naam en biografie
        Friend gameofthrones1 = new Friend("arya", "Arya Stark is the third child and second daughter of Lord Eddard Stark and his wife, Lady Catelyn Stark.", getResources().getIdentifier(
                "arya","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones2 = new Friend("cersei", "Queen Cersei I Lannister is the widow of King Robert Baratheon and Queen of the Seven Kingdoms.", getResources().getIdentifier(
                "cersei","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones3 = new Friend("daenerys", "Queen Daenerys Targaryen, also known as Dany and Daenerys Stormborn, is the younger sister of Rhaegar Targaryen and Viserys Targaryen.", getResources().getIdentifier(
                "daenerys","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones4 = new Friend("jaime", "Ser Jaime Lannister is the eldest son of Tywin, younger twin brother of Cersei, and older brother of Tyrion Lannister.", getResources().getIdentifier(
                "jaime","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones5 = new Friend("jon", "Jon Snow, born Aegon Targaryen, is the son of Lyanna Stark and Rhaegar Targaryen, the late Prince of Dragonstone.", getResources().getIdentifier(
                "jon","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones6 = new Friend("jorah", "Ser Jorah Mormont is a formerly exiled Northern lord from Westeros previously living in Essos.", getResources().getIdentifier(
                "jorah","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones7 = new Friend("margaery", "Queen Margaery Tyrell was the only daughter of Lord Mace Tyrell and Lady Alerie Tyrell, granddaughter of Lady Olenna Tyrell and sister of Ser Loras Tyrell.", getResources().getIdentifier(
                "margaery","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones8 = new Friend("melisandre", "Melisandre, often referred to as the Red Woman, is a Red Priestess in the religion of R'hllor, the Lord of Light, and a close counsellor to Stannis Baratheon in his campaign to take the Iron Throne.", getResources().getIdentifier(
                "melisandre","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones9 = new Friend("sansa", "Lady Sansa Stark is the eldest daughter of Lord Eddard Stark of Winterfell and his wife Lady Catelyn, sister of Robb, Arya, Bran and Rickon Stark, and \"half-sister\" of Jon Snow.", getResources().getIdentifier(
                "sansa","drawable", MainActivity.this.getPackageName()));
        Friend gameofthrones10 = new Friend("tyrion", "Lord Tyrion Lannister is the youngest child of Lord Tywin Lannister and younger brother of Cersei and Jaime Lannister.", getResources().getIdentifier(
                "tyrion","drawable", MainActivity.this.getPackageName()));

        // alle friends worden toegevoegd aan de friendlist
        Collections.addAll(friendlist, gameofthrones1, gameofthrones2, gameofthrones3, gameofthrones4, gameofthrones5,
                gameofthrones6, gameofthrones7, gameofthrones8, gameofthrones9, gameofthrones10);

        // match de list  Friend met de grid layout via Friendsadapter door friendadapter te maken
        FriendsAdapter friendadapter = new FriendsAdapter(this, R.layout.grid_item, friendlist);
        // instantieer de gridview
        GridView gridview = findViewById(R.id.gridView);
        //  zet de adapter naar gridview
        gridview.setAdapter(friendadapter);
        // als er op een item van de gridview geklikt wordt, wordt functie GridItemClickListener aangeroepen
        gridview.setOnItemClickListener(new GridItemClickListener());

    }

    // functie waarbij er door een gridview element te kijken wordt doorgegaan naar de profileactivity/layout
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            // de friend wordt geinstantieerd
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(position);
            // nieuwe layout wordt klaargemaakt
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            // friend wordt in nieuwe activity gestopt
            intent.putExtra("clicked_friend", clickedFriend);
            // layout wordt geladen
            startActivity(intent);
        }
    }

}
