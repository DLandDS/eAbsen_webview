package id.kotlin.eabsen

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView = findViewById<WebView>(R.id.webview_main)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("http://kegiatan.iainbukittinggi.ac.id/absen/")
        webView.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}