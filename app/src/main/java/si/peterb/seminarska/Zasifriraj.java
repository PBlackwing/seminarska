package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Peter on 2. 04. 2018.
 */

public class Zasifriraj extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zasifriraj);
        final int RESULT = 1;
        Button btn =  findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Zasifriraj.this, Cezarjeva.class);
                startActivity(i);
            }
        });
        Button btn2 =  findViewById(R.id.button4);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Zasifriraj.this, Vigenere.class);
                startActivity(i);
            }
        });
    }

}
