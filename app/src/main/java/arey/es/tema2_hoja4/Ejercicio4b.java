package arey.es.tema2_hoja4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Ejercicio4b extends AppCompatActivity {

    // Identifica que el dato que se va a enviar es la operación realizada
    public static final String OPERATION = "OPERATION";

    // Identifica la operación realizada
    public static final int NONE = 0;
    public static final int UPPER = 1;
    public static final int LOWER = 2;
    public static final int REVERSE = 3;

    private RadioButton lowerCase;
    private RadioButton upperCase;
    private RadioButton reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4b);

        lowerCase = (RadioButton)findViewById(R.id.radioButton1Ej4b);
        upperCase = (RadioButton)findViewById(R.id.radioButton2Ej4b);
        reverse = (RadioButton)findViewById(R.id.radioButton3Ej4b);
    }

    public void setData(View v) {
        Intent resultIntent = new Intent();

        if (v.equals(lowerCase)) {
            resultIntent.putExtra(OPERATION, LOWER);
        } else if (v.equals(upperCase)) {
            resultIntent.putExtra(OPERATION, UPPER);
        } else {
            resultIntent.putExtra(OPERATION, REVERSE);
        }

        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
