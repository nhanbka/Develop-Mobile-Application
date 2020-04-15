package vn.edu.hust.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtDisplay;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnMinus;
    private Button btnAdd;
    private Button btnClearUnitElement;
    private Button btnClearElement;
    private Button btnClear;
    private Button Zero;
    private Button One;
    private Button Two;
    private Button Three;
    private Button Four;
    private Button Five;
    private Button Six;
    private Button Seven;
    private Button Eight;
    private Button Nine;
    private Button Dot;
    private Button opposite;
    private Button equal;

    private int first_temp;
    private int second_temp;
    private int next;
    private int operator;       // 1 = add, 2 = minus, 3 = multiply, 4 = divide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = (TextView) findViewById (R.id.txtDisplay);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearElement = (Button) findViewById(R.id.btnClearElement);
        btnClearUnitElement = (Button) findViewById(R.id.btnClearUnitNumber);
        Dot = (Button) findViewById(R.id.btnDot);
        Zero = (Button) findViewById(R.id.btnNo0);
        One = (Button) findViewById(R.id.btnNo1);
        Two = (Button) findViewById(R.id.btnNo2);
        Three = (Button) findViewById(R.id.btnNo3);
        Four = (Button) findViewById(R.id.btnNo4);
        Five = (Button) findViewById(R.id.btnNo5);
        Six = (Button) findViewById(R.id.btnNo6);
        Seven = (Button) findViewById(R.id.btnNo7);
        Eight = (Button) findViewById(R.id.btnNo8);
        Nine = (Button) findViewById(R.id.btnNo9);
        opposite = (Button) findViewById(R.id.btnOpposite);
        equal = (Button) findViewById(R.id.btnEqual);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGI.TTF");
        txtDisplay.setTypeface(typeface);
        One.setOnClickListener(this);
        Two.setOnClickListener(this);
        Three.setOnClickListener(this);
        Four.setOnClickListener(this);
        Five.setOnClickListener(this);
        Six.setOnClickListener(this);
        Seven.setOnClickListener(this);
        Eight.setOnClickListener(this);
        Nine.setOnClickListener(this);
        Zero.setOnClickListener(this);
        Dot.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        opposite.setOnClickListener(this);
        btnClearUnitElement.setOnClickListener(this);
        btnClearElement.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        equal.setOnClickListener(this);

        operator = 0;
        next = 1;
    }

    @Override
    public void onClick(View v){
        // clear
        if(v.getId() == R.id.btnClear){
            next = 1;
            txtDisplay.setText("0");
            operator = 0;
            first_temp = 0;
        }
        if(v.getId() == R.id.btnClearElement){
            next = 0;
            txtDisplay.setText("0");
        }
        if(v.getId() == R.id.btnClearUnitNumber){
            next = 0;
            String x = txtDisplay.getText().toString();
            if(x.length() == 1)
                txtDisplay.setText("0");
            else {
                x = x.substring(0, x.length() - 1);
                txtDisplay.setText(x);
            }
        }

        // input number
        if(v.getId() == R.id.btnNo0){
            if(txtDisplay.getText().length() == 7 || txtDisplay.getText().equals("0"));
            else if(next == 1)
                txtDisplay.setText("0");
            else {
                txtDisplay.append("0");
                next = 0;
            }
        }
        if(v.getId() == R.id.btnNo1){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("1");
            } else txtDisplay.append("1");
            next = 0;
        }
        if(v.getId() == R.id.btnNo2){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("2");
            } else txtDisplay.append("2");
            next = 0;
        }
        if(v.getId() == R.id.btnNo3){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("3");
            } else txtDisplay.append("3");
            next = 0;
        }
        if(v.getId() == R.id.btnNo4){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("4");
            } else txtDisplay.append("4");
            next = 0;
        }
        if(v.getId() == R.id.btnNo5){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("5");
            } else txtDisplay.append("5");
            next = 0;
        }
        if(v.getId() == R.id.btnNo6){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("6");
            } else txtDisplay.append("6");
            next = 0;
        }
        if(v.getId() == R.id.btnNo7){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("7");
            } else txtDisplay.append("7");
            next = 0;
        }
        if(v.getId() == R.id.btnNo8){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("8");
            } else txtDisplay.append("8");
            next = 0;
        }
        if(v.getId() == R.id.btnNo9){
            if(txtDisplay.getText().length() == 7);
            else if(txtDisplay.getText().equals("0") || next == 1){
                txtDisplay.setText("9");
            } else txtDisplay.append("9");
            next = 0;
        }

        // handle operator
        if(v.getId() == R.id.btnAdd){
            if(next == 0)
                equal.callOnClick();
            next = 1;
            operator = 1;
            first_temp = Integer.parseInt(txtDisplay.getText().toString());
        }
        if(v.getId() == R.id.btnMinus){
            if(next == 0)
                equal.callOnClick();
            next = 1;
            operator = 2;
            first_temp = Integer.parseInt(txtDisplay.getText().toString());
        }
        if(v.getId() == R.id.btnMultiply){
            if(next == 0)
                equal.callOnClick();
            next = 1;
            operator = 3;
            first_temp = Integer.parseInt(txtDisplay.getText().toString());
        }
        if(v.getId() == R.id.btnDivide){
            if(next == 0)
                equal.callOnClick();
            next = 1;
            operator = 4;
            first_temp = Integer.parseInt(txtDisplay.getText().toString());
        }

        if(v.getId() == R.id.btnEqual){
            if(operator == 0);
            else {
                next = 1;
                second_temp = Integer.parseInt(txtDisplay.getText().toString());
                int result = 0, error = 0;
                if(operator == 1){
                    result = first_temp + second_temp;
                } else if(operator == 2){
                    result = first_temp - second_temp;
                } else if(operator == 3){
                    result = first_temp * second_temp;
                } else if(operator == 4){
                    try {
                        result = first_temp / second_temp;
                    } catch(ArithmeticException a){
                        txtDisplay.setText("Math Err");
                        error = 1;
                    }
                }
                if(error == 0)
                    txtDisplay.setText(Integer.toString(result));
                else {
                    btnClear.callOnClick();
                }
                operator = 0;
            }
        }

        if(v.getId() == R.id.btnOpposite){
            String temp = txtDisplay.getText().toString();
            if(temp.charAt(0) == '-'){
                temp = temp.substring(1);
            } else if(temp.equals("0"));
            else {
                temp = "-" + temp;
            }
            txtDisplay.setText(temp);
        }

        if(v.getId() == R.id.btnDot){
            if(txtDisplay.getText().length() == 9);
            else txtDisplay.append(".");
        }
    }
}
