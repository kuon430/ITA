package com.example2.app

import android.app.Activity
import android.os.Bundle
import android.view.{MotionEvent, View}
import android.view.View.OnClickListener
import android.util.Log
import android.content.Intent
import android.widget.Button
import com.example2.app.Sample
import com.jme3.app.AndroidHarness
import com.jme3.system.android.AndroidConfigChooser.ConfigType
import android.content.pm.ActivityInfo
import projectkyoto.jme3.mmd.{VMDLoader, PMDLoaderGLSLSkinning2}
import com.jme3.texture.plugins.AndroidImageLoader
import android.media.{ToneGenerator, MediaPlayer, SoundPool, AudioManager}
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.app.Activity
import android.os.Bundle
import android.view.View
//import android.view.View.OnClickListener
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.speech.RecognizerIntent
import scala.util.Random


object MainActivity {
  System.loadLibrary("bulletjme");
  def loadLibrary() {
  }
}

//担当者：小島裕樹,共同開発者。　共同開発者担当部は2箇所、「共同開発者担当」から「共同開発者担当ここまで」です。
// その他は小島裕樹担当
//writer HirokiKojima,and,team member （menmer write is [writer: member start] to [writer: member end]
//other is wrote by Hiroki Kojima


class MainActivity extends AndroidHarness   {

  appClass = "com.example2.app.MainApp";
  eglConfigType = ConfigType.BEST
  eglConfigVerboseLogging = false
  //screenOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
  screenFullScreen = false
  screenShowTitle = true
 // var ra=scala.util.Random
//var d:Int=0
 // var sp:SoundPool
 // var mySoundId:Array[Int]
//  var SoundId= new Array[Int](5)
// val m_mediaPlayer:MediaPlayer
  //var tts: TextToSpeech

  val REQUEST_CODE = 0
  val RESULT_OK = -1

  MainActivity.loadLibrary()
  var flag=false
  /** Called when the activity is first created. */
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)


    setContentView(view);

  }
//defalt end
  protected override def onDestroy() {
    super.onDestroy();

  }


  override def onTouchEvent( event:MotionEvent):Boolean = {
   //
    if (Sample.b == false) {
      Sample.b = true;
    }
    Sample.c=0
    //共同開発者担当
    //writer: member start
  try {
    val intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
    // free-form speech recognition.
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "音声を出力します")
    // Intent
    startActivityForResult(intent, REQUEST_CODE)
  } catch {
    // Activity縺瑚ｦ九▽縺九ｉ縺ｪ縺九▲縺滓凾縺ｮ繧ｨ繝ｩ繝ｼ蜃ｦ逅�
    case e: ActivityNotFoundException => Toast.makeText(MainActivity.this,
      "Activityがない", Toast.LENGTH_LONG).show()
  }
    //共同開発者担当ここまで
    //writer: member end

Sample.state=Sample.state+1;
    if(Sample.state!=1) {
      //se.playSe(Sample.state);
    }

    return true

  }
  //共同開発者担当
  //writer menmer
  override def onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

    if ((REQUEST_CODE == requestCode) && (RESULT_OK == resultCode)) {
      // ArrayList
      var results: java.util.ArrayList[String] = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

      // ArrayList
      val stringBuffer = new StringBuffer()
      for (i<- 0 until results.size()) {
        stringBuffer.append(results.get(i))
      }
      //共同開発者担当ここまで
      //writer menmer end
      var se:SePlayer= new SePlayer(this);
      var spdata:String= null
spdata=stringBuffer.toString()
if(stringBuffer.toString().contains("帰")||spdata.contains("エロ")||spdata.contains("えろ")||spdata.contains("ロッカー")){//（帰ろうのような言葉に反応）読み込んだ文字列に特定ワード含まれていたならば反応
  se.playSe(1)//音声１で再生
  Sample.b=false
  Sample.c=2//動作２
}else if(spdata.contains("飲")||spdata.contains("あん")){
  Sample.b=false
  Sample.c=4
}else if(spdata.contains("ミク")||spdata.contains("肉")||spdata.contains("goo")){
  Sample.b=false
  Sample.c=7
 se.playSe(7)
}else if(spdata.contains("店")){
  Sample.b=false
  Sample.c=8
  se.playSe(9)
}else if (spdata.contains("どう")||spdata.contains("思う")) {
  Sample.c = 6
  se.playSe(8)
  Sample.b=false
}else{
  //ra=Random.nextInt(2)
 // var r=Random.nextInt(2)
 // val ra=4
  //d=ra.nextInt(4)
  Sample.b=false
 // ra match {
  if(spdata.contains("ない")||spdata.contains("not")||spdata.contains("だめ")||spdata.contains("駄目")||spdata.contains("難")||spdata.contains("ダメ")) {
   // case 0 =>
      Sample.c = 5
    se.playSe(4)
  }else if(spdata.contains("だよ")||spdata.contains("だって")) {
    //case 2=>
    Sample.c = 9
    se.playSe(2)
  }else{
   // case _=>
      Sample.c=3
      se.playSe(3)
  }


 // Sample.c=3
}
     // Toast.makeText(this, stringBuffer.toString(), Toast.LENGTH_LONG).show()
    }
    //共同開発者担当
    super.onActivityResult(requestCode, resultCode, data)
  }










}
