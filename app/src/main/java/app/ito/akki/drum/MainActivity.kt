package app.ito.akki.drum

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    //音楽を鳴らすために必要なSoundPoolの変数
    private lateinit var mSoundPool : SoundPool
    //音楽ファイル一つ一つを区別するための変数を配列で用意する
    private lateinit var mSoundID : Array<Int?>
    private val mSoundResource = arrayOf(
            R.raw.cymbal1,
            R.raw.cymbal2,
            R.raw.cymbal3,
            R.raw.tom1,
            R.raw.tom2,
            R.raw.tom3,
            R.raw.hihat,
            R.raw.snare,
            R.raw.bass

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()

        mSoundPool = SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(mSoundResource.size)
                .build()
        //音楽ファイル一つ一つを区別するための変数の配列に数字をセットしていく
        mSoundID = arrayOfNulls(mSoundResource.size)
        //SoundIDの配列の要素数をmSoundResourceの数まで決め、SoundPoolをロードする処理
        for(i in 0..(mSoundResource.size-1)){
            //第一引数はアクティビティの情報
            //第二引数は音楽ファイルの名前
            //第三引数はデフォルト値
            mSoundID[i] = mSoundPool.load(applicationContext,mSoundResource[i],0)
        }
    }
    //アプリケーションを閉じるタイミングでSoundPoolを終了させて音楽を停止する
    override fun onDestroy() {
        super.onDestroy()

        mSoundPool.release()
    }

    fun cymbal1(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[0] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun cymbal2(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[1] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun cymbal3(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[2] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun tom1(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[3] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun tom2(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[4] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun tom3(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[5] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun hihat(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[6] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun snare(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[7] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }

    fun bass(view: View){
        if(mSoundID[0] != null){
            mSoundPool.play(mSoundID[8] as Int, 1.0F,1.0F,0,0,1.0f)
        }
    }
}