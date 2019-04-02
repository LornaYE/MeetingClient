package com.jim.xun.meetingclient.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.jim.xun.meetingclient.Util.User;

import java.util.ArrayList;
import java.util.List;


public class MyDao {
    private static final String TAG = "MyDao";
    private Context context;
    private MyDBHelper myDBHelper;

    private final String[] MY_COLUMNS = new String[]{"UserName", "Password", "Telephone", "Address",
            "QQ", "Wechat", "Bir", "Sex"};


    public MyDao(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }

    /**
     * 判断表中是否有数据
     */
    public boolean isDataExist() {
        int count = 0;

        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = myDBHelper.getReadableDatabase();
            cursor = db.query("Users", new String[]{"COUNT(UserName)"},
                    null, null, null, null, null);

            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            if (count > 0)
                return true;
        } catch (Exception e) {
            Log.e(TAG, "", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return false;
    }


    /**
     * 初始化数据
     */
    public void initTable() {
        SQLiteDatabase db = null;

        try {
            db = myDBHelper.getWritableDatabase();
            db.beginTransaction();

            db.execSQL("insert into " + "Users" +
                    " (UserName, Password, Telephone, Address, QQ, Wechat, Bir, Sex) " +
                    "values ('111', '000', '123456789','321654987','123456','654321',NULL,'男')");
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "", e);
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();
            }
        }
    }

    /**
     * 新增一条数据
     */
    public boolean insertDate(String UserName, String Password, String Telephone, String Address
            , String QQ, String Wechat, String Bir, String Sex) {
        SQLiteDatabase db = null;

        try {
            db = myDBHelper.getWritableDatabase();
            db.beginTransaction();

            // insert into Orders(Id, CustomName, OrderPrice, Country) values (7, "Jne", 700, "China");
            ContentValues contentValues = new ContentValues();
            contentValues.put("UserName", UserName);
            contentValues.put("Password", Password);
            contentValues.put("Telephone", Telephone);
            contentValues.put("Address", Address);
            contentValues.put("QQ", QQ);
            contentValues.put("Wechat", Wechat);
            contentValues.put("Bir", Bir);
            contentValues.put("Sex", Sex);
            db.insertOrThrow("Users", null, contentValues);
            db.setTransactionSuccessful();
            return true;
        } catch (SQLiteConstraintException e) {
            Toast.makeText(context, "主键重复", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "", e);
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();
            }
        }
        return false;
    }

    /**
     * 数据查询  此处将用户名为"Bor"的信息提取出来
     */
    public List<User> getBorOrder(String userName) {
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = myDBHelper.getReadableDatabase();

            // select * from Orders where CustomName = 'Bor'
            cursor = db.query("Users",
                    MY_COLUMNS,
                    "UserName = ?",
                    new String[]{userName},
                    null, null, null);

            if (cursor.getCount() > 0) {
                List<User> orderList = new ArrayList<User>(cursor.getCount());
                while (cursor.moveToNext()) {
                    User user = parseOrder(cursor);
                    orderList.add(user);
                }
                return orderList;
            }
        } catch (Exception e) {
            Log.e(TAG, "", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return null;
    }

    /**
     * 数据查询  此处将用户名为"Bor"的信息提取出来
     */
    public Boolean isBorOrder(String userName) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        db = myDBHelper.getReadableDatabase();
        cursor = db.query("Users",
                MY_COLUMNS,
                "UserName = ?",
                new String[]{userName},
                null, null, null);

        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    /**
     * 将查找到的数据转换成Order类
     */
    private User parseOrder(Cursor cursor) {
        User user = new User();
        user.setUserName(cursor.getString(cursor.getColumnIndex("UserName")));
        user.setPassword(cursor.getString(cursor.getColumnIndex("Password")));
        user.setTelephone(cursor.getString(cursor.getColumnIndex("Telephone")));
        user.setAddress(cursor.getString(cursor.getColumnIndex("Address")));
        user.setQQ(cursor.getString(cursor.getColumnIndex("QQ")));
        user.setWechat(cursor.getString(cursor.getColumnIndex("Wechat")));
        user.setBir(cursor.getString(cursor.getColumnIndex("Bir")));
        user.setSex(cursor.getString(cursor.getColumnIndex("Sex")));
        return user;
    }
}
