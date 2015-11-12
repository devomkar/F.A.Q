package com.ironoid.fdsquiz;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.Menu;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.RatingBar;
        import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnres;  //restart button


        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView o=(TextView)findViewById(R.id.textResult);
        TextView t=(TextView)findViewById(R.id.textView);
        //get score
        Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce_anim);
        final Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        Animation zoomout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
        bar.startAnimation(bounce);
        o.startAnimation(rotate);
        t.startAnimation(rotate);

        Bundle b = getIntent().getExtras();
      final int score= b.getInt("score");
        final int qid=b.getInt("qid");
        //display score

        o.setText("Your Score is " + score + " out of " + qid );



        switch (score)
        {case 0:t.setText("Need Improvement...");break;
            case 1:case 2:case 3: case 4:case 5: case 6:
            case 7:case 8:case 9:case 10:
            t.setText("Oopsie! Better Luck Next Time!");
            bar.setRating(1);
            ;break;
            case 11:case 12:case 13:case 14:case 15:
            case 16:case 17:case 18:case 19:case 20:
            t.setText("You Can Do Better.....");
            bar.setRating(2);
            break;

            case 21:case 22:case 23:case 24:case 25:
            case 26:case 27:case 28:case 29:
            t.setText("Good but need improvement");
            bar.setRating(3);
            break;

            case 30:case 31:case 32:case 33:case 34:
            case 35:case 36:case 37:case 38:case 39:
            t.setText("Good job....");
            bar.setRating(4);
            break;

            case 40:case 41:case 42:case 43:case 45:
            case 44:case 46:case 47:case 48:case 50:
            t.setText("Excellent...!!!");

            bar.setRating(5);
            break;
        }

        btnres=(Button)findViewById(R.id.btnres); //id to restart btn
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();


            }
        });
        Button btnhome=(Button)findViewById(R.id.btnhome); //id to restart btn
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(home);
                finish();


            }
        });

       final Button sharebtn=(Button)findViewById(R.id.sharebtn); //id to restart btn
        sharebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){sharebtn.startAnimation(rotate);

                String shareBody = "Hey , I just Scored "+ score +" out of "+ qid +" in this wonderfull app F.A.Q.\nYou can Revise Your MCQ's and " +
                        "Frequently Asked Questions asked in Online Exam and Viva Using your Phone.\nJust Download the App From Here www.FAQ.com";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "FAQ App:");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }

}

