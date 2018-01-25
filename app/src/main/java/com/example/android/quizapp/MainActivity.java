package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // method is called when submit button is clicked
    public void submitPoints(View view) {
        //User add name
        EditText fieldName = (EditText) findViewById(R.id.field_name);
        String addName = fieldName.getText().toString();

        //
        EditText mountainName = (EditText) findViewById(R.id.q1);
        String isK2 = mountainName.getText().toString();

        RadioButton blancButton = (RadioButton) findViewById(R.id.radio_q2c);
        boolean isBlancClicked = blancButton.isChecked();

        RadioButton kosciuszkoButton = (RadioButton) findViewById(R.id.radio_q3a);
        boolean isKosciuszkoClicked = kosciuszkoButton.isChecked();

        RadioButton andesButton = (RadioButton) findViewById(R.id.radio_q4b);
        boolean isAndesClicked = andesButton.isChecked();

        RadioButton matterhornButton = (RadioButton) findViewById(R.id.radio_q6b);
        boolean isMatterhornClicked = matterhornButton.isChecked();

        CheckBox rockyCheckbox = (CheckBox) findViewById(R.id.checkbox_q5a);
        boolean isRockyClicked = rockyCheckbox.isChecked();

        CheckBox andesCheckbox = (CheckBox) findViewById(R.id.checkbox_q5b);
        boolean isAndesq5Clicked = andesCheckbox.isChecked();

        CheckBox sierraCheckbox = (CheckBox) findViewById(R.id.checkbox_q5c);
        boolean isSierraClicked = sierraCheckbox.isChecked();

        int points = calculatePoints(isBlancClicked, isKosciuszkoClicked, isAndesClicked,
                isMatterhornClicked, isRockyClicked, isSierraClicked, isAndesq5Clicked, isK2);
        String pointsMessage = createQuizSummary(points);
        displayMessage(pointsMessage);

//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/html");
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
//        intent.putExtra(Intent.EXTRA_TEXT, pointsMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//
//        }

        Button submitButton = (Button) findViewById(R.id.submit_button);;
        submitButton.setVisibility(View.INVISIBLE);

    }

    public void resetButton(View view) {
        points = 0;
        setContentView(R.layout.activity_main);

    }
    /**
     * Calculates points of the quiz.
     *
     * @param isBlancClicked      - user has choosen correct answer for q2
     * @param isKosciuszkoClicked - user has choosen correct answer for q3
     * @param isAndesClicked      - user has choosen correct answer for q4
     * @param isRockyClicked      & isSierraClicked - user has choosen correct answers for q5
     * @param isAndesq5Clicked    - user has choosen answers for q5
     * @param isMatterhornClicked - user has choosen correct answers for q6
     * @return total points
     */
    private int calculatePoints(boolean isBlancClicked, boolean isKosciuszkoClicked,
                                boolean isAndesClicked, boolean isMatterhornClicked,
                                boolean isRockyClicked, boolean isSierraClicked,
                                boolean isAndesq5Clicked, String isK2) {


        // add 1 point if user correctly response for q2
        if (isBlancClicked) {
            points = points + 1;
        }
        // add 1 point if user correctly response for q3
        if (isKosciuszkoClicked) {
            points = points + 1;
        }
        // add 1 point if user correctly response for q4
        if (isAndesClicked) {
            points = points + 1;
        }

        // add 1 point if user correctly response for q5
        if (isRockyClicked && isSierraClicked && isAndesq5Clicked == false) {
            points = points + 1;
        }

        // add 1 point if user correctly response for q6
        if (isMatterhornClicked) {
            points = points + 1;
        }
        System.out.println(isK2);
        // add 1 point if user correctly response for q1
        if ("K2".equalsIgnoreCase(isK2)) {
            points = points + 1;
        }

        // calculate total number of points
        return points;
    }



    /**
     * Create summary of a quiz
     *
     * @param points
     * @return text summary
     */
    private String createQuizSummary(int points) {
        String pointsMessage = "You've gained: " + points + " points";
        return pointsMessage;

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView pointsSummaryTextView = (TextView) findViewById(R.id.summary);
        pointsSummaryTextView.setText(message);
    }

}
