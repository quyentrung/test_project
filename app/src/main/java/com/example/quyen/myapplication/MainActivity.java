package com.example.quyen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tvinput;
    private TextView tvhienthi;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btcong;
    private Button bttru;
    private Button btnhan;
    private Button btchia;

    private Button btbang;
    private Button btclearall;
    private Button btclear;
    private Button btpont;
    private int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickView();
    }
    public void initWidget(){
        tvinput = (EditText) findViewById(R.id.tvinput);
        tvhienthi = (TextView) findViewById(R.id.tvhienthi);

        btn0 = (Button) findViewById(R.id.bt0);
        btn1 = (Button) findViewById(R.id.bt1);
        btn2 = (Button) findViewById(R.id.bt2);
        btn3 = (Button) findViewById(R.id.bt3);
        btn4 = (Button) findViewById(R.id.bt4);
        btn5 = (Button) findViewById(R.id.bt5);
        btn6 = (Button) findViewById(R.id.bt6);
        btn7 = (Button) findViewById(R.id.bt7);
        btn8 = (Button) findViewById(R.id.bt8);
        btn9 = (Button) findViewById(R.id.bt9);

        btcong = (Button) findViewById(R.id.btcong);
        bttru = (Button) findViewById(R.id.bttru);
        btnhan = (Button) findViewById(R.id.btnhan);
        btchia = (Button) findViewById(R.id.btchia);

        btclearall = (Button) findViewById(R.id.btclearall);
        btclear = (Button) findViewById(R.id.btclear);
        btpont = (Button) findViewById(R.id.btpont);
        btbang = (Button) findViewById(R.id.btbang);
    }
    public void setEventClickView(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btcong.setOnClickListener(this);
        bttru.setOnClickListener(this);
        btnhan.setOnClickListener(this);
        btchia.setOnClickListener(this);

        btclearall.setOnClickListener(this);
        btclear.setOnClickListener(this);
        btpont.setOnClickListener(this);
        btbang.setOnClickListener(this);


    }

    @Override
    public void onClick(View v ) {

        switch (v.getId()) {
            case R.id.bt0:
                tvinput.append("0");
                n = 0;
                break;
            case R.id.bt1:
                tvinput.append("1");
                n = 0;
                break;
            case R.id.bt2:
                tvinput.append("2");
                n = 0;
                break;
            case R.id.bt3:
                tvinput.append("3");
                n = 0;
                break;
            case R.id.bt4:
                tvinput.append("4");
                n = 0;
                break;
            case R.id.bt5:
                tvinput.append("5");
                n = 0;
                break;
            case R.id.bt6:
                tvinput.append("6");
                n = 0;
                break;
            case R.id.bt7:
                tvinput.append("7");
                n = 0;
                break;
            case R.id.bt8:
                tvinput.append("8");
                n = 0;
                break;
            case R.id.bt9:
                tvinput.append("9");
                n = 0;
                break;
            case R.id.btcong:
                if (n == 1){
                    tvinput.append("");
                }
                else {
                    tvinput.append("+");
                }
                n = 1;
                break;
            case R.id.bttru:
                if (n == 1){
                    tvinput.append("");
                }
                else {
                    tvinput.append("-");
                }
                n = 1;
                break;
            case R.id.btnhan:
                if (n == 1){
                    tvinput.append("");
                }
                else {
                    tvinput.append("x");
                }
                n = 1;
                break;
            case R.id.btchia:
                if (n == 1){
                    tvinput.append("");
                }
                else {
                    tvinput.append("/");
                }
                n = 1;
                break;
            case R.id.btclearall:
                tvinput.setText("");
                break;
            case R.id.btclear:
                /*String numafter = deletrNumber(tvinput.getText().toString());
                tvinput.setText(numafter);*/
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(tvinput, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btpont:
                tvinput.append(".");
                break;
            case R.id.btbang:
                DecimalFormat df = new DecimalFormat("###.####");
                double result = 0;
                addOperation(tvinput.getText().toString());
                addNumber(tvinput.getText().toString());
                if (arrNumber.size() == 1) {
                    result = arrNumber.get(0);
                } else
                    {
                    /*    double muti = 0;
                        for (int j = 0 ; j < (arrNumber.size() - 1) ; j++) {

                            if (arrOperation.get(j)=="x"){
                                muti = arrNumber.get(j-1) * arrNumber.get(j + 1);
                                muti_string = String.valueOf(muti);
                                add(arrTotal.get(j-1) + "")
                            }
                        }
*/




                    for (int i = 0 ; i < (arrNumber.size() - 1) ; i++) {
                        arrTotal.get(i);
                            switch (arrOperation.get(i)) {
                                case "+":
                                    if (i == 0) {
                                        result = arrNumber.get(i) + arrNumber.get(i + 1);
                                    } else {
                                        result = result + arrNumber.get(i + 1);
                                    }
                                    break;
                                case "-":
                                    if (i == 0) {
                                        result = arrNumber.get(i) - arrNumber.get(i + 1);
                                    } else {
                                        result = result - arrNumber.get(i + 1);
                                    }
                                    break;
                                case "x":
                                    if (i == 0) {
                                        result = arrNumber.get(i) * arrNumber.get(i + 1);
                                    } else {
                                        result = result * arrNumber.get(i + 1);
                                    }
                                    break;
                                case "/":
                                    if (i == 0) {
                                        result = arrNumber.get(i) / arrNumber.get(i + 1);
                                    } else {
                                        result = result / arrNumber.get(i + 1);
                                    }
                                    break;
                                default:
                            }
                        }
                    }
                    tvhienthi.setText(df.format(result) + "");


                /*Log.d(TAG, "onClick: "+result);*/
                break;

        }
    }
    /*    public String deletrNumber(String number) {
            int lenght = number.length();
            String tem = number.substring(0,lenght-1);

            return tem;
        }*/
    public ArrayList<String> arrOperation;
    public ArrayList<String> arrTotal;
    public ArrayList<Double> arrNumber;

    // get phép tính vào mảng arroperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char [] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/' :
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public int arrTotal(String input) {
        char [] cArray = input.toCharArray();
        return 0;
    }

    public void addNumber(String stringInput){
        arrNumber = new ArrayList<>();
        Pattern regex =Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}
