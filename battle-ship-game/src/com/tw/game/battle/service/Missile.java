package com.tw.game.battle.service;

import java.util.ArrayList;
import java.util.List;

import com.tw.game.battle.common.Coordinate;
import com.tw.game.battle.utils.BattleShipUtils;

/*
 * Missile class is representation of missile thats used in battle. The class has feature 
 * to target enemy's battle field on a specific position using target coordinates.
 * This missile is launched by a launcher.
*/
public class Missile {
	
	private BattleField targetBattleField;
	private Coordinate targetCoordinate;
	
	private  Missile(BattleField targetBattleField, Coordinate targetCoordinate) {
		this.targetBattleField = targetBattleField;
		this.targetCoordinate = targetCoordinate;
	}
	
	/*
	 * MissileBuilder is an implementation of builder pattern and used to instantiates missile.
	 */
	public static class MissileBuilder {

		public static List<Missile> buildMissiles( BattleField targetBattleField, String [] targetPositions){		
			List<Missile> missiles = new ArrayList<Missile>();
			for(String target : targetPositions){
				missiles.add(new Missile(targetBattleField, BattleShipUtils.getCoordinate(target)));
			}			
			return missiles;
		}
	}

	
	@Override
	public String toString() {
		return "Missile [targetCoordinate=" + targetCoordinate + "]";
	}
	public BattleField getTargetBattleField() {
		return targetBattleField;
	}
	public void setTargetBattleField(BattleField targetBattleField) {
		this.targetBattleField = targetBattleField;
	}
	public Coordinate getTargetCoordinate() {
		return targetCoordinate;
	}
	public void setTargetCoordinate(Coordinate targetCoordinate) {
		this.targetCoordinate = targetCoordinate;
	}

}
