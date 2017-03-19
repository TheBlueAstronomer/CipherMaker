package com.example.jeff.projectvarsha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void Encrypt(View v) {
        int j = 1;
        char c;
        String res = "";
        EditText inputTxt = (EditText) findViewById(R.id.editText);
        String str = inputTxt.getText().toString();
        str=str.toUpperCase();

        for (int i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                j = 1;
                res += c;
                continue;
            }
            if ((j % 2) == 1)
            {
                for (int k = 0; k < j; k++)
                {
                        c += 1;
                        if (c > 90) {
                            c = 65;
                        }
                }
            }
            else
            {
                for (int k = 0; k < j; k++)
                {
                    c -= 1;
                    if (c < 65) {
                        c = 90;
                    }
                }
            }

            res = res.concat(Character.toString(c));
            j++;
        }

        TextView result = (TextView) findViewById(R.id.textView);
        result.setText(res);
    }
}
