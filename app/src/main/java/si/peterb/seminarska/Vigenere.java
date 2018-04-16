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

public class Vigenere extends Activity {//poimenuje java class Vigenere in pove, da je to Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {//kaj bo storil, ko se Activity začne
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere);//uporablja "activity_vigenere" za layout
        getActionBar().setDisplayHomeAsUpEnabled(true);


        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                cela();
            }
        });//koda se začne izvajati z pritiskom gumba

    }
    public void cela () {
        final String msg = (((EditText) findViewById(R.id.besedilo_vig)).getText()).toString();//določi konstante "msg" in "kok"
        final String kok = (((EditText) findViewById(R.id.kljuc_vig)).getText()).toString();
        if ((msg.length() != 0) && (kok.length() != 0)) {//preveri, če slučajno nista konstante prazni
           try {
               Intent results = new Intent(Vigenere.this, Results.class);
               results.putExtra("str_zasif", vigenere(msg, kok));//pošlje besedilo, ki ga vrne "vigenere" v naslednji activity
               startActivity(results);
           }
           catch (Exception e) {//ta del se pokliče, če pride do kakršnih koli težav pri izvajanju kode
               Toast.makeText(getApplicationContext(), "nekaj je narobe :( (drugi del sporočila je: EP S)",Toast.LENGTH_SHORT).show();
           }
        }
        else {//če je kakšno polje prazno, potem se izvede ta del kode
            AlertDialog alertDialog = new AlertDialog.Builder(Vigenere.this).create();
            alertDialog.setTitle("Prazna polja");
            alertDialog.setMessage("Prosimo, da izpolnite vsa polja");


            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: DFTBA", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();//naredi obvestilo za uporabnika
        }
    }

    public String vigenere(String besedilo, String kljuc) {//del kode, ki je odgovoren za šifriranje
        String rez = "";
        besedilo.toLowerCase();
        if(kljuc.length()>besedilo.length()){//poskrbi, da je ključ dolg največ toliko kot besedilo
            kljuc = kljuc.substring(0, besedilo.length());
        }
        String abeceda = null;
        for (int i = 0; i < (besedilo.length() / kljuc.length()); i++) {//sledi postopku šifriranja po vigenereju
            for (int j = 0; j < kljuc.length(); j++) {
                int trenuten = i * kljuc.length() + j;
                if (trenuten < besedilo.length()) {
                    char c = besedilo.charAt(trenuten);
                    char charindex=kljuc.charAt(j);
                    String forever = "abcčdefghijklmnoprsštuvzž0123456789 wqyx";
                    int ta_kljuc = forever.indexOf(charindex);
                    abeceda = rotate(forever, ta_kljuc);
                    int mesto=forever.indexOf(c);
                    char replaceValue= abeceda.charAt(mesto);
                    rez += replaceValue;

                } else {
                    break;
                } } }
        return rez;}
    public static String rotate(String s, int offset) {//ker je potrebno generirati abecede v različnih vrstnih redih, ta funkcija stvari poenostavi
        int i = offset % s.length();
        return s.substring(i) + s.substring(0, i);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//del kode odgovoren za funkcionalnost gumba nazaj na zgornjem levem lotu zaslona
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
