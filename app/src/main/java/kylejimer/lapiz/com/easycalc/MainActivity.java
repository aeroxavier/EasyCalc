package kylejimer.lapiz.com.easycalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNo1;
    EditText etNo2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnClr;
    Button btnExit;
    TextView tvRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       etNo1 = (EditText) findViewById(R.id.editText);
        etNo2 = (EditText) findViewById(R.id.editText2);

     btnAdd = (Button) findViewById(R.id.button);
       btnSub = (Button) findViewById(R.id.button2);
      btnMult = (Button) findViewById(R.id.button4);
        btnDiv = (Button) findViewById(R.id.button5);
        btnClr = (Button) findViewById(R.id.button3);
        btnExit = (Button) findViewById(R.id.button6);

     tvRes = (TextView) findViewById(R.id.textView);
    btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClr.setOnClickListener(this);
        btnExit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
    float no1;
        float no2;
        String res2;
        if (TextUtils.isEmpty(etNo1.getText().toString())
                || TextUtils.isEmpty(etNo2.getText().toString())) {
            Toast warning = Toast.makeText(MainActivity.this,"Please enter a valid number", Toast.LENGTH_LONG);
            warning.show();
            return;
        }
        no1 = Float.parseFloat(etNo1.getText().toString());
       no2 = Float.parseFloat(etNo2.getText().toString());




        float res=(Float.valueOf(tvRes.getText().toString()));
        DecimalFormat formatter = new DecimalFormat("#,###,###.00");

     Others o= new Others();

        switch (view.getId()) {
            case R.id.button: res=o.add(no1,no2);
                break;
            case R.id.button2:res=o.subtract(no1,no2);
                break;
            case R.id.button4: res=o.multiply(no1,no2);
                break;
            case R.id.button5: res=o.divide(no1,no2);
                break;
            case R.id.button3:  etNo1.setText("");
                etNo2.setText("");

                res=0;
                tvRes.setText("");
                break;
            case R.id.button6:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;

            default:
                break;
        }
        res2=formatter.format(res);

        tvRes.setText(res2);
    }


}
