package arey.es.tema2_hoja4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ejercicio4a extends AppCompatActivity {

    public static final String NAME = "NAME";
    public EditText myName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4a);

        myName = (EditText)findViewById(R.id.editText1Ej4a);
    }

    public void setName(View v) {
        Intent anIntent = new Intent();
        anIntent.putExtra(NAME, myName.getText().toString());
        setResult(RESULT_OK, anIntent);
        finish();
    }
}
