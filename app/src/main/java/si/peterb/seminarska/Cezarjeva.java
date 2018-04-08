package si.peterb.seminarska;//pove, da je del projekta seminarska

import android.app.Activity;//vsi potrebni uvozi za ta activity
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cezarjeva extends Activity {//poimenuje java class Cezarjeva in pove, da je to Activity

    @Override//pove kaj narediti, ko se začne ta activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezarjeva);//pove, kateri layout uporablja
        getActionBar().setDisplayHomeAsUpEnabled(true);//ta del kode je potreben za gumb za vrnitev v zgornjem levem kotu zaslona


        Button button5 = findViewById(R.id.button5);//pove kaj se imenuje button5
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {//ob pritisku se pokliče funkcija cela()
                cela();

            }
        });

    }

    public void cela () {//ta funkcija je bila upeljana zaradi lažje beljivosti kode
        final String msg = (((EditText) findViewById(R.id.besedilo)).getText()).toString();//pove, da je "msg" besedilo in da se ne bo več spreminjalo. Pove tudi, iz kje dobi to besedilo
        String kok = (((EditText) findViewById(R.id.cezkljuc)).getText()).toString();//"kok" je spremenljivka in je besedilo. Določi tudi, iz kje dobi vrednost za "kok"
        if ((msg.length() != 0) && (kok.length() != 0)) {//preveri, če je kateri od obeh vrednosti "kok" ali "msg" prazen
            try {//ta try-catch določitev je pomembna, saj bi uporabnik v prostor za ključ vpisal besedo, čeprav je vprašan za številko
                if (kok.length() > msg.length()) {//ta if izraz je potreben, če je ključ daljši od sporočila in temu primerno ključ skrajša
                    kok = kok.substring(0, msg.length());
                }
                final int koliko = Integer.parseInt(kok);//določi konstanto "koliko", ki funkcionira kot ključ za cezarjevo šifro
                Intent results = new Intent(Cezarjeva.this, Results.class);//pove, da bi rad začel nov activity
                results.putExtra("str_zasif", zasifriraj(msg, koliko));//ta del kode predaja vrednosti med activity-ji. Naprej bo podal vrednost, ki jo dobi iz funkcije zašifriraj
                startActivity(results);//začne nov activity
            }
            catch (Exception e) {//če ni vpisana številka v polje s ključem, ali kakšna druga nepredvidena napaka, potem izvede to kodo
                Toast.makeText(getApplicationContext(), "nekaj je narobe :( (prvi del sporočila je: JE)",Toast.LENGTH_SHORT).show();//uporabniku pove, da je prišlo do napake
            }
        }
        else {//pove uporabniku, da so polja prazna in da jih mora za nadaljevanje izpolniti
            AlertDialog alertDialog = new AlertDialog.Builder(Cezarjeva.this).create();
            alertDialog.setTitle("Prazna polja");
            alertDialog.setMessage("Prosimo, da izpolnite vsa polja");


            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: ALERT MISSILES INCOMING", Toast.LENGTH_SHORT).show();
                }
            });//ko uporabnik pritisne gumb ok, ki se je pojavil skupaj z opozorilom, napiše še eno izmed sporočil, ki sem ga skril v aplikacijo

            alertDialog.show();

        }

    }


    public String zasifriraj (String besedilce, int kljucek)//poimenuje funkcijo "zašifriraj". Pove, da bo vrnila besedilo in da vzame dva argumenta
    {
        final String abeceda = "abcčdefghijklmnoprsštuvzž1234567890";//abeceda, ki se uporablja za šifriranje
        besedilce = besedilce.toLowerCase();//"msg" spremeni v  male črke
        String rez = "";//to je besedilo, kamor se bo dodajal rezultat
        for (int i = 0; i < besedilce.length(); i++) {//zanka, ki se požene za vsako črko v besedilu.
            int charPosition = abeceda.indexOf(besedilce.charAt(i));//določa vrednosti, ki jih potrebuje za šifriranje
            int keyVal = (kljucek + charPosition) % 36;
            char replaceValue = abeceda.charAt(keyVal);
            rez += replaceValue;//"replaceValue" je vrednost zašifriranjega znaka, ki ga doda v "rez"ultat.
        }
        return rez;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//koda, ki pove kaj se naredi, ko uporabnik pritisne gumb nazaj
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }







}
