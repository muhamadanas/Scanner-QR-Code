package org.anas.scannerqrcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFunc()
    }

    private fun initFunc(){
        button2.setOnClickListener {
            initScan()
        }
    }

    private fun initScan(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val relsult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        if (relsult != null){
            if(relsult.contents == null){
                Toast.makeText(this, "Data Kosong", Toast.LENGTH_LONG).show()
            }else {
                editText.setText(relsult.contents.toString())
//                var dataQr = relsult.contents.toString()
//                var bagiData =  dataQr.split(" ")

//
//                for (i  in bagiData ){
//
//                    if(editText.text.equals(i)){
//                        Toast.makeText(this,i,Toast.LENGTH_LONG).show()
//                    }
//                }

            }
        }else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
