package com.saucedo.math;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText txtnumero1;
    private EditText txtnumero2;

    private TextView txvResultado;

    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializar();
    }
    private void initializar(){
        this.txtnumero1=findViewById(R.id.txtnumero1); //Almacena los valores de los numeros
        this.txtnumero2=findViewById(R.id.txtnumero2);

        this.txvResultado=findViewById(R.id.txvresultado); // Etiqueta que muestra los resultados

        this.btnSumar=findViewById(R.id.btnsumar); //Inicilaizacoin de los botones
        this.btnSumar.setOnClickListener(lstmath);

        this.btnRestar=findViewById(R.id.btnrestar);
        this.btnRestar.setOnClickListener(lstmath);

        this.btnMultiplicar=findViewById(R.id.btnmultiplicar);
        this.btnMultiplicar.setOnClickListener(lstmath);

        this.btnDividir=findViewById(R.id.btndividir);
        this.btnDividir.setOnClickListener(lstmath);

    }

    private View.OnClickListener lstmath = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String cadena= ((Button)view).getText().toString();

            float  num1=0;
            float  num2=0;
            float resultado=0;

            try {
                num1 = Integer.parseInt(txtnumero1.getText().toString());
                num2 = Integer.parseInt(txtnumero2.getText().toString());
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(),"Error,Ingrese numeros",Toast.LENGTH_SHORT).show();
            }


            switch (cadena){
                case "+":
                        resultado=num1+num2;
                    break;
                case "-":
                        resultado=num1-num2;
                    break;
                case "*":
                        resultado=num1*num2;
                    break;
                case "/":
                    try {
                        resultado = num1 / num2;
                    }catch (ArithmeticException e){
                        Toast.makeText(getApplicationContext(),"Error, cero/cero",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            txvResultado.setText(String.valueOf(resultado));

        }
    };

}
