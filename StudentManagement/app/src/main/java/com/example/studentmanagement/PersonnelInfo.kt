package com.example.studentmanagement

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class PersonnelInfo : AppCompatActivity() {

    // DB에 대한 변수
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    // 사용할 위젯을 담은 변수
    lateinit var tvName: TextView
    lateinit var tvGender: TextView
    lateinit var tvAge: TextView
    lateinit var tvTel: TextView
    
    // DB와 위젯 중간 다리가 되어 줄 변수들
    lateinit var str_name: String
    lateinit var str_gender: String
    var age: Int = 0
    lateinit var str_tel: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_info)

        // 위젯과 변수 연동
        tvName = findViewById(R.id.name)
        tvGender = findViewById(R.id.gender)
        tvAge = findViewById(R.id.age)
        tvTel = findViewById(R.id.tel)

        // 가져올 수강생의 조건을 찾기 위해 - 해당 이름 가져오기
        val intent = intent
        str_name = intent.getStringExtra("intent_name").toString()

        dbManager = DBManager(this, "personnelDB", null, 1)
        sqlitedb = dbManager.readableDatabase

        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM personnel WHERE name = '" + str_name + "';", null)

        if (cursor.moveToNext()){
            str_gender = cursor.getString((cursor.getColumnIndex("gender"))).toString()
            age = cursor.getInt((cursor.getColumnIndex("age")))
            str_tel = cursor.getString((cursor.getColumnIndex("tel"))).toString()
        }

        cursor.close()
        sqlitedb.close()
        dbManager.close()

        tvName.text = str_name
        tvGender.text = str_gender
        tvAge.text = "" + age
        tvTel.text = str_tel + "\n"
    }

    // 메뉴 설정
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_personnel_info, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_list -> {
                val intent = Intent(this, PersonnelList::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_reg -> {
                val intent = Intent(this, PersonnelReg::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_remove -> {

                dbManager = DBManager(this, "personnelDB", null, 1)
                sqlitedb = dbManager.writableDatabase

                sqlitedb.execSQL("DELETE FROM personnel WHERE name = '" + str_name + "';")
                sqlitedb.close()
                dbManager.close()

                val intent = Intent(this, PersonnelList::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}