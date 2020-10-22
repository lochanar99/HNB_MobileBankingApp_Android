package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    TextView titlerate,resultrate;
    Button btnfeedback;
    ImageView charPlace,icSprite;
    RatingBar rateStars;
    String answerValue;
    Dialog myDialog ;

    Animation charanim,anisprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        myDialog = new Dialog(this);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);

        btnfeedback = (Button) findViewById(R.id.btnfeedback);

        charPlace = findViewById(R.id.charPlace);
        icSprite = findViewById(R.id.icSprite);

        rateStars = findViewById(R.id.rateStars);

        charanim = AnimationUtils.loadAnimation(this,R.anim.charanim);
        anisprite = AnimationUtils.loadAnimation(this,R.anim.anisprite);

        charPlace.startAnimation(charanim);
        icSprite.startAnimation(anisprite);

        // give condition
        rateStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                answerValue = String.valueOf((int) (rateStars.getRating()));

                if(answerValue.equals("1")){
                    charPlace.setImageResource(R.drawable.iconestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Poor");
                }
                else if(answerValue.equals("2")){
                    charPlace.setImageResource(R.drawable.iconestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Better");
                }
                else if(answerValue.equals("3")){
                    charPlace.setImageResource(R.drawable.icthreestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Good");
                }
                else if(answerValue.equals("4")){
                    charPlace.setImageResource(R.drawable.icthreestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(anisprite);

                    resultrate.setText("Superb");
                }
                else if(answerValue.equals("5")){
                    charPlace.setImageResource(R.drawable.icfivestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(anisprite);

                    resultrate.setText("Excellent");
                }
                else {
                   Toast.makeText(RatingActivity.this, "No point", Toast.LENGTH_SHORT).show();


                }




            }
        });


        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // Toast.makeText(RatingActivity.this, "Thank you for rated us!", Toast.LENGTH_LONG).show();

               // Intent intent = new Intent(RatingActivity.this,dashboard.class);
                //startActivity(intent);

                Button closeBttn ;
                Button yesBttn;
                TextView textMsg ;

                myDialog.setContentView(R.layout.activity_popup_message_request_book);
                closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
                yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);
                textMsg = (TextView) myDialog.findViewById(R.id.textView19);

                textMsg.setText("Please Confirm your feedback ?");

                closeBttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });

                yesBttn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();

                        //Toast.makeText(getContext(), "Successfully added", Toast.LENGTH_LONG).show();

                        nextPopUp();


                    }
                });
                myDialog.show();
            }
        });

    }

    public void nextPopUp()  {

        try {
            myDialog.setContentView(R.layout.activity_rate_add_popup);
            myDialog.show();
        }catch (Exception e){

        }


    }
}
