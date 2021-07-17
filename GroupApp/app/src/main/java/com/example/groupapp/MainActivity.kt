package com.example.groupapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    lateinit var edtName: EditText
    lateinit var edtNumber: EditText
    lateinit var edtNameResult: EditText
    lateinit var edtNumberResult: EditText

    lateinit var btnInit: Button
    lateinit var btnInsert: Button
    lateinit var btnSelect: Button
    lateinit var btnDelete: Button
    lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById<EditText>(R.id.edtName)
        edtNumber = findViewById(R.id.edtNumber)
        edtNameResult = findViewById(R.id.edtNameResult)
        edtNumberResult = findViewById(R.id.edtNumberResult)

        btnInit = findViewById(R.id.btnInit)
        btnInsert = findViewById(R.id.btnInsert)
        btnSelect = findViewById(R.id.btnSelect)
        btnDelete = findViewById(R.id.btnDelete)
        btnUpdate = findViewById(R.id.btnUpdate)

        myHelper = myDBHelper(this)

        btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()
        }

        btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase

            sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"+ edtName.text.toString() + "', " + edtNumber.text.toString() + ");")
            sqlDB.close()
            Toast.makeText(applicationContext, "입력되었습니다.", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase

            var cursor: Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null)

            var strNames = "그룹이름" + "\r\n" + "--------" + "\r\n"
            var strNumbers = "인원" + "\r\n" + "--------" + "\r\n"
            
            while (cursor.moveToNext()){
                strNames += cursor.getString(0) + "\r\n"
                strNumbers += cursor.getString(1) + "\r\n"
            }

            edtNameResult.setText(strNames)
            edtNumberResult.setText(strNumbers)

            cursor.close()
            sqlDB.close()
        }

        btnDelete.setOnClickListener{
            sqlDB = myHelper.writableDatabase

            sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + edtName.text.toString() + "';")

            sqlDB.close()

            Toast.makeText(applicationContext, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        btnUpdate.setOnClickListener {
            sqlDB = myHelper.writableDatabase

            //UPDATE 테이블명 SET 컬럼명 = 변경할 값 WHERE 컬럼명=값;
            sqlDB.execSQL("UPDATE groupTBL SET gNumber = " + edtNumber.text.toString() + " WHERE gName = '" + edtName.text.toString() + "';")

            sqlDB.close()
            btnSelect.callOnClick()
        }

    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1){

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER );")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS groupTBL")   // DB 삭제
            onCreate(db)    // DB 다시 생성
        }

    }
}