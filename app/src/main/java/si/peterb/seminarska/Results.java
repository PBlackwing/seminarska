package si.peterb.seminarska;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView a= findViewById(R.id.main_zasifrirano);
        Intent s = getIntent();
        String neki = s.getStringExtra("str_zasif");
        a.setText(neki);
        Button button =  findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Results.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
