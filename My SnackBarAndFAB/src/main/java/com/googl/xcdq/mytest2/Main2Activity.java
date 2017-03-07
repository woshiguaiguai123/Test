package com.googl.xcdq.mytest2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;

public class Main2Activity extends AppCompatActivity {
    private Button mButton1;
    private TSnackbar mTSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButton1 = (Button) findViewById(R.id.button3);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initWidget();
            }
        });
    }

    private void initWidget() {
        mTSnackbar=TSnackbar.make(findViewById(android.R.id.content), "测试一下",
                TSnackbar.LENGTH_INDEFINITE);
        mTSnackbar.setActionTextColor(Color.WHITE);
        View view=mTSnackbar.getView();
        view.setBackgroundColor(Color.parseColor("#FF00FF"));
        TextView mTextView= (TextView) view.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        mTextView.setTextColor(Color.BLUE);
        mTSnackbar.setAction("action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "玩玩", Toast.LENGTH_SHORT).show();
            }
        });
        mTSnackbar.show();
    }
}
