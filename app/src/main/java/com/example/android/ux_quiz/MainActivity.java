package com.example.android.ux_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_action_exp1;
    int baseFeedback1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.txt_tbl_header_name);
        name.setText("John");
        name.setTextSize(14);
        name.setTextColor(Color.BLACK);
        TextView birthday = findViewById(R.id.txt_tbl_header_birthday);
        birthday.setText("06/19/1969");
        name.setTextSize(14);
        name.setTextColor(Color.BLUE);
        TextView country = findViewById(R.id.txt_tbl_header_country);
        country.setText("Slovenia");
        name.setTextSize(14);
        name.setTextColor(Color.RED);
        btn_action_exp1 = findViewById(R.id.items_feedback_next_btn1);

        btn_action_exp1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), SecondStepActivity.class);

                intent.putExtra("baseFeedback1", baseFeedback1);

                startActivity(intent);
            }
        });
    }

    public void surveyResults(View view) {
        CheckBox itemsFeedbackReqRes11 = findViewById(R.id.items_feedback_required_res11);
        CheckBox itemsFeedbackReqRes12 = findViewById(R.id.items_feedback_required_res12);
        CheckBox itemsFeedbackReqRes13 = findViewById(R.id.items_feedback_required_res13);
        CheckBox itemsFeedbackReqRes14 = findViewById(R.id.items_feedback_required_res14);
        CheckBox itemsFeedbackReqRes15 = findViewById(R.id.items_feedback_required_res15);
        boolean isItemsFeedbackReqRes11 = itemsFeedbackReqRes11.isChecked();
        boolean isItemsFeedbackReqRes12 = itemsFeedbackReqRes12.isChecked();
        boolean isItemsFeedbackReqRes13 = itemsFeedbackReqRes13.isChecked();
        boolean isItemsFeedbackReqRes14 = itemsFeedbackReqRes14.isChecked();
        boolean isItemsFeedbackReqRes15 = itemsFeedbackReqRes15.isChecked();

        baseFeedback1 = calculateShortSurvey(isItemsFeedbackReqRes11, isItemsFeedbackReqRes12, isItemsFeedbackReqRes13, isItemsFeedbackReqRes14, isItemsFeedbackReqRes15);
        String surveyMessage = createSurveyResults(baseFeedback1, isItemsFeedbackReqRes11, isItemsFeedbackReqRes12, isItemsFeedbackReqRes13, isItemsFeedbackReqRes14, isItemsFeedbackReqRes15);
        Toast.makeText(this, surveyMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param addItemsFeedbackReqRes11 is whether or not People tend to perceive usable products as more attractive.
     * @param addItemsFeedbackReqRes12 is whether or not People tend to perceive attractive products as more usable.
     * @param addItemsFeedbackReqRes13 is whether or not Usability and aesthetics are equally important in web design.
     * @param addItemsFeedbackReqRes14 is whether or not The perception of attractiveness and usability of a new site are evaluated in the first 50ms when a user first sees the site.
     * @param addItemsFeedbackReqRes15 is whether or not As much as possible to impress users
     * @return baseFeedback1
     */

    private int calculateShortSurvey(boolean addItemsFeedbackReqRes11, boolean addItemsFeedbackReqRes12, boolean addItemsFeedbackReqRes13, boolean addItemsFeedbackReqRes14, boolean addItemsFeedbackReqRes15) {
        int baseFeedback1 = 0;

        if (addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            baseFeedback1 += 1;
        }
        if (!addItemsFeedbackReqRes11 && addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            baseFeedback1 += 0;
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            baseFeedback1 += 0;
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            baseFeedback1 += 0;
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && addItemsFeedbackReqRes15){
            baseFeedback1 += 0;
        }
        return baseFeedback1;
    }

    /**
     * @param addItemsFeedbackReqRes11 is whether or not People tend to perceive usable products as more attractive.
     * @param addItemsFeedbackReqRes12 is whether or not People tend to perceive attractive products as more usable.
     * @param addItemsFeedbackReqRes13 is whether or not Usability and aesthetics are equally important in web design.
     * @param addItemsFeedbackReqRes14 is whether or not The perception of attractiveness and usability of a new site are evaluated in the first 50ms when a user first sees the site.
     * @param addItemsFeedbackReqRes15 is whether or not As much as possible to impress users
     * @param baseFeedback1            UX-Quiz results: step1
     * @return surveyResults
     */

    private String createSurveyResults(int baseFeedback1, boolean addItemsFeedbackReqRes11, boolean addItemsFeedbackReqRes12, boolean addItemsFeedbackReqRes13, boolean addItemsFeedbackReqRes14, boolean addItemsFeedbackReqRes15) {
        String surveyResults = getString(R.string.txt_feedback_other1) + "\n";

        surveyResults += getString(R.string.items_feedback_required1) + getString(R.string.txt_feedback_other4) + "\n";

        if (addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            surveyResults = getString(R.string.items_feedback_required_ch11) + "\n";
        }
        if (!addItemsFeedbackReqRes11 && addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            surveyResults += getString(R.string.items_feedback_required_ch12) + "\n";
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            surveyResults += getString(R.string.items_feedback_required_ch13) + "\n";
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && addItemsFeedbackReqRes14 && !addItemsFeedbackReqRes15){
            surveyResults += getString(R.string.items_feedback_required_ch14) + "\n";
        }
        if (!addItemsFeedbackReqRes11 && !addItemsFeedbackReqRes12 && !addItemsFeedbackReqRes13 && !addItemsFeedbackReqRes14 && addItemsFeedbackReqRes15){
            surveyResults += getString(R.string.items_feedback_required_ch15) + "\n";
        }
        surveyResults += "\n" + getString(R.string.txt_feedback_other2) + baseFeedback1 + getString(R.string.txt_feedback_other3) + getString(R.string.set_feedback_max_score1) + "\n";
        surveyResults += "\n" + getString(R.string.msg_feedback_confirmation);
        Toast.makeText(this, surveyResults, Toast.LENGTH_SHORT).show();
        return surveyResults;
    }
}
