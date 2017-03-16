package com.googl.xcdq.mytest2;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xcdq on 2017/3/16.
 */

public class UserDao {
    // User表的一个操作类：Dao
    private Dao<User, Long> mDao;

    public UserDao(ORMLiteSqlHelp dbHelp) {
        try {
            mDao = dbHelp.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 添加和更新数据
    public void createOrUpdate(User user) {
        try {
            mDao.createOrUpdate(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 添加多条数据
    public void createOrUpdate(List<User> list) {
        for (User user : list) {
            createOrUpdate(user);
        }
    }

    // 查询所有的数据
    public List<User> queryForAll() {
        try {
            return mDao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 按id查询
    public User queryForId(long id) {
        try {
            return mDao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 条件查询：某一个数据不为空的数据
    public List<User> queryNotNull() {
        try {
            return mDao.queryBuilder().where().isNotNull("NAME").query();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 删除
    public void deleteById(long id) {
        try {
            mDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
