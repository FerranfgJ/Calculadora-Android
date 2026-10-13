package com.ferros.calculadora;

import static com.ferros.calculadora.R.*;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;


public class MainActivity extends AppCompatActivity {
    static String oper = "";
    static int indexx = 0;

    static double[] a = new double[2];

    static String operacio = "";

    static double last;

    static double memoria = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView tvName = findViewById(R.id.resul);



        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                tvName, 24, 90, 2, TypedValue.COMPLEX_UNIT_SP);

        tvName.setText("");

        View.OnClickListener btnNum = v ->{

            Button btnPulsado = (Button) v;


                if (btnPulsado.getText().toString().equals("+")){

                    a[indexx] = (Double.parseDouble((String) tvName.getText()));
                    if (indexx < 1){
                        indd("+");
                    }else {
                        calcOp("+");
                    }
                    tvName.setText("");

                }else if (btnPulsado.getText().toString().equals("/")){

                    a[indexx] = (Double.parseDouble((String) tvName.getText()));
                    if (indexx < 1){
                        indd("/");
                    }else {
                        calcOp("/");
                    }
                    tvName.setText("");

                }else if (btnPulsado.getText().toString().equals("X")){

                    a[indexx] = (Double.parseDouble((String) tvName.getText()));
                    if (indexx < 1){
                        indd("X");

                    }else {
                        calcOp("X");
                    }
                    tvName.setText("");

                }else if (btnPulsado.getText().toString().equals("-")){

                    a[indexx] = (Double.parseDouble((String) tvName.getText()));
                    if (indexx < 1){
                        indd("-");
                    }else {
                        calcOp("-");
                    }
                    tvName.setText("");

                }else if (btnPulsado.getText().toString().equals("eq")){

                    a[1] = (Integer.parseInt((String) tvName.getText()));


                    tvName.setText(String.valueOf(oper(a[0], a[1])));

                    last = oper(a[0], a[1]);

                    indexx = 0;
                    a[1] = 0;
                    a[0] = (Double.parseDouble((String) tvName.getText()));


                    operacio = String.valueOf(last);


                } else if (btnPulsado.getText().toString().equals("M+")) {
                    if (!tvName.getText().toString().isEmpty()) {
                       memoria += Double.parseDouble(tvName.getText().toString().replace(",", "."));
                    }
                } else if (btnPulsado.getText().toString().equals("M-")) {
                     if (!tvName.getText().toString().isEmpty()) {
                        memoria -= Double.parseDouble(tvName.getText().toString().replace(",", "."));
                     }
                } else if (btnPulsado.getText().toString().equals("MR")) {
                    tvName.setText(String.valueOf(memoria));
                } else if (btnPulsado.getText().toString().equals("MC")) {

                    memoria = 0;
                }else {
                    tvName.setText(tvName.getText().toString() + btnPulsado.getText().toString());
                }

                 String valor = btnPulsado.getText().toString();
                if (!valor.equals("eq") && !valor.equals("M+") && !valor.equals("M-") && !valor.equals("Mr") && !valor.equals("Mc")) {
                    operacio += valor;
                }

        };

        findViewById(R.id.btn0).setOnClickListener(btnNum);
        findViewById(R.id.btn1).setOnClickListener(btnNum);
        findViewById(R.id.btn2).setOnClickListener(btnNum);
        findViewById(R.id.btn3).setOnClickListener(btnNum);
        findViewById(R.id.btn4).setOnClickListener(btnNum);
        findViewById(R.id.btn5).setOnClickListener(btnNum);
        findViewById(R.id.btn6).setOnClickListener(btnNum);
        findViewById(R.id.btn7).setOnClickListener(btnNum);
        findViewById(R.id.btn8).setOnClickListener(btnNum);
        findViewById(R.id.btn9).setOnClickListener(btnNum);
        findViewById(id.btncoma).setOnClickListener(btnNum);
        findViewById(id.btnmenys).setOnClickListener(btnNum);
        findViewById(id.btnmes).setOnClickListener(btnNum);
        findViewById(id.btnPer).setOnClickListener(btnNum);
        findViewById(id.btnbar).setOnClickListener(btnNum);
        findViewById(id.btnigual).setOnClickListener(btnNum);
        findViewById(id.btnMmes).setOnClickListener(btnNum);
        findViewById(id.btnMmenys).setOnClickListener(btnNum);
        findViewById(id.btnMr).setOnClickListener(btnNum);
        findViewById(id.btnMc).setOnClickListener(btnNum);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static double oper(double n1, double n2){
        switch (oper) {
            case "-":
                return n1 - n2;

            case "+":
                return n1 + n2;

            case "X":
                return n1 * n2;

            case "/":
                return n1 / n2;
        }
        return 0;
    }

    public static int btnValue(Button a, int n){
        if (a.getText().toString().equals("+")){
            return n;
        }
        return 1;
    }

    public static void indd(String operador){
        indexx++;
        oper = operador;
    }

    public static void calcOp(String operador){
        a[0] = oper(a[0], a[1]);
        a[1] = 0;
        oper = operador;
    }

}