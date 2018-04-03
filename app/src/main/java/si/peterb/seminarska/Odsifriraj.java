package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Peter on 2. 04. 2018.
 */

public class Odsifriraj extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odsifriraj);
        Button btn =  findViewById(R.id.button8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Odsifriraj.this, CezarjevaOdsifrirana.class);
                startActivity(i);
            }
        });
        Button btn2 =  findViewById(R.id.button9);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Odsifriraj.this, VigenereOdsifrirana.class);
                startActivity(i);
            }
        });
    }

}
