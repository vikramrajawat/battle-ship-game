package com.tw.game.battle.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tw.game.battle.common.Coordinate;
import com.tw.game.battle.exceptions.InvalidShipPositionException;
import com.tw.game.battle.exceptions.OutOfRangeValueException;
import com.tw.game.battle.utils.BattleShipUtils;
/* 
 * BattleField class is representation of Battle Area. This enables to place various ships on the field. 
 */
public class BattleField {

	private int[][] field;

	private List<Coordinate> occupiedCoordinates;

	private BattleField(int[][] field) {
		this.field = field;
		this.occupiedCoordinates = new ArrayList<Coordinate>();
	}

	/*
	 * placeShips() method responsible for placing multiple ships on the battle field
	 */
	public BattleField placeShips(List<BattleShip> ships) throws InvalidShipPositionException {
		
		List<Coordinate> tempOccupiedCoordinates = null;
		boolean isShipOverlappng = false;		
		for(BattleShip ship:ships){
			if(occupiedCoordinates.size()!=0){
				tempOccupiedCoordinates = new ArrayList<Coordinate>(
						occupiedCoordinates);
				isShipOverlappng = tempOccupiedCoordinates.removeAll(ship.getCoordinates());			
				if (isShipOverlappng) {
					throw new InvalidShipPositionException("The Ship position is overlapping");
				}
			}
			
			Iterator<Coordinate> coorinates = ship.getCoordinates().iterator();
			
			while(coorinates.hasNext()){				
				Coordinate coordinate = coorinates.next();				
				field[coordinate.getxCoordinate()][coordinate.getyCoordinate()] = ship.getLife();
			}
			occupiedCoordinates.addAll(ship.getCoordinates());
		}	
		return this;
	}

	/*
	 * BattleFieldBuilder is a implementation of builder pattern which is responsible for creation instance of BattleField class.
	 */
	public static class BattleFieldBuilder {
		
		public static BattleField buildBattleField(final int width, final char height) throws OutOfRangeValueException{
			
			if(!(width>=1 && width<=9)){
				throw new OutOfRangeValueException("Invalid Width! Try Width in range of 1 to 9");
			}
			
			if(BattleShipUtils.getEquivInt(height)<=1 &&BattleShipUtils.getEquivInt(height)>=26){
				throw new OutOfRangeValueException("Invalid Height! Try Height in range of A to Z");
			}
			
			int [][] fieldMatrix = new int[width][BattleShipUtils.getEquivInt(height)];
			
			BattleField battleField = new BattleField(fieldMatrix);
			
			return battleField;
		}

	}

	public int[][] getField() {
		return field;
	}

	public List<Coordinate> getOccupiedCoordinates() {
		return occupiedCoordinates;
	}

}
