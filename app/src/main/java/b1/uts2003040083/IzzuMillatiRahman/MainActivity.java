package b1.uts2003040083.IzzuMillatiRahman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton LK, PR;
    Button hi;
    EditText berat, tinggi;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LK = (RadioButton) findViewById(R.id.jLk);
        PR = (RadioButton) findViewById(R.id.jPr);
        hi = (Button) findViewById(R.id.hInput);
        berat = (EditText) findViewById(R.id.bb);
        tinggi = (EditText) findViewById(R.id.tt);
        result = (TextView) findViewById(R.id.res);

        hi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calc();
            }
        });

    }

    public void calc() {
        try {
            float b = Float.parseFloat(berat.getText().toString());
            float tCM = Float.parseFloat(tinggi.getText().toString());

            float t = tCM / 100;
            float bmi = b / (t * t);

            if (PR.isChecked()) {
                if (bmi < 18) {
                    result.setText("Under Weight/Kurus\n" + bmi);
                } else if (bmi >= 18 && bmi < 25) {
                    result.setText("Weight/Normal\n" + bmi);
                } else if (bmi >= 25 && bmi < 27) {
                    result.setText("Over Weight/Kegemukan\n" + bmi);
                } else if (bmi >= 27) {
                    result.setText("Obesitas\n" + bmi);
                }
            } else if (LK.isChecked()) {
                if (bmi < 17) {
                    result.setText("Under Weight/Kurus\n" + bmi);
                } else if (bmi >= 17 && bmi < 23) {
                    result.setText("Weight/Normal\n" + bmi);
                } else if (bmi >= 23 && bmi < 27) {
                    result.setText("Over Weight/Kegemukan\n" + bmi);
                } else if (bmi >= 27) {
                    result.setText("Obesitas\n" + bmi);
                }
            }
        } catch (Exception e){
            result.setText("Error");
        }
    }
}