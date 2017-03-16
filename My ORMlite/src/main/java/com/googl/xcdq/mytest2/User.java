package com.googl.xcdq.mytest2;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 数据库的一个表
 *
 * @DatabaseTable(tableName = "user")表明他是一个数据库表
 * @DatabaseField(id = true)在属性上使用，表明他是表里面的一个字段
 * columnName指定数据库展示的字段名
 * canBeNull 此项可以为空
 * id = true 指定主键：不可以重复
 * generatedId 指定的id主键自动增长
 */
@DatabaseTable(tableName = "User")
public class User {

    @DatabaseField(id = true)
    public int id;

    @DatabaseField(columnDefinition = "NAME")
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

