package com.googl.xcdq.mytest2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by xcdq on 2017/3/16.
 */

// 数据库的帮助类：创建数据库和表等还有更新
public class ORMLiteSqlHelp extends OrmLiteSqliteOpenHelper {
    private static ORMLiteSqlHelp ormLiteSqlHelp;

    // 建议应用中只持有一个实例：对他做单例
    private ORMLiteSqlHelp(Context context) {
        super(context, "orm.db", null, 1);
    }

    public static synchronized ORMLiteSqlHelp getInstance(Context context) {
        if (ormLiteSqlHelp == null) {
            ormLiteSqlHelp = new ORMLiteSqlHelp(context.getApplicationContext());
        }
        return ormLiteSqlHelp;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            // 先删除，再创建
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
