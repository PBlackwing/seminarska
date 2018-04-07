package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radGroup);
                if(radioGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: NOT DEFINED", Toast.LENGTH_SHORT).show();
                }
                else {
                    RadioButton radiobut = findViewById(R.id.Radiobutton);
                    if(radiobut.isChecked()) {
                        Intent i = new Intent(MainActivity.this, Cezarjeva.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, CezarjevaOdsifrirana.class);
                        startActivity(i);
                    }
                }
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radGroup);
                if(radioGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "EASTER EGGS: NOT DEFINED#2", Toast.LENGTH_SHORT).show();
                }
                else {
                    RadioButton radiobut = findViewById(R.id.Radiobutton);
                    if(radiobut.isChecked()) {
                        Intent i = new Intent(MainActivity.this, Vigenere.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, VigenereOdsifrirana.class);
                        startActivity(i);
                    }
                };
            }
        });
    }
}