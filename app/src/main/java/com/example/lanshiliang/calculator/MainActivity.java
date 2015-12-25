package com.example.lanshiliang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridLayout gridLayout;
    private TextView textView;
    private Button btnClean;
    Data data=new Data();
    private char []chars=new char[]{
            '7','8','9','/',
            '6','5','4','*',
            '3','2','1','-',
            '.','0','=','+',
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout= (GridLayout) findViewById(R.id.root);
        textView = (TextView) findViewById(R.id.showText);
        btnClean= (Button) findViewById(R.id.btnClean);
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0");
                data.reMoveAll();
            }
        });
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case 14:
                        textView.setText(String.valueOf(data.compute()));
                        data.reMoveAll();
                        break;
                    default:
                        data.add(chars[v.getId()]);
                        textView.setText(data.toString());
                        break;
                }


            }
        };
        for(int i=0;i<chars.length;i++){
            Button btn=new Button(this);
            btn.setId(i);
            btn.setTextSize(50);
            btn.setText(String.valueOf(chars[i]));
            GridLayout.Spec rowSpec=GridLayout.spec(i/4+2);
            GridLayout.Spec columnSpec=GridLayout.spec(i%4);
            GridLayout.LayoutParams params=new GridLayout.LayoutParams(rowSpec,columnSpec);
            params.setGravity(Gravity.FILL);
            gridLayout.addView(btn, params);
            btn.setOnClickListener(onClickListener);
        }



    }
}
