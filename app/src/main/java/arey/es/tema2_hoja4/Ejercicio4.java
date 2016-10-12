package arey.es.tema2_hoja4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ejercicio4 extends AppCompatActivity {

    public static final int RESULT_EJERCICIO4A = 1;
    public static final int RESULT_EJERCICIO4B = 2;

    private TextView name;
    private TextView nameTransformed;

    private String nameReceived = "";
    private int operationReceived = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        name = (TextView)findViewById(R.id.textView1Ej4);
        nameTransformed = (TextView)findViewById(R.id.textView2Ej4);
    }

    /**
     * Solicita un nombre a la Activity Ejercicio4a
     * @param v
     */
    public void askName(View v) {
        Intent anIntent = new Intent(this, Ejercicio4a.class);
        startActivityForResult(anIntent,RESULT_EJERCICIO4A);
    }

    /**
     * Solicita una transformación a la Activity Ejercicio4b
     * @param v
     */
    public void askTransform(View v) {
        Intent anIntent = new Intent(this, Ejercicio4b.class);
        startActivityForResult(anIntent,RESULT_EJERCICIO4B);
    }

    /**
     * Recibe las respuestas tanto de Ejercicio4a como de Ejercicio4b
     * @param requestCode Contiene qué respuesta se recibe (Ejercicio4a o Ejercicio4b)
     * @param resultCode
     * @param data Contiene los datos introducidos en la Activity Ejercicio4a o Ejercicio4b
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Primero verificamos si la acción ha tenido éxito
        if (resultCode == RESULT_OK) {
            // Determinamos si el dato recibido es de Ejercicio4a o Ejercicio4b
            switch (requestCode) {
                case RESULT_EJERCICIO4A:
                    nameReceived = data.getStringExtra(Ejercicio4a.NAME);
                    showData();
                    break;
                case RESULT_EJERCICIO4B:
                    operationReceived = data.getIntExtra(Ejercicio4b.OPERATION, Ejercicio4b.NONE);
                    showData();
                    break;
            }
        }
    }

    /**
     * Muestra en los textviews la información transformada, según los parámetros recibidos
     */
    private void showData() {
        name.setText("El nombre introducido es: " + nameReceived.toString());
        String aux = "El nombre transformado es: ";
        nameTransformed.setText(aux);
        switch (operationReceived) {
            case Ejercicio4b.LOWER: nameTransformed.append(nameReceived.toLowerCase()); break;
            case Ejercicio4b.UPPER: nameTransformed.append(nameReceived.toUpperCase()); break;
            case Ejercicio4b.REVERSE: nameTransformed.append((new StringBuilder(nameReceived)).reverse()); break;
            default: nameTransformed.append(nameReceived); break;
        }
    }
}
