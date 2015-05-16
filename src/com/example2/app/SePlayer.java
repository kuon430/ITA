package com.example2.app;

/**
 * Created by b1012215 on 2015/01/29.
 * 担当者：小島裕樹
 */
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import java.io.IOException;

public class SePlayer {
    //音声再生用クラス

    SoundPool se_pool;
    int se_id[] = new int[9];

    public SePlayer(Context context)
    {
        se_pool = new SoundPool(20,AudioManager.STREAM_MUSIC, 0);//サウンドを20こ読み取り
        try{
            AssetFileDescriptor desc[]=new AssetFileDescriptor[9];
            AssetManager asset_mng = context.getAssets();
            desc[0] = asset_mng.openFd("nb.ogg");//伸びの音声読み込み
            se_id[0] = se_pool.load(desc[0], 1);
            desc[1] = asset_mng.openFd("naruhodo.ogg");//関心（なるほど）読み込み
            se_id[1] = se_pool.load(desc[1], 1);
            desc[2] = asset_mng.openFd("yes.ogg");//同意（そうだね）読み込み
            se_id[2] = se_pool.load(desc[2], 1);

            desc[3] = asset_mng.openFd("akireta.ogg");//あきれ読み込み
            se_id[3] = se_pool.load(desc[3], 1);
            desc[4] = asset_mng.openFd("great.ogg");//驚き（すごいね）読み込み
            se_id[4] = se_pool.load(desc[4], 1);

            desc[5] = asset_mng.openFd("sleepy.ogg");//眠い読み込み
            se_id[5] = se_pool.load(desc[5], 1);

            desc[6] = asset_mng.openFd("what.ogg");//疑問（何）読み込み
            se_id[6] = se_pool.load(desc[6], 1);

            desc[7] = asset_mng.openFd("dousiyou.ogg");//どうしようか、読み込み
            se_id[7] = se_pool.load(desc[7], 1);
            desc[8] = asset_mng.openFd("goodmise.ogg");//良いお店ね（感心）読み込み
            se_id[8] = se_pool.load(desc[8], 1);

            Log.d("LordSuccess", "Good");//成功表示

        } catch(IOException e){
            Log.d("failread", "FAIL");//失敗表示
        }

    }

    public void playSe(int state)
    {

//再生可能になるまでボリュームゼロ再生
        int streamID = 0;
        do {
            //少し待ち時間を入れる
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            //ボリュームをゼロにして再生して戻り値をチェック
            streamID = se_pool.play(se_id[state-1], 0.0f, 0.0f, 1, 0, 1.0f);
        } while(streamID == 0);
       //再生可能なので再生
        if(se_id[state-1] != -1){
            se_pool.play(se_id[state-1], 10f, 10f, 0, 0, 1);
            Log.d("SOUNDNK", "play!!");
        }
        //soundPool.play(se, 1.0f, 1.0f, 1, 0, 1.0f);

    }
}