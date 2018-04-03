package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VigenereOdsifrirana extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_odsifrirana);

        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                final String msg = (((EditText) findViewById(R.id.besedilo_vig_od)).getText()).toString();
                final String kok = (((EditText) findViewById(R.id.kljuc_vig_od)).getText()).toString();
                if ((msg.length() != 0) && (kok.length() != 0)) {
                    Intent results = new Intent(VigenereOdsifrirana.this,Results.class);
                    results.putExtra("str_zasif", vigenereOd(msg,kok));
                    Log.e("n", msg+"."+ kok);
                    startActivity(results);
                }
                else {
                    TextView mTitle = findViewById(R.id.opozorilo);
                    mTitle.setText("Prosim izpolnite vsa polja!");
                }
            }
        });
    }
    public String vigenereOd(String besedilo, String kljuc) {
        String rez = "";
        besedilo.toLowerCase();
        if(kljuc.length()>besedilo.length()){
            kljuc = kljuc.substring(0, besedilo.length());
        }

        String abeceda = null;
        for (int i = 0; i < (besedilo.length() / kljuc.length()); i++) {
            for (int j = 0; j < kljuc.length(); j++) {
                int trenuten = i * kljuc.length() + j;
                if (trenuten < besedilo.length()) {
                    char c = besedilo.charAt(trenuten);
                    String forever = "abcčdefghijklmnoprsštuvzž1234567890";
                    char d = kljuc.charAt(j);
                    int ta_kljuc = forever.indexOf(d);
                    abeceda = rotate(forever, ta_kljuc);
                    int charPosition = abeceda.indexOf(c);

                    char replaceValue = forever.charAt(charPosition);
                    rez += replaceValue;


                } else {
                    break;
                }
            }
        }

        return rez;
    }

    public static String rotate(String s, int offset) {
        int i = offset % s.length();
        return s.substring(i) + s.substring(0, i);
    }
}
