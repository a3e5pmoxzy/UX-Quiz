package com.example.android.ux_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FifthStepActivity extends AppCompatActivity {

    Button btn_action_exp1;
    int baseFeedback4;
    int baseFeedback5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

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
        baseFeedback4 = intent.getExtras().getInt("baseFeedback4");
        btn_action_exp1 = findViewById(R.id.items_feedback_back_btn1);

        btn_action_exp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void surveyResults(View view) {
        EditText nameField = findViewById(R.id.feedback_field);
        String name = nameField.getText().toString();
        RadioButton itemsFeedbackReqRes51 = findViewById(R.id.items_feedback_required_res51);
        RadioButton itemsFeedbackReqRes52 = findViewById(R.id.items_feedback_required_res52);
        boolean isItemsFeedbackReqRes51 = itemsFeedbackReqRes51.isChecked();
        boolean isItemsFeedbackReqRes52 = itemsFeedbackReqRes52.isChecked();

        baseFeedback5 = calculateShortSurvey(baseFeedback4, isItemsFeedbackReqRes51, isItemsFeedbackReqRes52);
        String surveyMessage = createSurveyResults(baseFeedback5, name, isItemsFeedbackReqRes51, isItemsFeedbackReqRes52);
        Toast.makeText(this, surveyMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param addItemsFeedbackReqRes51 is whether or not Left half of the page
     * @param addItemsFeedbackReqRes52 is whether or not Right half of the page
     * @return baseFeedback4
     */

    private int calculateShortSurvey(int baseFeedback4, boolean addItemsFeedbackReqRes51, boolean addItemsFeedbackReqRes52) {
        int baseFeedback5 = baseFeedback4;

        if (addItemsFeedbackReqRes51 && !addItemsFeedbackReqRes52) {
            baseFeedback5 += 1;
        } else if (!addItemsFeedbackReqRes51 && addItemsFeedbackReqRes52) {
            baseFeedback5 += 0;
        }
        return baseFeedback5;
    }

    /**
     * @param name                     of the school member
     * @param addItemsFeedbackReqRes51 is whether or not Left half of the page
     * @param addItemsFeedbackReqRes52 is whether or not Right half of the page
     * @param baseFeedback5            is UX-Quiz result on the step five
     * @return surveyResults
     */

    private String createSurveyResults(int baseFeedback5, String name, boolean addItemsFeedbackReqRes51, boolean addItemsFeedbackReqRes52) {
        String surveyResults = getString(R.string.txt_feedback_other1) + "\n";

        surveyResults += getString(R.string.items_feedback_required5) + "\n";

        if (addItemsFeedbackReqRes51 && !addItemsFeedbackReqRes52) {
            surveyResults += getString(R.string.items_feedback_required_rd51) + "\n";
        } else if (!addItemsFeedbackReqRes51 && addItemsFeedbackReqRes52) {
            surveyResults += getString(R.string.items_feedback_required_rd52) + "\n";
        }
        surveyResults += "\n" + getString(R.string.any_other_feedback) + ": " + "\n";
        surveyResults += name + "\n";
        surveyResults += "\n" + getString(R.string.txt_feedback_other2) + baseFeedback5 + getString(R.string.txt_feedback_other3) + getString(R.string.set_feedback_max_score1) + "\n";
        surveyResults += "\n" + getString(R.string.msg_feedback_final_confirmation);
        Toast.makeText(this, surveyResults, Toast.LENGTH_SHORT).show();
        return surveyResults;
    }
}
