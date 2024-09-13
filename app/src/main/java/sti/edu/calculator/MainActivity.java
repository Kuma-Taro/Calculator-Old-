package sti.edu.calculator;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView LiveText;
    TextView LiveRes;
    ToggleButton tog;
    String Live = "";
    Button eq,one,two,three,four,five,six,seven,eight,nine,zero,div,mul,add,sub,clr,dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tog = findViewById(R.id.Lever);
        eq = findViewById(R.id.res);
        one = findViewById(R.id.on);
        two = findViewById(R.id.tw);
        three = findViewById(R.id.thr);
        four = findViewById(R.id.fr);
        five = findViewById(R.id.fv);
        six = findViewById(R.id.zix);
        seven = findViewById(R.id.svn);
        eight = findViewById(R.id.egt);
        nine = findViewById(R.id.nen);
        zero = findViewById(R.id.zer);
        div = findViewById(R.id.dv);
        mul = findViewById(R.id.mul);
        add = findViewById(R.id.ad);
        sub = findViewById(R.id.zub);
        clr = findViewById(R.id.cr);
        dot = findViewById(R.id.dt);
        ContentTextViews();

        tog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    eq.setEnabled(false);
                    one.setEnabled(false);
                    two.setEnabled(false);
                    three.setEnabled(false);
                    five.setEnabled(false);
                    four.setEnabled(false);
                    six.setEnabled(false);
                    seven.setEnabled(false);
                    eight.setEnabled(false);
                    nine.setEnabled(false);
                    zero.setEnabled(false);
                    div.setEnabled(false);
                    mul.setEnabled(false);
                    add.setEnabled(false);
                    sub.setEnabled(false);
                    clr.setEnabled(false);
                    dot.setEnabled(false);

                } else {
                    eq.setEnabled(true);
                    one.setEnabled(true);
                    two.setEnabled(true);
                    three.setEnabled(true);
                    five.setEnabled(true);
                    four.setEnabled(true);
                    six.setEnabled(true);
                    seven.setEnabled(true);
                    eight.setEnabled(true);
                    nine.setEnabled(true);
                    zero.setEnabled(true);
                    div.setEnabled(true);
                    mul.setEnabled(true);
                    add.setEnabled(true);
                    sub.setEnabled(true);
                    clr.setEnabled(true);
                    dot.setEnabled(true);
                }
            }
        });
    }
    private void ContentTextViews() {
        LiveText = (TextView)findViewById(R.id.LiveNumbers);
        LiveRes = (TextView)findViewById(R.id.StaticResult);
    }
    private void setLiveText(String ContentValue) {
        Live = Live + ContentValue;
        LiveText.setText(Live);
    }
    public void Equals(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(Live);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(result != null)
            LiveRes.setText(String.valueOf(result.doubleValue()));
    }
    public void Clear(View view) {
        LiveText.setText("");
        Live = "";
        LiveRes.setText("");
    }

    public void Bracket(View view) {
    }

    public void On_and_Off(View view) {
    }

    public void slash(View view) {
        setLiveText("/");
    }

    public void Seven(View view) {
        setLiveText("7");
    }

    public void Eight(View view) {
        setLiveText("8");
    }

    public void Nine(View view) {
        setLiveText("9");
    }

    public void Multiplication(View view) {
        setLiveText("*");
    }

    public void Four(View view) {
        setLiveText("4");
    }

    public void Five(View view) {
        setLiveText("5");
    }

    public void Six(View view) {
        setLiveText("6");
    }

    public void Addition(View view) {
        setLiveText("+");
    }

    public void One(View view) {
        setLiveText("1");
    }

    public void Two(View view) {
        setLiveText("2");
    }

    public void Three(View view) {
        setLiveText("3");
    }

    public void Subtraction(View view) {
        setLiveText("-");
    }

    public void Decimal(View view) {
        setLiveText(".");
    }

    public void Zero(View view) {
        setLiveText("0");
    }
}
