package com.googl.xcdq.mytest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ORMLiteSqlHelp ormLiteSqlHelp = ORMLiteSqlHelp.getInstance(this);
        UserDao userDao = new UserDao(ormLiteSqlHelp);
        // 数据的填充
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setName("用户" + i);
            userDao.createOrUpdate(user);
        }

        // 查询所有的
        List<User> users = userDao.queryForAll();
        for (User user : users) {
            Log.i("TAG", user.toString());
        }

        User user = userDao.queryForId(2);
        Log.i("TAG", "id为2的数据" + user.toString());
    }
}

