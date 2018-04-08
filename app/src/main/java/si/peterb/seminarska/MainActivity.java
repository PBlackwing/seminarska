package si.peterb.seminarska;//pove ime projekta

import android.app.Activity;//tu so zbrani vsi uvozi, ki jih ta activity potrebuje
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {//poimenuje java class MainActivity in pove, da je to Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {//to je funkcija, ki se jo pokliče, ko je activity ustvarjen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//uporablja activity_main datoteko za svojo postavitev

        Button button1 = findViewById(R.id.button);//določi gumb
        button1.setOnClickListener(new View.OnClickListener() {//tu se določi, kaj se bo zgodilo ob pritisku gumba
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radGroup);
                if(radioGroup.getCheckedRadioButtonId()==-1){//pove, kaj se zgodi, če ni ozačen nobeden od izbirnih gumbov
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: NOT DEFINED", Toast.LENGTH_SHORT).show();//skozi celotno aplikacijo sem dodal manjša presenečenja za uporabnike
                }
                else {//če pa je en izbirni gumb označen, potem pogleda kateri in zažene potreben activity
                    RadioButton radiobut = findViewById(R.id.Radiobutton);
                    if(radiobut.isChecked()) {
                        Intent i = new Intent(MainActivity.this, Cezarjeva.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, CezarjevaOdsifrirana.class);
                        startActivity(i);
                    }
                }
            }
        });
        Button button2 = findViewById(R.id.button2);//določi drugi gumb
        button2.setOnClickListener(new View.OnClickListener() {//pove kaj se zgodi ob pritisku dugega gumba
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radGroup);
                if(radioGroup.getCheckedRadioButtonId()==-1){//najprej pogleda, ali je eden od izbirnih gmbov označen in če ni, izvede nadaljeno kodo
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: NOT DEFINED#2", Toast.LENGTH_SHORT).show();//še eno izmed presenečenj v kodi
                }
                else {//če pa je en izbirni gumb označen, potem pogleda kateri in zažene potreben activity
                    RadioButton radiobut = findViewById(R.id.Radiobutton);
                    if(radiobut.isChecked()) {
                        Intent i = new Intent(MainActivity.this, Vigenere.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, VigenereOdsifrirana.class);
                        startActivity(i);
                    }
                };
            }
        });
    }
}