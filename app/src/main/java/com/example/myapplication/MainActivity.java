package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.text.SpannableStringBuilder;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextureView previousCalculation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalclationView);
        display = findViewById(R.id.displayEditText);

        display. setShowSoftInputOnFocus(false);

    }

    private void updateText (String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos =display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

        public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
         public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
         public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoTxt));
    }
         public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
        public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
        public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
        public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
         public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
        public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
        public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
        public void parenthesesOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
        public void parenthesesCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
        public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
        public void multipliedBTNPush(View view){
        updateText(getResources().getString(R.string.multipliedText));
    }
        public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
        public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }
        public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

        public void clearBTNPush(View view){
            display.setText("");

    }

            public void equalBTNPush(View view){
            String userExp = display.getText() . toString();



            userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
            userExp = userExp.replaceAll(getResources().getString(R.string.multipliedText), "*");

            Expression exp = new Expression(userExp);
            String result = String.valueOf(exp.calculate());

            display.setText(result);
            display.setSelection(result.length());

    }

        public void backspaceBTNPush(View view){
            int cursorPos = display.getSelectionStart();
            int textLen = display. getText().length();

            if (cursorPos != 0 && textLen != 0){
                SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                selection.replace(cursorPos-1, cursorPos, "");
                display.setText(selection);
                display.setSelection(cursorPos-1);
            }

    }

    public void trigSinBTNP(View view){
        updateText("sin(");

    }


    public void trigCosBTNP(View view){
        updateText("cos(");

    }
    public void trigTanBTNP(View view){
        updateText("tan(");

    }
    public void trigArcSinBTNP(View view){
        updateText("arcsin(");

    }
    public void trigArcCosBTNP(View view){
        updateText("arccos(");

    }
    public void trigArcTanBTNP(View view){
        updateText("arctan(");

    }
    public void naturalLogBTNP(View view){
        updateText("ln(");

    }
    public void logBTNP(View view){
        updateText("log(");

    }
    public void sqqrtBTNP(View view){
        updateText("sqrt(");

    }
    public void absBTNP(View view){
        updateText("abs(");

    }
    public void piBTNP(View view){
        updateText("pi(");

    }
    public void eBTNP(View view){
        updateText("e(");

    }
    public void xSquaredBTNP(View view){
        updateText("^(2)");

    }

    public void xPowerYBTNP(View view){
        updateText("^(");

    }
    public void PrimeFunctionBTNP(View view){
        updateText("ispr(");

    }



}