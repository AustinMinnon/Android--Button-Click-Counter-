package com.timbuchalka.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numTimesClicked++;
                String result = "The button got tapped " + numTimesClicked + " time";
                if(numTimesClicked != 1) {
                    result += "s......";
                }
                    ourMessage.setText(result);

            }
        };

        ourButton.setOnClickListener(ourOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "Text Value is now" + ourMessage.getText() + " resetting times clicked", Toast.LENGTH_LONG);
            toastMessage.show();
            numTimesClicked = 0;

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
