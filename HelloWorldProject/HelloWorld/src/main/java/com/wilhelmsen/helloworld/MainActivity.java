package com.wilhelmsen.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button button;
    TextView myText;
    TextView statusText;
    public final static String EXTRA_MESSAGE = "com.wilhelmsen.helloworld.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        statusText = (TextView) findViewById(R.id.statusText);

        //addListenerOnButton(); // Set button to go to vg.no


        // blabla
        button.setOnClickListener(btnPressed);
    }

    public void sendMessage (View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText messageText = (EditText) findViewById(R.id.messageTextBox);
        String message = messageText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


        statusText.setText("Message sent");
    }

    View.OnClickListener btnPressed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            myText.setText("Button clicked");
        }
    };

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vg.no"));
                startActivity(browserIntent);
            }
        });
    }
}
