package pl.edu.wat.wel.secon.secon2017;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    // =============================================================================================
    Button buttonOpenContacts;
    Button buttonOpenSchedule;
    Button buttonOpenSponsors;
    Button buttonOpenMapConference;
    Button buttonOpenMapParty;

    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOpenContacts = (Button) findViewById(R.id.button_contact);
        buttonOpenSchedule = (Button) findViewById(R.id.button_schedule);
        buttonOpenSponsors = (Button) findViewById(R.id.button_sponsors);
        buttonOpenMapParty = (Button) findViewById(R.id.button_map_party);
        buttonOpenMapConference = (Button) findViewById(R.id.button_map_conference);

        onClickButton(buttonOpenContacts, ContactActivity.class);
        onClickButton(buttonOpenSchedule, ScheduleActivity.class);
        onClickButton(buttonOpenSponsors);
        onClickButton(buttonOpenMapConference);
        onClickButton(buttonOpenMapParty);

    }

    /**
     * Metoda przełączająca między aktywnościami, przyjmuje dwa parametry: nazwę przycisku, który
     * obsługuje zdarzenie i aktywność, na którą aplikacja ma się przełączyć.
     *
     * @param b Wybrany przycisk.
     * @param c Aktywność, na którą ma się przełączyć apka.
     */
    public void onClickButton(Button b, final Class c) {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, c);
                startActivity(intent);
            }
        });
    }

    public void onClickButton(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_map_conference: {
                        // Koordynaty dla biblioteki WAT
                        latitude = 52.252966;
                        longitude = 20.895570;
                        String label = getString(R.string.label_secon_place_of_conference);
                        mapIntentExecutor(latitude, longitude, label);
                        break;
                    }
                    case R.id.button_map_party:{
                        // Koordynaty dla imprezy towarzyszącej konferencji
                        latitude = 52.265980;
                        longitude = 20.932924;
                        String label = getString(R.string.label_secon_party);
                        mapIntentExecutor(latitude, longitude, label);
                        break;
                    }
                    case R.id.button_sponsors: {
                        // Strona do pdf z danymi dla firm na stronie konferencji
                        String websitePage = "http://secon.wel.wat.edu.pl/komunikat_dla_firm.pdf";
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websitePage));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.sponsors_button_toast_message_error, Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
            }
        });
    }



    //some comment delate it latter.,....................
    //2331213231
    //23232323
    //some comment delate it latter.,....................
    //2331213231
    //23232323
    //some comment delate it latter.,....................
    //2331213231
    //23232323




    /**
     * Metoda wykonująca intencję, by otworzyć mapę.
     *
     * @param latitudeLocal  Szerokość geograficzna.
     * @param longitudeLocal Długość geograficzna.
     * @param label          Nazwa miejsca mieszczącego się pod koordynantami.
     */
    public void mapIntentExecutor(double latitudeLocal, double longitudeLocal, String label) {
        String uriBegin = "geo:" + latitudeLocal + "," + longitudeLocal;
        String query = latitudeLocal + "," + longitudeLocal + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(getApplicationContext(), R.string.choose_app, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), R.string.map_app_avalible_toast_message_error, Toast.LENGTH_SHORT).show();
        }
    }
}




