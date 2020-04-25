package com.example.kaguya;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


public class MainActivity<FirebaseDatabase> extends AppCompatActivity {

    FirebaseDatabase database;

    double input1 = 0, input2 = 0;
    TextView edt1, ans, ts;
    boolean Addition, Subtract, Multiplication, Division, mRemainder, decimal;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel, buttonDot, Remainder, sendButton, detaBaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView ans = (TextView) findViewById(R.id.ans);
        final TextView ts = (TextView) findViewById(R.id.ts);

        //detaBaseButton = (Button) findViewById(R.id.dataBase);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        Remainder = (Button) findViewById(R.id.Remainder);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        //sendButton = (Button) findViewById(R.id.send_button);

        edt1 = (TextView) findViewById(R.id.edt1);

        /*sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);
            }
        });*/


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Addition = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Subtract = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Multiplication = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Division = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        Remainder.setOnClickListener(new View.OnClickListener() {
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



                if (Addition || Subtract || Multiplication || Division || mRemainder) {
                    input2 = Float.parseFloat(edt1.getText() + "");
                }

                if (Addition) {
                    //edt1.setText(input1 + "+" + input2);
                    edt1.setText("");
                    Addition = false;
                    ans.setText((input1 + " + " + input2 ) + " = " + (input1 + input2) + "");
                    //long millis = System.currentTimeMillis();
                    //ts.setText(Long.toString(millis));

                    //String finalCalc = ((input1 + " + " + input2 ) + " = " + (input1 + input2) + "");
                    String finalCalc = (String) ans.getText().toString();

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    HashMap<String, Object> equations = new HashMap<>();
                    equations.put("equation", finalCalc );
                    equations.put("timestamp", FieldValue.serverTimestamp());
                    db.collection("equations").add(equations);

                }

                if (Subtract) {
                    edt1.setText("");
                    Subtract = false;
                    ans.setText((input1 + " - " + input2 ) + " = " + (input1 - input2) + "");
                    long millis = System.currentTimeMillis();
                    ts.setText(Long.toString(millis));

                    String finalCalc = (String) ans.getText().toString();

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    HashMap<String, Object> equations = new HashMap<>();
                    equations.put("equation", finalCalc );
                    equations.put("timestamp", FieldValue.serverTimestamp());
                    db.collection("equations").add(equations);

                }

                if (Multiplication) {
                    Multiplication = false;
                    ans.setText((input1 + " * " + input2 ) + " = " + (input1 * input2) + "");
                    long millis = System.currentTimeMillis();
                    ts.setText(Long.toString(millis));

                    String finalCalc = (String) ans.getText().toString();

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    HashMap<String, Object> equations = new HashMap<>();
                    equations.put("equation", finalCalc );
                    equations.put("timestamp", FieldValue.serverTimestamp());
                    db.collection("equations").add(equations);

                }

                if (Division) {
                    Division = false;
                    ans.setText((input1 + " / " + input2 ) + " = " + (input1 / input2) + "");
                    long millis = System.currentTimeMillis();
                    ts.setText(Long.toString(millis));

                    String finalCalc = (String) ans.getText().toString();

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    HashMap<String, Object> equations = new HashMap<>();
                    equations.put("equation", finalCalc );
                    equations.put("timestamp", FieldValue.serverTimestamp());
                    db.collection("equations").add(equations);

                }
                if (mRemainder) {
                    edt1.setText(Math.pow(input1, input2) + "");
                    mRemainder = false;
                    ans.setText((input1 + " ^ " + input2 ) + " = " + (Math.pow(input1, input2)) + "");
                    long millis = System.currentTimeMillis();
                    ts.setText(Long.toString(millis));


                    String finalCalc = (String) ans.getText().toString();

                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                    HashMap<String, Object> equations = new HashMap<>();
                    equations.put("equation", finalCalc );
                    equations.put("timestamp", FieldValue.serverTimestamp());
                    db.collection("equations").add(equations);
                }
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
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

        /*detaBaseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ans.setText("Test");
                ts.setText("Test");
                //Intent dbIntent = new Intent(MainActivity.this,
                  //      ShowDataBase.class);
                //startActivity(dbIntent);

            }
        });*/
    }
}