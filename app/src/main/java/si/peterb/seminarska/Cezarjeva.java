package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cezarjeva extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezarjeva);


        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                final String msg = (((EditText) findViewById(R.id.besedilo)).getText()).toString();
                String kok = (((EditText) findViewById(R.id.cezkljuc)).getText()).toString();
                if ((msg.length() != 0) && (kok.length() != 0)) {
                    if(kok.length()>msg.length()){
                        kok = kok.substring(0, msg.length());
                    }
                    final int koliko = Integer.parseInt(kok);
                    Intent results = new Intent(Cezarjeva.this,Results.class);
                    results.putExtra("str_zasif", zasifriraj(msg,koliko));
                    Log.e("n", msg+"."+ kok);
                    startActivity(results);
                }
                else {
                    TextView mTitle = findViewById(R.id.opozorilo);
                    mTitle.setText("izpolnite potrebna polja!!");

                }
            }
        });

    }

    public String zasifriraj (String besedilce, int ključek)
    {
        final String abeceda = "abcčdefghijklmnoprsštuvzž1234567890";
        besedilce = besedilce.toLowerCase();
        String rez = "";
        for (int i = 0; i < besedilce.length(); i++)
        {
            int charPosition = abeceda.indexOf(besedilce.charAt(i));
            int keyVal = (ključek + charPosition) % 36;
            char replaceValue = abeceda.charAt(keyVal);
            rez += replaceValue;
        }
        return rez;
    }









}
