package si.peterb.seminarska;//pove ime projekta

import android.app.Activity;//tu so zbrani vsi uvozi, ki jih ta activity potrebuje
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends Activity {////poimenuje java class Results in pove, da je to Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {//kaj se zgodi ob zagonu tega activity-ja
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView a= findViewById(R.id.main_zasifrirano);
        Intent s = getIntent();
        String neki = s.getStringExtra("str_zasif");//dobi poslano sporočilo iz prejšnjega activity-ja
        a.setText(neki);//to pokaže na zaslonu
        Button button =  findViewById(R.id.button7);//gumb potreben za vrnitev na glavni zaslon

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Results.this, MainActivity.class);
                startActivity(i);
            }
        });

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
