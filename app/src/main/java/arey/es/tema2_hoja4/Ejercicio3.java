package arey.es.tema2_hoja4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Ejercicio3 extends AppCompatActivity {


    public static final int GETUSERDATA = 1;

    private TextView textViewData;
    // Almacenamiento de un elemento anterior
    private StringBuilder oldData = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        textViewData = (TextView)findViewById(R.id.textView1Ejercicio3Data);
    }

    // Método invocado al pulsar un botón.
    public void getUserData(View v) {
        Intent anIntent = new Intent(this, Ejercicio3b.class);
        startActivityForResult(anIntent, GETUSERDATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch(requestCode) {
                case GETUSERDATA:
                    String name = data.getStringExtra(Ejercicio3b.RESULT_NAME);
                    int age = data.getIntExtra(Ejercicio3b.RESULT_AGE, 0);
                    String job = data.getStringExtra(Ejercicio3b.RESULT_JOB);

                    StringBuilder newData = new StringBuilder();
                    newData.append(name);
                    newData.append("\n");
                    newData.append(age);
                    newData.append("\n");
                    newData.append(job);
                    newData.append("\n");

                    textViewData.setText("Los datos obtenidos son:");
                    textViewData.append("\n");
                    textViewData.append(newData.toString());
                    textViewData.append("\n");
                    textViewData.append(oldData.toString());
                    oldData = new StringBuilder(newData);
                    Log.i("DATA", "Los datos recibidos son : " + age);
                    break;
            }
        }
    }
}
