package com.tw.game.battle.common;

/* 
 * ShipType enum is types of ships 
 */
public enum ShipType {

	Q(2), P(1);

	public int value;

	private ShipType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
