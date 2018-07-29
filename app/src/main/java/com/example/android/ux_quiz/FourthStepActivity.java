package com.example.android.ux_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FourthStepActivity extends AppCompatActivity {

    Button btn_action_exp1;
    int baseFeedback3;
    int baseFeedback4;
    boolean isTxteField41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

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
        baseFeedback3 = intent.getExtras().getInt("baseFeedback3");
        btn_action_exp1 = findViewById(R.id.items_feedback_next_btn1);

        btn_action_exp1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), FourthStepActivity.class);

                intent.putExtra("baseFeedback4", baseFeedback4);

                startActivity(intent);
            }
        });
    }

    public void surveyResults(View view) {
        EditText fieldTxte41 = findViewById(R.id.items_feedback_required_txte41);
        String txteField41 = fieldTxte41.getText().toString();
        if (txteField41.matches("")) {
            Toast.makeText(this, "You did not enter an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean addTxteFieldReqRes41 = compareStrings(txteField41, isTxteField41);
        baseFeedback4 = calculateShortSurvey(baseFeedback3, addTxteFieldReqRes41);
        String surveyMessage = createSurveyResults(baseFeedback4, addTxteFieldReqRes41);
        Toast.makeText(this, surveyMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param txteField41 is whether or Useful
     * @return isTxteField41
     */

    private boolean compareStrings(String txteField41, boolean isTxteField41) {
        if (txteField41.equalsIgnoreCase(getString(R.string.items_feedback_required_c_txte41))) {
            return isTxteField41;
        } else {
            return !isTxteField41;
        }
    }

    /**
     * @param addTxteFieldReqRes41 is whether or Useful
     * @param baseFeedback3        is short quiz result on the step three
     * @return baseFeedback4
     */

    private int calculateShortSurvey(int baseFeedback3, boolean addTxteFieldReqRes41) {
        int baseFeedback4 = baseFeedback3;

        if (addTxteFieldReqRes41)
            baseFeedback4 += 1;
        return baseFeedback4;
    }

    /**
     * @param addTxteFieldReqRes41 is whether or Useful
     * @return surveyResults
     */

    private String createSurveyResults(int baseFeedback4, boolean addTxteFieldReqRes41) {
        String surveyResults = getString(R.string.txt_feedback_other1) + "\n";

        surveyResults += getString(R.string.items_feedback_required4) + getString(R.string.txt_feedback_other4) + "\n";

        if (addTxteFieldReqRes41) {
            surveyResults = getString(R.string.items_feedback_required_c_txte41) + "\n";
        }
        surveyResults += "\n" + getString(R.string.txt_feedback_other2) + baseFeedback4 + getString(R.string.txt_feedback_other3) + getString(R.string.set_feedback_max_score1) + "\n";
        surveyResults += "\n" + getString(R.string.msg_feedback_confirmation);
        Toast.makeText(this, surveyResults, Toast.LENGTH_SHORT).show();
        return surveyResults;
    }
}
