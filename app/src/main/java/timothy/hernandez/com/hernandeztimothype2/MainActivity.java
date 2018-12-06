package timothy.hernandez.com.hernandeztimothype2;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText eFull, eAge , eGen;

    TextView tInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eFull = findViewById(R.id.fname);
        eAge = findViewById(R.id.age2);
        eGen = findViewById(R.id.gender2);
        tInfo = findViewById(R.id.info);

    }

    public void saveInternal (View v){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("information.txt", Context.MODE_PRIVATE);
            String info = eFull.getText().toString() + "\n";
            String info2 = eAge.getText().toString()+"\n";
            String info3 =  eGen.getText().toString()+"\n";
            fos.write(info.getBytes());
            fos.write(info2.getBytes());
            fos.write(info3.getBytes());
            Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error writing data...", Toast.LENGTH_LONG).show();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void displayInternal(View v) {
        try {
            FileInputStream fin = openFileInput("information.txt" );
            int c;
            StringBuffer buffer = new StringBuffer();
            while ((c = fin.read())!= -1) {
                buffer.append((char) c);
            }
            String tinfo = "" + buffer;
            tInfo.setText(tinfo);

        } catch (Exception e) {
            Toast.makeText(this, "Error reading...", Toast.LENGTH_LONG).show();
        }
    }
}