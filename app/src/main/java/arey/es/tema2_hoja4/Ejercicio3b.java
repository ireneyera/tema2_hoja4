package arey.es.tema2_hoja4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ejercicio3b extends AppCompatActivity {

    public static final String RESULT_NAME = "RESULTADONOMBRE";
    public static final String RESULT_AGE = "RESULTADOEDAD";
    public static final String RESULT_JOB = "RESULTADOTRABAJO";
    private EditText name;
    private EditText age;
    private EditText job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3b);
        name = (EditText)findViewById(R.id.editTextName);
        age = (EditText)findViewById(R.id.editTextAge);
        job = (EditText)findViewById(R.id.editTextJob);
    }


    public void addData(View v){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(RESULT_NAME, name.getText().toString());
        resultIntent.putExtra(RESULT_AGE, Integer.parseInt(age.getText().toString()));
        resultIntent.putExtra(RESULT_JOB, job.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
