package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Zasifriraj.class);
                startActivity(i);//Result =1
            }
        });

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Odsifriraj.class);
                startActivity(i);//Result =1
            }
        });
    }
    }

 /*   final int RESULT =1;
    Button button1=findViewById(R.id.button);

    button1.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            TextView sifrirano = findViewById(R.id.main_zasifrirano);
            sifrirano.setText("");
            Intent i = new Intent( MainActivity.this, Cezarjeva.class);
            startActivityForResult(i,RESULT);//Result =1
        }
    });
}



    */