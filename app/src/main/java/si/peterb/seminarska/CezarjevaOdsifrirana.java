package si.peterb.seminarska;//pove ime projekta

import android.app.Activity;//tu so zbrani vsi uvozi, ki jih ta activity potrebuje
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CezarjevaOdsifrirana extends Activity {//poimenuje java class CezarjevaOdsifrirana in pove, da je to Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {//kaj se zgodi takoj ob nastanku tega activity-ja
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezarjeva_odsifrirana);//uporablja "activity_cezarjeva_odsifrirana" za postavitev
        getActionBar().setDisplayHomeAsUpEnabled(true);//naredi gumb za vrnitev na prejšni activity

        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                cela();
            }
        });//s pritiskom na gumb se koda začne izvajati
    }

    public void cela () {
        final String msg = (((EditText) findViewById(R.id.besedilo)).getText()).toString();//določi konstanto "msg"
        String kok = (((EditText) findViewById(R.id.cezkljuc)).getText()).toString();//določi spremenljivko "kok"
        if ((msg.length() != 0) && (kok.length() != 0)) {//poskrbi, da "msg" in "kok" nista prazna
            try {
                if (kok.length() > msg.length()) {//poskrbi, da je ključ dolg največ toliko kot besedilo
                    kok = kok.substring(0, msg.length());
                }
                final int koliko = Integer.parseInt(kok);
                Intent results = new Intent(CezarjevaOdsifrirana.this, Results.class);
                results.putExtra("str_zasif", odsifriraj(msg, koliko));//v naslednji activity pošlje rezultat funkcije "odšifrirana"
                startActivity(results);
            }
            catch (Exception e) {//ta del se izvede samo, če pride kakšne izjeme
                Toast.makeText(getApplicationContext(), "nekaj je narobe vnešeno :( (tretji del sporočila je: TU)",Toast.LENGTH_SHORT).show();
            }
        }
        else {//če je kakšno polje prazno, naredi opozorilo za uporabnika
            AlertDialog alertDialog = new AlertDialog.Builder(CezarjevaOdsifrirana.this).create();
            alertDialog.setTitle("Prazna polja");
            alertDialog.setMessage("Prosimo, da izpolnite vsa polja");


            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: SEMINARSKA JE LAJF(ZADNJE ČASE...)", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();

        }
    }


    public String odsifriraj (String besedilce, int kljucek)
    {
        final String abeceda = "abcčdefghijklmnoprsštuvzž1234567890";//abeceda za odšifriranje
        besedilce = besedilce.toLowerCase();
        String rez = "";
        for (int i = 0; i < besedilce.length(); i++)
        {//odšifrira cezarjevo šifro z danim ključem
            int charPosition = abeceda.indexOf(besedilce.charAt(i));
            int keyVal = (charPosition-kljucek);
            if(keyVal<0){
                keyVal=36+keyVal;
            }
            char replaceValue = abeceda.charAt(keyVal);
            rez += replaceValue;
        }
        return rez;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//funkcija za vrnitev na prejšnji activity
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
