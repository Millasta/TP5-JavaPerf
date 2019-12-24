package org.polytechtours.javaperformance.tp.paintingants;

/*
 * CColonie.java
 *
 * Created on 11 avril 2007, 16:35
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
import java.util.Vector;

public class CColonie {

  private Boolean mContinue = Boolean.TRUE;
  private Vector<CFourmi> mColonie;
  private Vector<Thread> mThreadsColonie;
  private PaintingAnts mApplis;

  /** Creates a new instance of CColonie */
  public CColonie(Vector<CFourmi> pColonie, PaintingAnts pApplis) {
    mColonie = pColonie;
    mApplis = pApplis;
    mThreadsColonie = new Vector<Thread>();
  }

  public void pleaseStop() {
	  for (int i = 0; i < mThreadsColonie.size(); i++) {
		  mColonie.get(i).pleaseStop();
		  try {
		      mThreadsColonie.get(i).join();
		    } catch (Exception e) {
		    }
	  }
  }

  public void start() {
	  for (int i = 0; i < mColonie.size(); i++) {
		  Thread newThread = new Thread(mColonie.get(i));
		  newThread.start();
		  mThreadsColonie.add(newThread);
	  }
  }
  
  /*@Override
  public void run() {
    while (mContinue == true) {
      if (!mApplis.getPause()) {
        for (int i = 0; i < mColonie.size(); i++) {
          mColonie.get(i).deplacer();
          mApplis.compteur();
        }
      } else {
        /*
         * try { Thread.sleep(100); } catch (InterruptedException e) { break; }
         
      }
    }
  }*/

}