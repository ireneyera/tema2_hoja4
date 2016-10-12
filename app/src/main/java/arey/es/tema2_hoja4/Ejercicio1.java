package arey.es.tema2_hoja4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class Ejercicio1 extends AppCompatActivity {

    private static final int PERMISSION_RETURN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
    }

    public void directCall(View v) {
        Intent anIntent = new Intent(Intent.ACTION_CALL);
        anIntent.setData(Uri.parse("tel:666555666"));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(anIntent);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_RETURN);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_RETURN:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Intent anIntent = new Intent(Intent.ACTION_CALL);
                    anIntent.setData(Uri.parse("tel:666555666"));
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(anIntent);
                    }
                }
                break;
        }
    }

    public void setAlarm(View v) {
        Calendar d = Calendar.getInstance();
        Intent anIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        anIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Clase de PMDM");
        anIntent.putExtra(AlarmClock.EXTRA_HOUR, d.get(Calendar.HOUR));
        anIntent.putExtra(AlarmClock.EXTRA_MINUTES, d.get(Calendar.MINUTE));
        startActivity(anIntent);
    }
}
