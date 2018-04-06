package com.example.android.gamingquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score; //Variable keeping track of the score
    boolean checkbox = false; //Keeps track if a CheckBox has been checked or not
    boolean RadioButtonn = false; //Keeps track if a RadioButton has been checked or not

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    EditText answerEditText_1;
    EditText answerEditText_2;



    RadioButton RadioButton1;
    RadioButton RadioButton2;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerEditText_1 = findViewById(R.id.questionNr_1);
        answerEditText_2 = findViewById(R.id.questionNr_4);

        checkBox1 = findViewById(R.id.CB_answer_1_4);
        checkBox2 = findViewById(R.id.CB_answer_2_4);
        checkBox3 = findViewById(R.id.CB_answer_3_4);
        checkBox4 = findViewById(R.id.CB_answer_4_4);

        RadioButton1 = findViewById(R.id.RB1_answer_3_3);
        RadioButton2 = findViewById(R.id.RB2_answer_1_2);


        radioGroup1 = findViewById(R.id.radioGroup_1);
        radioGroup2 = findViewById(R.id.radioGroup_2);

        Button resetButton = findViewById(R.id.Reset);
        resetButton.setVisibility(View.GONE);
    }


    /**
     * Question Nr. 2
     * Method that checks correct answers(Checkbox);
     */
    public void checkBox(View view) {
        //checks if button is now checked
        boolean isChecked = ((CheckBox) view).isChecked();

        // Checking which checkBox was clicked
        switch (view.getId()) {
            case R.id.CB_answer_1_4:
                checkbox = isChecked;
                break;

            case R.id.CB_answer_2_4:
                checkbox = isChecked;
                break;

            case R.id.CB_answer_3_4:
                checkbox = isChecked;
                break;

            case R.id.CB_answer_4_4:
                checkbox = isChecked;

                break;
            default:
                break;
        }

    }

    /**
     * Question Nr. 3 & 5
     * Method that checks correct answers in radioGroup1 and radioGroup 2;
     */
    public void onRadioButtonClick(View view) {
        //checks if RB is checked
        boolean RB_isClicked = ((RadioButton) view).isChecked();

        // Checking which radioButton was clicked
        switch (view.getId()) {

            //Question Nr.2
            case R.id.RB1_answer_3_3:
                RadioButtonn = RB_isClicked;
                Log.v("MainActivity", "the total score is: " + score);

            // Question Nr.5
            case R.id.RB2_answer_1_2:
                RadioButtonn = RB_isClicked;
                Log.v("MainActivity", "the total score is: " + score);

                break;
            default:
                break;
        }
    }

    public void send(View view) {

        //Checks answer for Question Nr.1
        if (answerEditText_1.getText().toString().toLowerCase().equalsIgnoreCase("player vs environment ")) {
            score = score +1;
            Log.v("MainActivity", "the total score is: " + score);
        }

        //Checks answers for Question Nr.2
        if (!checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
            score +=1;
            Log.v("MainActivity", "the total score is: " + score);
        }

        //Checks answers for Question Nr.3
        if (RadioButton1.isChecked() && RadioButton2.isChecked()) {
            score +=2;
            Log.v("MainActivity", "the total score is: " + score);
        }

        //Checks answer for Question Nr.4
        if (answerEditText_2.getText().toString().toLowerCase().equalsIgnoreCase("non player character ")) {
            score += 1;
            Log.v("MainActivity", "the total score is: " + score);
        }

        // reports information about incomplete selection of all answers
        if ((!RadioButtonn) || (!checkbox)){
            Toast.makeText(this, R.string.all_answers_not_marked, Toast.LENGTH_SHORT).show();

            return;
        }

        // show results
        if (score == 5) {
            String string = getString(R.string.right_answer);
            Toast.makeText(this, string + score, Toast.LENGTH_LONG).show();
        }

        if (score < 5) {
            String string = getString(R.string.you_loose);
            string = string + getString(R.string.wrong_answer) + score;
            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
        }

        // show results
        if (score > 5) {
            String string = getString(R.string.error);
            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
        }

        //Make reset Button Visible and hide "send"
        Button resetButton = findViewById(R.id.Reset);
        resetButton.setVisibility(View.VISIBLE);
        Button sendButton = findViewById(R.id.Send);
        sendButton.setVisibility(View.GONE);

    }

    public void reset(View view) {
        score = 0;
        checkbox = false;
        RadioButtonn = false;

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();

        RadioButton1.setChecked(false);
        RadioButton2.setChecked(false);

        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        answerEditText_1.setText("");
        answerEditText_2.setText("");

        //Show send button, hid reset button
        Button sendButton = findViewById(R.id.Send);
        sendButton.setVisibility(View.VISIBLE);
        Button resetNButton = findViewById(R.id.Reset);
        resetNButton.setVisibility(View.GONE);

    }

}


