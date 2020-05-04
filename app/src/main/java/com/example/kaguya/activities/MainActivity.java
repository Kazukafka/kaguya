package com.example.kaguya.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kaguya.R;
import com.example.kaguya.controller.CalculatorController;
import com.example.kaguya.defaultvalues.Operation;
import com.example.kaguya.storage.FirestoreController;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    FirestoreController firestore;
    CalculatorController calc;
    double input1 = 0, input2 = 0;
    TextView edt1, ans, ts;
    boolean addition, subtraction, multiplication, division, mRemainder, decimal, operationChosen;
    Operation operation;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSubtract,
            buttonMultiply, buttonDivision, buttonEqual, buttonDelete, buttonDot, remainder, sendButton, detaBaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView ans = findViewById(R.id.ans);
        final TextView ts = findViewById(R.id.ts);


        calc = new CalculatorController();
        firestore = new FirestoreController();

        button0 =  findViewById(R.id.button0);
        button1 =  findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        button4 =  findViewById(R.id.button4);
        button5 =  findViewById(R.id.button5);
        button6 =  findViewById(R.id.button6);
        button7 =  findViewById(R.id.button7);
        button8 =  findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonAdd = findViewById(R.id.buttonadd);
        buttonSubtract = findViewById(R.id.buttonsub);
        buttonMultiply = findViewById(R.id.buttonmul);
        buttonDivision = findViewById(R.id.buttondiv);
        remainder = findViewById(R.id.Remainder);
        buttonDelete = findViewById(R.id.buttonDel);
        buttonEqual = findViewById(R.id.buttoneql);

        edt1 = findViewById(R.id.edt1);

        setButtonListeners();
    }

    private void setNumberValue() {
        if(operationChosen) {
            input2 = Double.parseDouble(edt1.getText().toString());
            calc.setNumberSecond(input2);
        }
        else {
            input1 = Double.parseDouble(edt1.getText().toString());
            calc.setNumberFirst(input1);
        }
    }

    private void setButtonListeners() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
                setNumberValue();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
                setNumberValue();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
                setNumberValue();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
                setNumberValue();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
                setNumberValue();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
                setNumberValue();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
                setNumberValue();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
                setNumberValue();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
                setNumberValue();
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
                setNumberValue();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    calc.setNumberFirst(Float.parseFloat(edt1.getText().toString()));
                    calc.setOperation(Operation.ADDITION);
                    operationChosen = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    calc.setNumberFirst(Float.parseFloat(edt1.getText().toString()));
                    calc.setOperation(Operation.SUBTRACTION);
                    operationChosen = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    calc.setNumberFirst(Float.parseFloat(edt1.getText().toString()));
                    calc.setOperation(Operation.MULTIPLICATION);
                    operationChosen = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    calc.setNumberFirst(Float.parseFloat(edt1.getText().toString()));
                    calc.setOperation(Operation.DIVISION);
                    operationChosen = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    mRemainder = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                try {
                    calc.calculate();
                } catch (Exception e) {
                    ans.setText("Cannot divide by zero");
                }
                ans.setText(calc.printEquation());

                /*if (mRemainder) {
                    edt1.setText(Math.pow(input1, input2) + "");
                    mRemainder = false;
                    ans.setText((input1 + " ^ " + input2 ) + " = " + (Math.pow(input1, input2)) + "");
                    //long millis = System.currentTimeMillis();
                    //ts.setText(Long.toString(millis));


                    String finalCalc = (String) ans.getText().toString();

                    firestore.saveToFirebase(finalCalc);
                }*/
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                input1 = 0.0;
                input2 = 0.0;
                ans.setText("");
                ts.setText("");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {

                } else {
                    edt1.setText(edt1.getText() + ".");
                    decimal = true;
                }

            }
        });

    }
}