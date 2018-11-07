package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var bet:Int = 0
    var coin1:Int = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // var prf = PreferenceManager.getDefaultSharedPreferences(this)
        // prf.edit().putInt("coin",1000).commit()

        upbotton.setOnClickListener{
            bet+=10
            kake.text = bet.toString()
            coin1-=10
            mycoin2.text = (coin1).toString()
        }
        downbotton.setOnClickListener{
            bet-=10
            kake.text = bet.toString()
            coin1+=10
            mycoin2.text = (coin1).toString()

        }
        resetbotton.setOnClickListener{
            val prf = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = prf.edit()
            editor.clear().apply()

            bet = 0
            coin1 = 1000
            mycoin2.text = coin1.toString()
            kake.text = bet.toString()
        }
        startbotton.setOnClickListener{
            var intent:Intent=Intent(this,GameActivity::class.java)
//            intent.putExtra("coin",coin1)
//            intent.putExtra("kake",bet)

            val prf = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = prf.edit()
            editor.putInt("coin",coin1).putInt("kake",bet).apply()
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        /*
        var prf = PreferenceManager.getDefaultSharedPreferences(this)
        var mycoins = prf.getInt("coin",1000)
        mycoin1.text = mycoins.toString()
        */
        val prf = PreferenceManager.getDefaultSharedPreferences(this)
        coin1 = prf.getInt("coin",1000)
        mycoin2.text = coin1.toString()

        /*
        startbotton.setOnClickListener { onTapped(it) }
        */


    }

    fun onTapped(view:View?){
        var intent= Intent(this,GameActivity::class.java);

        startActivity(intent);
    }

}
