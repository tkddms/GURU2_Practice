package com.example.mywebbrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var urlEditText: EditText

    lateinit var btnBack: Button
    lateinit var btnGo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlEditText = findViewById(R.id.urlEditText)
        btnBack = findViewById(R.id.btnBack)
        btnGo = findViewById(R.id.btnGo)

        // webView 기본 설정
        webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        webView.loadUrl("http://www.google.com")

        // 컨텍스트 메뉴 등록
        registerForContextMenu(webView)

        // editText 속 URL로 이동
        urlEditText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                webView.loadUrl(urlEditText.text.toString())
                true
            }else{
                false
            }
        }

        btnBack.setOnClickListener {
            webView.goBack()
        }

        btnGo.setOnClickListener {
            webView.goForward()
        }
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            // 뒤로 갈 수 있을 때
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_google, R.id.action_home -> {
                webView.loadUrl("http://www.google.com")
                return true
            }
            R.id.action_naver -> {
                webView.loadUrl("http://www.naver.com")
            }
            R.id.action_daum -> {
                webView.loadUrl("http://www.daum.net")
            }
            R.id.action_call -> {
                // 전화하기
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:012-3456-7890")
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.action_send_text -> {
                // 문자 보내기
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("smsto:" + Uri.encode("012-3456-7890"))
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.action_email -> {
                // 메일 보내기
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:example@example.com")
                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
                return true
            }
            R.id.action_refresh -> {
                webView.reload()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    // 컨텍스트 메뉴 등록
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_share -> {
                // 페이지 공유
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, webView.url.toString())
                intent.setType("text/plain")
                val shareIntent = Intent.createChooser(intent, "공유 페이지")
                startActivity(shareIntent)
                return true
            }
            R.id.action_browser -> {
                // 기본 웹브라우저에서 열기
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webView.url))
                startActivity(Intent.createChooser(intent, "Browser"))
                return true
            }
        }

        return super.onContextItemSelected(item)
    }
}