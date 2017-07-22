package com.tw.game.battle.common;

import java.io.Serializable;
import java.util.List;

public class BattleShipInputVO implements Serializable {


	private static final long serialVersionUID = -8289305113583399656L;

	private int battleAreaWidth;
	private char battleAreaHeight;
	private int noOfBattleShip;
	private char[] shipType;
	private int[] shipWidht;
	private int[] shipHeight;
	private String[][] positions;
	private List<String[]> missilesLists;
	
	public int getBattleAreaWidth() {
		return battleAreaWidth;
	}
	public void setBattleAreaWidth(int battleAreaWidth) {
		this.battleAreaWidth = battleAreaWidth;
	}
	public char getBattleAreaHeight() {
		return battleAreaHeight;
	}
	public void setBattleAreaHeight(char battleAreaHeight) {
		this.battleAreaHeight = battleAreaHeight;
	}
	public int getNoOfBattleShip() {
		return noOfBattleShip;
	}
	public void setNoOfBattleShip(int noOfBattleShip) {
		this.noOfBattleShip = noOfBattleShip;
	}
	public char[] getShipType() {
		return shipType;
	}
	public void setShipType(char[] shipType) {
		this.shipType = shipType;
	}
	public int[] getShipWidht() {
		return shipWidht;
	}
	public void setShipWidht(int[] shipWidht) {
		this.shipWidht = shipWidht;
	}
	public int[] getShipHeight() {
		return shipHeight;
	}
	public void setShipHeight(int[] shipHeight) {
		this.shipHeight = shipHeight;
	}
	public String[][] getPositions() {
		return positions;
	}
	public void setPositions(String[][] positions) {
		this.positions = positions;
	}
	public List<String[]> getMissilesLists() {
		return missilesLists;
	}
	public void setMissilesLists(List<String[]> missilesLists) {
		this.missilesLists = missilesLists;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
