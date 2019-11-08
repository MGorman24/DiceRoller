package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    int UserNumber = -1;
    int UserScore = 0;

    EditText UserNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        UserNumberInput = (EditText) findViewById(R.id.UserNumberInput);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView Input = this.findViewById(R.id.UserNumberInput);
        TextView Dicebreakers = this.findViewById(R.id.Dicebreaker);
        TextView Congrats = this.findViewById(R.id.Congratulations);
        TextView Score = this.findViewById(R.id.Score);
        Random r = new Random();
        int Number = roll_the_dice();
        tv.setText(Integer.toString(Number));
        Score.setText("Score: " + UserScore);
        UserNumber = Integer.parseInt(Input.getText().toString());

        Dicebreakers.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.VISIBLE);
        Congrats.setVisibility(View.VISIBLE);

        if (UserNumber == Number) {
            UserScore = UserScore + 1;
            Score.setText("Score: " + UserScore);
            Congrats.setText("Well done!");
        } else if (UserNumber < 1) {
            tv.setText(" ");
            Congrats.setText("Please enter a valid number!");
        } else if (UserNumber > 6) {
            tv.setText(" ");
            Congrats.setText("Please enter a valid number!");
        } else if (UserNumber < 1 || UserNumber > 6) {
            tv.setText(" ");
            Congrats.setText("Please enter a value between 1 and 6!");
        } else {
            Congrats.setText("Try again!");
        }
        Input.setText("");
    }

    public void on_button2_click(View view) {
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView Dicebreakers = this.findViewById(R.id.Dicebreaker);
        TextView Congrats = this.findViewById(R.id.Congratulations);
        TextView Score = this.findViewById(R.id.Score);
        int Number = roll_the_dice();

        Dicebreakers.setVisibility(View.VISIBLE);
        tv.setVisibility(View.INVISIBLE);
        Congrats.setVisibility(View.INVISIBLE);

        if (Number == 1) {
            Dicebreakers.setText("If you could go anywhere in the world, where would you go?");
        } else if (Number == 2) {
            Dicebreakers.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        } else if (Number == 3) {
            Dicebreakers.setText("If you could eat only one food for the rest of your life, what would that be?");
        } else if (Number == 4) {
            Dicebreakers.setText("If you won a million dollars, what is the first thing you would buy?");
        } else if (Number == 5) {
            Dicebreakers.setText("If you could spend the day with one fictional character, who would it be?");
        } else if (Number == 6) {
            Dicebreakers.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }
    }

    public int roll_the_dice()
    {
        Random r = new Random();
        int number = r.nextInt(6) + 1;

        return number;
    }
}
