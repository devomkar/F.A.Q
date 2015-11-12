package com.ironoid.fdsquiz;

import java.util.List;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DeldActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    int totalq=6;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deld);



        deldhelper db=new deldhelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                final RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

                Log.d("youRans", currentQ.getANSWER() + " " + answer.getText());


                if (currentQ.getANSWER().equals(answer.getText())) {
                    Toast.makeText(DeldActivity.this, "Awesome Right Answer.;-)", Toast.LENGTH_SHORT).show();
                    score++;
                    Log.d("score", "Your score" + score);
                } else {
                    Toast.makeText(DeldActivity.this, "Wrong Answer.The Right Answer is " + currentQ.getANSWER(), Toast.LENGTH_SHORT).show();
                }


                if (qid < totalq) {

                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(DeldActivity.this, DeldResultActivity.class);
                    Bundle b = new Bundle();
                    Bundle total = new Bundle();
                    b.putInt("score", score); //Your score
                    b.putInt("qid", qid);
                    intent.putExtras(b);
                    intent.putExtras(total);//Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.action_settings:

                Intent i = new Intent(DeldActivity.this , SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.exit:
                AlertDialog.Builder close = new AlertDialog.Builder(this);

                close.setTitle("Really Exit ?");
                close.setMessage("Do you really want to exit the app and stop STUDING ??");
                close.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {finish();
                            }
                        });;
                close.setNegativeButton("No",new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });;
                AlertDialog alertDialog = close.create();
                alertDialog.show();
                break;
            case R.id.restart:
                finish();
                Intent restart = new Intent(DeldActivity.this , DeldActivity.class);
                startActivity(restart);
                break;
            case R.id.home:
                finish();
                Intent home = new Intent(DeldActivity.this , MainActivity.class);
                startActivity(home);
                break;
            case R.id.share:
                String shareBody = "Hey , have a look at this wonderfull app F.A.Q.\nYou can Revise Your MCQ's and " +
                        "Frequently Asked Questions asked in Online Exam and Viva Using your Phone.\nJust Download the App From Here www.FAQ.com";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "FAQ App:");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
                break;
        }
        return true;

    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder submit =new AlertDialog.Builder(this);
        submit.setTitle("Submit or Exit");
        submit.setMessage("Do Want to Submit , Exit or Continue F.A.Q Test");
        submit.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DeldActivity.this, DeldResultActivity.class);
                Bundle b = new Bundle();
                Bundle total = new Bundle();
                b.putInt("score", score); //Your score
                b.putInt("qid", qid);
                intent.putExtras(b);
                intent.putExtras(total);//Put your score to your next Intent
                startActivity(intent);
                finish();

            }
        });
        submit.setNegativeButton("Continue Test", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        submit.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent back = new Intent(DeldActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
        submit.create();
        submit.show();




    }



}