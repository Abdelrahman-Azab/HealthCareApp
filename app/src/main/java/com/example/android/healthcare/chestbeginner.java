package com.example.android.healthcare;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class chestbeginner extends AppCompatActivity {

    ImageView mmenubar1,mmenubar2,mmenubar3,mmenubar4,mmenubar5,mmenubar6,mmenubar7;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestbeginner);

        mmenubar1 = (ImageView) findViewById(R.id.menu_bar1);
        mmenubar2 = (ImageView) findViewById(R.id.menu_bar2);
        mmenubar3 = (ImageView) findViewById(R.id.menu_bar3);
        mmenubar4 = (ImageView) findViewById(R.id.menu_bar4);
        mmenubar5 = (ImageView) findViewById(R.id.menu_bar5);
        mmenubar6 = (ImageView) findViewById(R.id.menu_bar6);
        mmenubar7 = (ImageView) findViewById(R.id.menu_bar7);
        done=(Button) findViewById(R.id.done_button);
        mmenubar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog1();
            }
        });
        mmenubar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog2();
            }
        });
        mmenubar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog3();
            }
        });
        mmenubar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog4();
            }
        });
        mmenubar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog5();
            }
        });
        mmenubar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog6();
            }
        });
        mmenubar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog7();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialogbutton();
            }
        });
    }
    public void openDialog1()
    {
        InformationDialog informationDialog=new InformationDialog();
        informationDialog.show(getSupportFragmentManager(),"Information Dialog1");
    }
    public void openDialog2()
    {

        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information")
                .setMessage("Lying flat on the floor, make sure your lower back is pressed to the floor and is not arched" +
                        "Place your hands loosely behind or beside your head." +
                        "Bend your knees and place your feet flat on the floor." +
                        "Exhale while you curl your body forward off the floor making sure your shoulder blades come off the floor." +
                        "Hold for one second and then slowly return to starting position, inhaling while you return to the floor.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void opendialog3()
    {

        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information of Russian Twist")
                .setMessage("Start by sitting on the floor, with your knees bent and feet flat on the ground."
                        +"Then lean back so your upper body is at a 45-degree angle to the floor. "
                        +"Keep your back straight at this angle throughout the exercise, as it will be tempting to hunch your shoulders forward."
                        +"Link your hands together in front of your chest, then brace your core and raise your legs up off the ground.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void opendialog4()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information of Mountain Climber")
                .setMessage("Drop into a top press-up position, supporting your weight on your hands and toes, with your arms straight and your legs extended." +
                        "Keeping your core braced and your shoulders, hips and feet in a straight line throughout, bring one knee towards your chest, then return it to the starting position." +
                        "Repeat the movement with your other leg, then continue alternating legs throughout.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void opendialog5()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information of Leg Raises")
                .setMessage("Lie on a mat on the floor, face up, legs extended." +
                        " Place your hands underneath your lower back and glutes so your pelvis is supported." +
                        " Begin to raise your legs toward the ceiling, pressing your thighs together and keeping the legs straight. " +
                        "Lift until your hips are fully flexed and you can’t go any higher with straight legs, then lower back down and repeat.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void opendialog6()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information of Plank")
                .setMessage("Begin in the plank position, face down with your forearms and toes on the floor." +
                        " Your elbows are directly under your shoulders and your forearms are facing forward." +
                        " Your head is relaxed and you should be looking at the floor.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void opendialog7()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Information of Cobra Stretch")
                .setMessage("Begin lying face down on your mat with head slightly lifted and hand sitting directly under shoulders." +
                        "Point your toes so the tops of you feet are on the mat." +
                        " As you exhale, press arms straight and lift upper body and front of hips off the mat."+
                        "Keep your legs and feet relaxed and on the ground." +
                        "Keep your abdominals contracted and breathe slowly.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void opendialogbutton()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(chestbeginner.this);
        builder.setTitle("Congratulations")
                .setMessage("Whoooo,Nice Job!!!")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
