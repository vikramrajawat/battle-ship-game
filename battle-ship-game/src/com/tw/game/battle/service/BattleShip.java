package com.tw.game.battle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tw.game.battle.common.Coordinate;
import com.tw.game.battle.common.ShipType;
import com.tw.game.battle.utils.BattleShipUtils;
/*
 * BattleShip is a representation of Ship used in the battle.
 */
public final class BattleShip {

	private int height;
	private final int width;
	private Set<Coordinate> coordinates;
	private final ShipType type;
	private final int life;
	
	private BattleShip(int height, int width, Set<Coordinate> coordinates, ShipType type) {
		this.height = height;
		this.width = width;
		this.coordinates=coordinates;
		this.type = type;
		this.life = type.getValue();
	}

	/*
	 *  BattleShipBuilder is a implementation of builder patter and responsible 
	 *  for creating instance of BattleShip class. 
	 */
	public static class BattleShipBuilder {

		public static List<BattleShip> buildBattleShips(char [] shipTypes, int [] widths, int [] heights, String [] positions){
			List<BattleShip> battleShips = new ArrayList<BattleShip>();
			for(int i=0; i<shipTypes.length; i++){
				battleShips.add(new BattleShip(heights[i], widths[i], BattleShipUtils.getCoordinates(widths[i], heights[i], positions[i]), BattleShipUtils.getShipType(shipTypes[i])));
			}			
			return battleShips;
		}
		
	}

	@Override
	public String toString() {
		return "BattleShip [coordinates=" + coordinates + "\n, width=" + width
				+ ", height=" + height + ", type=" + type + ", life="
				+ life + "]\n";
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public Set<Coordinate> getCoordinates() {
		return coordinates;
	}
	public ShipType getType() {
		return type;
	}	
	public int getLife() {
		return life;
	}	
}
