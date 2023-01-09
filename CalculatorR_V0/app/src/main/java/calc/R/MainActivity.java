package calc.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,
            bSumar,bRestar, bMultiplicar, bDividir, bIgual, bComa, bSignos,bBorrar,bBorrarElementos;
    private TextView txRow;
    private EditText txResult;
    private long number;
    private Double result,auxI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = 0;
        result = 0.0;
        auxI = 0.0;
        findId();
        click();
    }

    //Asociacion de las variables del layout
    private void findId() {
        b0 = findViewById(R.id.button11);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        bSignos = findViewById(R.id.button10);
        bComa = findViewById(R.id.button12);
        bIgual = findViewById(R.id.button16);
        bSumar = findViewById(R.id.button15);
        bMultiplicar = findViewById(R.id.button13);
        bRestar = findViewById(R.id.button14);
        bDividir = findViewById(R.id.button18);
        bBorrar = findViewById(R.id.button17);
        bBorrarElementos = findViewById(R.id.button20);
        txResult = findViewById(R.id.textView);
        txRow = findViewById(R.id.textView2);
    }

    //Eventos
    private void click() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "7");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "8");
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "9");
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "6");
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "5");
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "4");
                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "1");
                }
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "2");
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkStringResultLenght(txResult.getText())){
                    txResult.setText(txResult.getText() + "3");
                }
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txResult.setText(txResult.getText() + "0");
            }
        });
        bSignos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSign();
            }
        });
        bSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(operationPress()){
                  if(!txResult.getText().equals("")){
                          txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim() + "+");
                          txResult.setText("");
                  }
               }
            }
        });
        bRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operationPress()){
                    if(!txResult.getText().equals("")){

                        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim() + "-");
                        txResult.setText("");

                    }
                }
            }
        });
        bMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operationPress()){
                    if(!txResult.getText().equals("")){

                        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim() + "x");
                        txResult.setText("");

                    }
                }
            }
        });
        bIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bIgual.isPressed()){
                        if(txRow.getText().toString().trim().contains("+")) {
                            System.out.println("Se va a sumar");
                        }
                        if(txRow.getText().toString().contains("+")){
                            sumar();
                        }
                        if(txRow.getText().toString().trim().contains("-")){
                            System.out.println("Se va a restar");
                            restar();
                        }
                        if(txRow.getText().toString().contains("x")){
                            System.out.println("Se va a multiplicar");
                            multiplicar();
                        }
                        if(txRow.getText().toString().contains("/")) {
                            System.out.println("Se va a dividir");
                            dividir();
                        }
                    }
                  //  ArrayList<String> sequenceArrayList = new ArrayList<String>();
                  //  sequenceArrayList.addAll(Arrays.asList(sequenceArray));
                  //  List<Integer> intList = sequenceArrayList.stream()
                  //          .mapToInt(Integer::parseInt)
                  //          .boxed()
                  //          .collect(Collectors.toList());
                  //  int result = 0;
                  //  for (int s : intList) {
                  //      result+=s
                    //  }

                  //  txResult.setText(result+"");
                }

        });
        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetOperation();
            }
        });
        bDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operationPress()){
                    if(!txResult.getText().equals("")){

                        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim() + "/");
                        txResult.setText("");

                    }
                }
            }
        });
        bComa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putDot();
            }
        });
        bBorrarElementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txResult.getText().toString().equals("") || txResult.getText().toString().equals("0")){

                }else{
                    resultStringList(deleteElements());
                }

            }
        });
    }
//Check events
    private boolean operationPress() {
       return (bSumar.isPressed() || bRestar.isPressed() || bMultiplicar.isPressed() || bDividir.isPressed()) ? true : false;
    }
    private boolean checkStringResultLenght(CharSequence sequence) {
        return (sequence.length() >= 16 ?true:false);
    }
    private void doOperation() {

        if (operationPress()) {
            System.out.println("Se ha presionado un boton de operacion");
        }
    }
    //Operation Events
    private void changeSign() {
        String numAux = txResult.getText().toString();
        result = Double.parseDouble(numAux) * (-1);
        txResult.setText(result+"");
    }
    private void resetOperation(){
        txRow.setText("");
        txResult.setText("");
    }

    public static boolean isExact(double num) {

        int integerNum = (int) num;
        return num-integerNum==0?true:false;
    }
    private void putDot(){
       String aux = txResult.getText().toString();
       if(!aux.contains(".")){
           txResult.setText(aux+("."));
       }
    }
    //Aritmetic operations
    private void sumar (){
        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim());
        System.out.println();

        System.out.println(txRow.getText()+" +++++++++++++++++++++++++++++++++ ");
        CharSequence aux = (String) txRow.getText().toString().trim();

        String sequenceArray [] = (aux.toString().split("\\+"));

        result = 0.0;
        auxI  = 0.0;
        for (int i = 0; i < sequenceArray.length; i++) {
            System.out.println(sequenceArray[i]+" posicion "+i);
            auxI = Double.parseDouble(sequenceArray[i]);
            result+=auxI;
        }
        txResult.setText(""+result);
        txRow.setText("");
    }

    private void multiplicar (){
        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim());
        System.out.println();

        System.out.println(txRow.getText()+" ************************* ");
        CharSequence aux = (String) txRow.getText().toString().trim();

        String sequenceArray [] = (aux.toString().split("x"));

        result = 0.0;
        auxI  = 0.0;
        for (int i = 0; i < sequenceArray.length; i++) {
            System.out.println(sequenceArray[i]+" posicion "+i);
            auxI = Double.parseDouble(sequenceArray[i]);
            if (i == 0) {
                result = auxI;
            } else if (i == 1) {
                result *= auxI;
            }
        }
        txResult.setText(""+result);
        txRow.setText("");
    }

    private void restar (){
        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim());
        System.out.println();
        System.out.println(txRow.getText()+" ---------------------------- ");

        CharSequence aux = (String) txRow.getText().toString().trim();
        String sequenceArray [] = (aux.toString().split("-"));
        result = 0.0;
        auxI  = 0.0;

        for (int i = 0; i < sequenceArray.length; i++) {
            System.out.println(sequenceArray[i]+" posicion "+i);
            auxI = Double.parseDouble(sequenceArray[i]);
            if (i == 0) {
                result = auxI;
            } else if (i == 1) {
                result -= auxI;
            }
        }
        txResult.setText(""+result);
        txRow.setText("");
    }

    private void dividir(){
        txRow.setText(txRow.getText().toString().trim() + txResult.getText().toString().trim());
        System.out.println();
        System.out.println(txRow.getText()+" //////////////////////////////// ");

        CharSequence aux = (String) txRow.getText().toString().trim();
        String sequenceArray [] = (aux.toString().split("/"));
        result = 0.0;
        auxI  = 0.0;

        for (int i = 0; i < sequenceArray.length; i++) {
            System.out.println(sequenceArray[i]+" posicion "+i);
            auxI = Double.parseDouble(sequenceArray[i]);
            if (i == 0) {
                result = auxI;
            } else if (i == 1) {
                result /= auxI;
            }
        }
        if(isExact(result)){

            System.out.println(result+" Es exacto");
            number = Math.round(result);
            txResult.setText(""+number);
            txRow.setText("");
        }else {
            System.out.println(result+" NO Es exacto");

            txResult.setText(""+result);
            txRow.setText("");
        }

    }

    private List<String> deleteElements(){

        String aux =txResult.getText().toString();

        String[] stringArray = aux.split("");

        List<String> stringList = new ArrayList<>(Arrays.asList(stringArray));
        int cont = 0;
        for (String g: stringList) {

            System.out.println("Posicion "+cont+"Valor "+g);
            cont++;
        }

        stringList.remove(stringList.size()-1);

        return stringList;
    }

    private void resultStringList(List<String> result){

        String[] stringArray = result.toArray(new String[result.size()]);

        String resultString = String.join("",stringArray);

        txResult.setText(resultString);
    }
}