package com.example.flashcardsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[][] words = {
            {"domani", "tomorrow"},
            {"albergo", "hotel"},
            {"negozio", "shop"},
            {"cielo", "sky"}
    };
    int index = 0;

   Button button;
   EditText answerInput;
   TextView questionText, resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = (TextView) findViewById(R.id.questionText);
        questionText.setText(words[index][0]);

        answerInput = (EditText) findViewById(R.id.answerInput);
        resultText = (TextView) findViewById(R.id.resultText);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAnswer = answerInput.getText().toString();
                String result;
                if (userAnswer.equals(words[index][1])) {
                    result = "Correct!";
                } else {
                    result = "Incorrect!";
                }
                resultText.setText(result);

                index++;
                if (index >= words.length) {
                    questionText.setText("Finished!");
                } else {
                    questionText.setText(words[index][0]);
                }
            }
        });

    }
}
