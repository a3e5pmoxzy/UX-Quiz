package com.example.android.ux_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SecondStepActivity extends AppCompatActivity {

    Button btn_action_exp1;
    int baseFeedback1;
    int baseFeedback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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

        Intent intent = getIntent();
        baseFeedback1 = intent.getExtras().getInt("baseFeedback1");
        btn_action_exp1 = findViewById(R.id.items_feedback_next_btn1);

        btn_action_exp1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ThirdStepActivity.class);

                intent.putExtra("baseFeedback2", baseFeedback2);

                startActivity(intent);
            }
        });
    }

    public void surveyResults(View view) {
        CheckBox itemsFeedbackReqRes21 = findViewById(R.id.items_feedback_required_res21);
        CheckBox itemsFeedbackReqRes22 = findViewById(R.id.items_feedback_required_res22);
        CheckBox itemsFeedbackReqRes23 = findViewById(R.id.items_feedback_required_res23);
        CheckBox itemsFeedbackReqRes24 = findViewById(R.id.items_feedback_required_res24);
        boolean isItemsFeedbackReqRes21 = itemsFeedbackReqRes21.isChecked();
        boolean isItemsFeedbackReqRes22 = itemsFeedbackReqRes22.isChecked();
        boolean isItemsFeedbackReqRes23 = itemsFeedbackReqRes23.isChecked();
        boolean isItemsFeedbackReqRes24 = itemsFeedbackReqRes24.isChecked();

        baseFeedback2 = calculateShortSurvey(baseFeedback1, isItemsFeedbackReqRes21, isItemsFeedbackReqRes22, isItemsFeedbackReqRes23, isItemsFeedbackReqRes24);
        String surveyMessage = createSurveyResults(baseFeedback2, isItemsFeedbackReqRes21, isItemsFeedbackReqRes22, isItemsFeedbackReqRes23, isItemsFeedbackReqRes24);
        Toast.makeText(this, surveyMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param addItemsFeedbackReqRes21 is whether or not Page title
     * @param addItemsFeedbackReqRes22 is whether or not Headline
     * @param addItemsFeedbackReqRes23 is whether or not Tagline
     * @param addItemsFeedbackReqRes24 is whether or not Email body
     * @param baseFeedback1            is UX-Quiz result on the step one
     * @return baseFeedback2
     */

    private int calculateShortSurvey(int baseFeedback1, boolean addItemsFeedbackReqRes21, boolean addItemsFeedbackReqRes22, boolean addItemsFeedbackReqRes23, boolean addItemsFeedbackReqRes24) {
        int baseFeedback2 = baseFeedback1;

        if (addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            baseFeedback2 += 0;
        }
        if (!addItemsFeedbackReqRes21 && addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            baseFeedback2 += 0;
        }
        if (!addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            baseFeedback2 += 0;
        }
        if (!addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && addItemsFeedbackReqRes24){
            baseFeedback2 += 1;
        }
        return baseFeedback2;
    }

    /**
     * @param addItemsFeedbackReqRes21 is whether or not Page title
     * @param addItemsFeedbackReqRes22 is whether or not Headline
     * @param addItemsFeedbackReqRes23 is whether or not Tagline
     * @param addItemsFeedbackReqRes24 is whether or not Email body
     * @return surveyResults
     */

    private String createSurveyResults(int baseFeedback2, boolean addItemsFeedbackReqRes21, boolean addItemsFeedbackReqRes22, boolean addItemsFeedbackReqRes23, boolean addItemsFeedbackReqRes24) {
        String surveyResults = getString(R.string.txt_feedback_other1) + "\n";

        surveyResults += getString(R.string.items_feedback_required2) + getString(R.string.txt_feedback_other4) + "\n";

        if (addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            surveyResults = getString(R.string.items_feedback_required_ch21) + "\n";
        }
        if (!addItemsFeedbackReqRes21 && addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            surveyResults += getString(R.string.items_feedback_required_ch22) + "\n";
        }
        if (!addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && addItemsFeedbackReqRes23 && !addItemsFeedbackReqRes24){
            surveyResults += getString(R.string.items_feedback_required_ch23) + "\n";
        }
        if (!addItemsFeedbackReqRes21 && !addItemsFeedbackReqRes22 && !addItemsFeedbackReqRes23 && addItemsFeedbackReqRes24){
            surveyResults += getString(R.string.items_feedback_required_ch24) + "\n";
        }
        surveyResults += "\n" + getString(R.string.txt_feedback_other2) + baseFeedback2 + getString(R.string.txt_feedback_other3) + getString(R.string.set_feedback_max_score1) + "\n";
        surveyResults += "\n" + getString(R.string.msg_feedback_confirmation);
        Toast.makeText(this, surveyResults, Toast.LENGTH_SHORT).show();
        return surveyResults;
    }
}
