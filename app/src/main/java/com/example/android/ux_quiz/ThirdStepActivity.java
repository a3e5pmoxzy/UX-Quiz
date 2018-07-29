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

public class ThirdStepActivity extends AppCompatActivity {

    Button btn_action_exp1;
    int baseFeedback2;
    int baseFeedback3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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
        baseFeedback2 = intent.getExtras().getInt("baseFeedback2");
        btn_action_exp1 = findViewById(R.id.items_feedback_next_btn1);

        btn_action_exp1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), FourthStepActivity.class);

                intent.putExtra("baseFeedback3", baseFeedback3);

                startActivity(intent);
            }
        });
    }

    public void surveyResults(View view) {
        CheckBox itemsFeedbackReqRes31 = findViewById(R.id.items_feedback_required_res31);
        CheckBox itemsFeedbackReqRes32 = findViewById(R.id.items_feedback_required_res32);
        CheckBox itemsFeedbackReqRes33 = findViewById(R.id.items_feedback_required_res33);
        CheckBox itemsFeedbackReqRes34 = findViewById(R.id.items_feedback_required_res34);
        boolean isItemsFeedbackReqRes31 = itemsFeedbackReqRes31.isChecked();
        boolean isItemsFeedbackReqRes32 = itemsFeedbackReqRes32.isChecked();
        boolean isItemsFeedbackReqRes33 = itemsFeedbackReqRes33.isChecked();
        boolean isItemsFeedbackReqRes34 = itemsFeedbackReqRes34.isChecked();

        baseFeedback3 = calculateShortSurvey(baseFeedback2, isItemsFeedbackReqRes31, isItemsFeedbackReqRes32, isItemsFeedbackReqRes33, isItemsFeedbackReqRes34);
        String surveyMessage = createSurveyResults(baseFeedback3, isItemsFeedbackReqRes31, isItemsFeedbackReqRes32, isItemsFeedbackReqRes33, isItemsFeedbackReqRes34);
        Toast.makeText(this, surveyMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param addItemsFeedbackReqRes31 is whether or not Page title
     * @param addItemsFeedbackReqRes32 is whether or not Headline
     * @param addItemsFeedbackReqRes33 is whether or not Tagline
     * @param addItemsFeedbackReqRes34 is whether or not Email body
     * @param baseFeedback2            is UX-Quiz result on the step one
     * @return baseFeedback3
     */

    private int calculateShortSurvey(int baseFeedback2, boolean addItemsFeedbackReqRes31, boolean addItemsFeedbackReqRes32, boolean addItemsFeedbackReqRes33, boolean addItemsFeedbackReqRes34) {
        int baseFeedback3 = baseFeedback2;

        if (addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            baseFeedback3 += 0;
        }
        if (!addItemsFeedbackReqRes31 && addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            baseFeedback3 += 0;
        }
        if (!addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            baseFeedback3 += 0;
        }
        if (!addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && addItemsFeedbackReqRes34){
            baseFeedback3 += 1;
        }
        return baseFeedback3;
    }

    /**
     * @param addItemsFeedbackReqRes31 is whether or not Page title
     * @param addItemsFeedbackReqRes32 is whether or not Headline
     * @param addItemsFeedbackReqRes33 is whether or not Tagline
     * @param addItemsFeedbackReqRes34 is whether or not Email body
     * @return surveyResults
     */

    private String createSurveyResults(int baseFeedback3, boolean addItemsFeedbackReqRes31, boolean addItemsFeedbackReqRes32, boolean addItemsFeedbackReqRes33, boolean addItemsFeedbackReqRes34) {
        String surveyResults = getString(R.string.txt_feedback_other1) + "\n";

        surveyResults += getString(R.string.items_feedback_required3) + getString(R.string.txt_feedback_other3) + "\n";

        if (addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            surveyResults = getString(R.string.items_feedback_required_ch31) + "\n";
        }
        if (!addItemsFeedbackReqRes31 && addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            surveyResults += getString(R.string.items_feedback_required_ch32) + "\n";
        }
        if (!addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && addItemsFeedbackReqRes33 && !addItemsFeedbackReqRes34){
            surveyResults += getString(R.string.items_feedback_required_ch33) + "\n";
        }
        if (!addItemsFeedbackReqRes31 && !addItemsFeedbackReqRes32 && !addItemsFeedbackReqRes33 && addItemsFeedbackReqRes34){
            surveyResults += getString(R.string.items_feedback_required_ch34) + "\n";
        }
        surveyResults += "\n" + getString(R.string.txt_feedback_other2) + baseFeedback2 + getString(R.string.txt_feedback_other3) + getString(R.string.set_feedback_max_score1) + "\n";
        surveyResults += "\n" + getString(R.string.msg_feedback_confirmation);
        Toast.makeText(this, surveyResults, Toast.LENGTH_SHORT).show();
        return surveyResults;
    }
}
