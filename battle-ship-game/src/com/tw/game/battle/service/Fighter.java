package com.tw.game.battle.service;

import java.util.List;

/*
 * Fighter is a representation of a player in the BattleShip game. The class implements 
 * threading and fires missiles on enemy. 
*/
public class Fighter implements Runnable {

	private List<Missile> missiles;

	private MissileLauncher launcher;

	public Fighter(List<Missile> missiles) {
		this.missiles = missiles;
		this.launcher = MissileLauncher.getMissleLauncher();
	}

	@Override
	public void run() {
		while (this.missiles.size()>0) {			
			synchronized (this) {
				boolean rslt = fire();
				if (rslt) {
				} else {
					this.notifyAll();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	public boolean fire() {
		boolean hitOrMiss = false;		
		if (missiles.size() > 0) {
			hitOrMiss = launcher.fire(missiles.get(0));
			missiles.remove(0);
		}
		return hitOrMiss;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

}
