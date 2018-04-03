package si.peterb.seminarska;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CezarjevaOdsifrirana extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezarjeva_odsifrirana);

        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                cela();
            }
        });
    }

    public void cela () {
        final String msg = (((EditText) findViewById(R.id.besedilo)).getText()).toString();
        String kok = (((EditText) findViewById(R.id.cezkljuc)).getText()).toString();
        if ((msg.length() != 0) && (kok.length() != 0)) {
            try {
                if (kok.length() > msg.length()) {
                    kok = kok.substring(0, msg.length());
                }
                final int koliko = Integer.parseInt(kok);
                Intent results = new Intent(CezarjevaOdsifrirana.this, Results.class);
                results.putExtra("str_zasif", odsifriraj(msg, koliko));
                Log.e("n", msg + "." + kok);
                startActivity(results);
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "nekaj je narobe vnešeno :( (tretji del sporočila je: TU)",Toast.LENGTH_SHORT).show();
            }
        }
        else {
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
        final String abeceda = "abcčdefghijklmnoprsštuvzž1234567890";
        besedilce = besedilce.toLowerCase();
        String rez = "";
        for (int i = 0; i < besedilce.length(); i++)
        {
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
}
