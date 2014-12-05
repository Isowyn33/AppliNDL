package com.cookiebots.applindl;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cookiebots.metier.Lieu;
import com.cookiebots.metier.Personne;
import com.cookiebots.metier.ZoneDanger;
import com.cookiebots.parsers.ParserLieu;
import com.cookiebots.parsers.ParserPersonne;
import com.cookiebots.parsers.ParserZoneDanger;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    public ListView LVClickable;
    final String EXTRA_LISTINFO = "list_info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LVClickable = (ListView)findViewById(R.id.LVClickable);

        ParserZoneDanger pzd = new ParserZoneDanger();
        List<ZoneDanger> lstZD = pzd.getListZone();

        ParserPersonne pP = new ParserPersonne();
        List<Personne> lstP = pP.getListPersonne();

        ParserLieu pL = new ParserLieu();
        List<Lieu> lstL = pL.getListLieux();

        Lieu lP = lieuProche(lstL);

        ZoneDanger zD = dangerProche(lstZD);

        ArrayList<String> myStringArray1 = new ArrayList<String>();
        myStringArray1.add(messageInfo(zD));
        myStringArray1.add(zD.getdanger());
        myStringArray1.add(lP.getNom());
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_main, myStringArray1);
        LVClickable.setAdapter(adapter);

        LVClickable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_param) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Location getPosition(){
        GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        return map.getMyLocation();
    }

    public Lieu lieuProche(List<Lieu> lstL){
        float distance = Float.MAX_VALUE;
        Lieu lieu = new Lieu();
        for(Lieu l : lstL){
            Location temp = new Location("temp");
            temp.setLatitude(l.getLatitude());
            temp.setLongitude(l.getLongitude());
            if(getPosition().distanceTo(temp) < distance){
                distance = getPosition().distanceTo(temp);
                lieu = l;
            }
        }
        return lieu;
    }

    public ZoneDanger dangerProche(List<ZoneDanger> lstZD){
        float distance = Float.MAX_VALUE;
        ZoneDanger zoneD = new ZoneDanger();
        for(ZoneDanger zd : lstZD){
            Location temp = new Location("temp");
            temp.setLatitude(zd.getLatitude());
            temp.setLongitude(zd.getLongitude());
            if(getPosition().distanceTo(temp) < distance){
                distance = getPosition().distanceTo(temp);
                zoneD = zd;
            }
        }
        return zoneD;
    }

    public String messageInfo(ZoneDanger zd){
        String message = "";
        Location temp = new Location("temp");
        temp.setLatitude(zd.getLatitude());
        temp.setLongitude(zd.getLongitude());
        if(getPosition().distanceTo(temp) < zd.getRayon()){
            message = "Attention vous vous trouvez actuellement en zone de dangers, courez!!!";
        }
        else{
            message = "Vous êtes quand même dans la merde ^^";
        }
        return message;
    }
}
