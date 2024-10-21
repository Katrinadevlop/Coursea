package com.example.coursea

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                EMAIL_COl + " TEXT," +
                PASSWORD_COL + " TEXT" + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addData(email : String, password : String ){
        val values = ContentValues()
        values.put(EMAIL_COl, email)
        values.put(PASSWORD_COL, password)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getData(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }

    fun isUserRegistered(email:String, password: String):Boolean{
        val db = this.readableDatabase
        val query = "SELECT * FROM person_table WHERE email = ? AND password = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))

        val isRegistered = cursor.count > 0
        cursor.close()
        return isRegistered
    }

    companion object{
        private val DATABASE_NAME = "Coursea_Data"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "person_table"
        val ID_COL = "id"
        val EMAIL_COl = "email"
        val PASSWORD_COL = "password"
    }
}
