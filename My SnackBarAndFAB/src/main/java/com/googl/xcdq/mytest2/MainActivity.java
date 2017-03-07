package com.googl.xcdq.mytest2;

import android.graphics.Color;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private CoordinatorLayout mcCoordinatorLayout;
    private int mwssageShowNumber = 0;
    private int systemGc = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.corrd);
        mButton = (Button) findViewById(R.id.btn_1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initwidget();
                gc();
            }
        });
    }

    private void initwidget() {
        Snackbar mSnackbar = Snackbar.make(mcCoordinatorLayout, "这是一个测试", Snackbar.LENGTH_INDEFINITE).setAction("点它",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "kljol,", Toast.LENGTH_SHORT).show();
                    }
                }
        ).setDuration(4000).setActionTextColor(Color.parseColor("#FFFFFF"));
        setSnackbarMessageTextColor(mSnackbar, Color.parseColor("#FF0000"));
        mSnackbar.show();
    }

    private static void setSnackbarMessageTextColor(Snackbar snackbar, int anctionColor) {
        View view = snackbar.getView();
        view.setBackgroundColor(Color.parseColor("#FF00FF"));
        if (view != null) {
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(anctionColor);
        }
    }

    private void gc() {
        mwssageShowNumber++;
        if (mwssageShowNumber >= systemGc) {
            System.gc();
            mwssageShowNumber = 0;
        }
    }
}
