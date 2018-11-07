package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.content.res.TypedArray
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import android.preference.PreferenceManager


class GameActivity : AppCompatActivity() {
    var bet2:Int = 0
    var coin2:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

//        intent.extras.getInt("kake")
//        intent.extras.getInt("coin")
        val prf = PreferenceManager.getDefaultSharedPreferences(this)
        coin2 = prf.getInt("coin",1000)
        bet2 = prf.getInt("kake",10)


        mycoin2.text = coin2.toString()
        kake1.text = bet2.toString()

        returnbotton.setOnClickListener{
            var intent:Intent=Intent(this,MainActivity::class.java)
            var prf = PreferenceManager.getDefaultSharedPreferences(this)
            prf.edit().putInt("coin",coin2).commit()
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()

        stopbotton.setOnClickListener{stopTapped(it)}
        returnbotton.setOnClickListener { onTapped(it) }





    }

    fun onTapped(view: View?){
        var intent= Intent(this,MainActivity::class.java);

        startActivity(intent);
    }

    fun stopTapped(view: View?){
        //画像の配列宣言
        var typedArray:TypedArray = this.resources.obtainTypedArray(R.array.imagearray)

        //ランダム生成
        var rand = Random();
        var x = rand.nextInt(9)
        var y = rand.nextInt(9)
        var z = rand.nextInt(9)

        //画像をランダムに出力させる
        slotbotton1.setImageResource(typedArray.getResourceId(x,0))
        slotbotton2.setImageResource(typedArray.getResourceId(y,0))
        slotbotton3.setImageResource(typedArray.getResourceId(z,0))


        if(x==y&&y==z){
            when(x){
                0->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                1->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake" ,1000)*5
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                2->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*10
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                3->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                4->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2= prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                5->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                6->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                7->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*20
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
                8->{
                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    bet2 = prf.getInt("kake",1000)*2
                    coin2 = prf.getInt("coin",1000)+bet2
                    prf.edit().putInt("coin",coin2).commit()
                }
            }

        }

                    val prf = PreferenceManager.getDefaultSharedPreferences(this)
                    prf.getInt("coin",1000)-bet2
                    prf.edit().putInt("coin",coin2).commit()




    }


    //共有プリファレンス
        fun savedate(value:Int) {
        val prf = PreferenceManager.getDefaultSharedPreferences(this);
        prf.edit().putInt("coin",value).commit()



    }

}
