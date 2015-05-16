package com.example2.app

import _root_.projectkyoto.jme3.mmd.PMDNode
import android.util.Log
import android.view.MotionEvent
//import com.example2.app.Sample
import com.jme3.app.SimpleApplication
import com.jme3.audio.AudioNode
import com.jme3.math.{ColorRGBA, Vector3f}
import com.jme3.scene.Geometry
import com.jme3.audio
import projectkyoto.jme3.mmd._
import projectkyoto.mmd.file.VMDFile
import projectkyoto.jme3.mmd.vmd.VMDControl

import com.jme3.light.{PointLight, AmbientLight, DirectionalLight}
import com.jme3.texture.plugins.AndroidImageLoader


/**
 * Created with IntelliJ IDEA.
 * User: kobayasi
 * Date: 13/09/03
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 * 担当者：小島裕樹
 */


class MainApp extends SimpleApplication {
  var flag=false;//変更部位


    def simpleInitApp {
      Sample.debag=1//変更部位
     assetManager.registerLoader(classOf[PMDLoaderGLSLSkinning2], "pmd")
      assetManager.registerLoader(classOf[VMDLoader], "vmd")
     assetManager.registerLoader(classOf[AndroidImageLoader],"sph","spa")
      Sample.debag=1//変更部位
      flyCam.setMoveSpeed(50)//変更部位
      flyCam.setDragToRotate(true)
      flyCam.setEnabled(false)//変更部位



      val pmdNode: PMDNode = assetManager.loadModel("/mdl/LatstylemikuVer2.31/LatstylemikuVer2.31_Normal.pmd").asInstanceOf[PMDNode]
      var vmd:VMDFile= assetManager.loadAsset("/wait.vmd").asInstanceOf[VMDFile]

  val vmd2:VMDFile=assetManager.loadAsset("/standup.vmd").asInstanceOf[VMDFile]
  val vmd3:VMDFile=assetManager.loadAsset("/smile.vmd").asInstanceOf[VMDFile]
      val vmd4:VMDFile=assetManager.loadAsset("/drink.vmd").asInstanceOf[VMDFile]

      val vmd5:VMDFile=assetManager.loadAsset("/jito.vmd").asInstanceOf[VMDFile]//じとめ
      val vmd6:VMDFile=assetManager.loadAsset("/hand.vmd").asInstanceOf[VMDFile]//口にて
      val vmd7:VMDFile=assetManager.loadAsset("/kasige.vmd").asInstanceOf[VMDFile]//kubikasige
      val vmd8:VMDFile=assetManager.loadAsset("/grand.vmd").asInstanceOf[VMDFile]//miwatasu
      val vmd9:VMDFile=assetManager.loadAsset("/surprise.vmd").asInstanceOf[VMDFile]//odoroki

     // Sample.debag=2
      //モーションをノード（ツリー）に追加
      vmdControl = new VMDControl(pmdNode, vmd)
      vmdControl2=new VMDControl(pmdNode,vmd2)
      vmdControl3=new VMDControl(pmdNode,vmd3)
      vmdControl4=new VMDControl(pmdNode,vmd4)

      vmdControl5=new VMDControl(pmdNode,vmd5)
      vmdControl6=new VMDControl(pmdNode,vmd6)
      vmdControl7=new VMDControl(pmdNode,vmd7)
      vmdControl8=new VMDControl(pmdNode,vmd8)
      vmdControl9=new VMDControl(pmdNode,vmd9)

      Sample.debag=3
     pmdNode.setLocalTranslation(0f,0f,20f)
      //コントロールを追加
      pmdNode.addControl(vmdControl)
      pmdNode.addControl(vmdControl2)
      pmdNode.addControl(vmdControl3)
      pmdNode.addControl(vmdControl4)

      pmdNode.addControl(vmdControl5)
      pmdNode.addControl(vmdControl6)
      pmdNode.addControl(vmdControl7)
      pmdNode.addControl(vmdControl8)
      pmdNode.addControl(vmdControl9)

      pmdNode.addControl(new UpdateControl(pmdNode))

//コントロールのはじめの位置初期化
    vmdControl.setFrameNo(0)
    vmdControl.setPause(true)
    vmdControl2.setFrameNo(0)
    vmdControl2.setPause(true)
    vmdControl3.setFrameNo(0)
    vmdControl3.setPause(true)
    vmdControl4.setFrameNo(0)
    vmdControl4.setPause(true)
      vmdControl5.setFrameNo(0)
      vmdControl5.setPause(true)
      vmdControl6.setFrameNo(0)
      vmdControl6.setPause(true)
      vmdControl7.setFrameNo(0)
      vmdControl7.setPause(true)
      vmdControl8.setFrameNo(0)
      vmdControl8.setPause(true)
      vmdControl9.setFrameNo(0)
      vmdControl9.setPause(true)

   // voice.setLooping(false)
  // voice.setVolume(1)


   rootNode.attachChild(pmdNode)

    val dl: DirectionalLight = new DirectionalLight//ライト設置
    dl.setDirection(new Vector3f(1, 0, -5).normalizeLocal)
    dl.setColor(ColorRGBA.White.mult(0.5f))
    rootNode.addLight(dl)
    val al: AmbientLight = new AmbientLight
    al.setColor(ColorRGBA.White.mult(1.0f))
    rootNode.addLight(al)
    val cartoonEdgeProcess: CartoonEdgeProcessor = new CartoonEdgeProcessor
    viewPort.addProcessor(cartoonEdgeProcess)
    cam.setLocation(new Vector3f(0, 10, 40))
  }


  override def simpleUpdate(tpf: Float) {
    time += tpf
    //モーションを繰り返し再生するようにする
if(vmdControl2.getFrameNo()>=vmdControl2.getLastFrameNo()){//最終フレーム到達したら
  vmdControl2.setFrameNo(0)//はじめに戻る
  //Sample.c=false
}
    if(vmdControl3.getFrameNo()>=vmdControl3.getLastFrameNo()){
      vmdControl3.setFrameNo(0)
      //Sample.c=false
    }
    if(vmdControl4.getFrameNo()>=vmdControl4.getLastFrameNo()){
      vmdControl4.setFrameNo(0)
      //Sample.c=false
    }


    if(vmdControl5.getFrameNo()>=vmdControl5.getLastFrameNo()){
      vmdControl5.setFrameNo(0)
      //Sample.c=false
    }
    if(vmdControl6.getFrameNo()>=vmdControl6.getLastFrameNo()){
      vmdControl6.setFrameNo(0)
      //Sample.c=false
    }
    if(vmdControl7.getFrameNo()>=vmdControl7.getLastFrameNo()){
      vmdControl7.setFrameNo(0)
      //Sample.c=false
    }
    if(vmdControl8.getFrameNo()>=vmdControl8.getLastFrameNo()){
      vmdControl8.setFrameNo(0)
      //Sample.c=false
    }
    if(vmdControl9.getFrameNo()>=vmdControl9.getLastFrameNo()){
      vmdControl9.setFrameNo(0)
      //Sample.c=false
    }

//起動から15たったらスタート
    if (time>15) {
      if (vmdControl != null) {
        vmdControl.setPause(false)
        //vmdControl2.setFrameNo(0)
      }
    }
    //Sample.c match {
    //  case 4 =>
//対応モーション再生
    if(Sample.c==4) {
      if (vmdControl4 != null) {
        vmdControl4.setPause(false)
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)

        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)

      }
    }else if(Sample.c==2){
     // case 2 =>
      if (vmdControl2 != null) {
        vmdControl2.setPause(false)
        vmdControl.setPause(true)
        vmdControl4.setPause(true)
        vmdControl3.setPause(true)
        vmdControl5.setPause(true)

        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
        // case 0 =>
      }
    }else if(Sample.c==0){
      if (vmdControl != null) {
        vmdControl.setPause(false)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
      }
      }else if(Sample.c==5){
        //case 5 =>
      if (vmdControl5 != null) {
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(false)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
      }
      }else if(Sample.c==6){
        // case 6 =>
      if (vmdControl6 != null) {
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(false)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
      }
        //case 7 =>
      }else if(Sample.c==7){
      if (vmdControl7 != null) {
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(false)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
      }
        //case 8 =>
      }else if(Sample.c==8){
      if (vmdControl8 != null) {
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(false)
        vmdControl9.setPause(true)
      }
      }else if(Sample.c==9) {
        // case 9 =>
      if (vmdControl9 != null) {
        vmdControl.setPause(true)
        vmdControl2.setPause(true)
        vmdControl3.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(false)
      }
      }else{
        // case _ =>
      if (vmdControl3 != null) {
        vmdControl3.setPause(false)
        vmdControl2.setPause(true)
        vmdControl.setPause(true)
        vmdControl4.setPause(true)
        vmdControl5.setPause(true)
        vmdControl6.setPause(true)
        vmdControl7.setPause(true)
        vmdControl8.setPause(true)
        vmdControl9.setPause(true)
      }
      }

  }

//プライベート変数設置
  private var pl: PointLight = null
  private var lightMdl: Geometry = null
  private var vmdControl: VMDControl = null
  private var vmdControl2:VMDControl = null
  private var vmdControl3:VMDControl = null
  private var vmdControl4:VMDControl = null
  private var vmdControl6:VMDControl = null
  private var vmdControl7:VMDControl = null
  private var vmdControl8:VMDControl = null
  private var vmdControl9:VMDControl = null
  private var vmdControl5:VMDControl = null


  private var time: Float = 0
 // private var voice:AudioNode=null


}
