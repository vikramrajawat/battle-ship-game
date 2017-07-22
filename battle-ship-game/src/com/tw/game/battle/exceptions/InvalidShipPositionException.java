package com.tw.game.battle.exceptions;
/* 
 * InvalidShipPositionException is thrown in case of ship position 
 * is not in accordance with system.
 */
public class InvalidShipPositionException extends RuntimeException{
	
	private static final long serialVersionUID = -6148703723763483799L;

	public InvalidShipPositionException(String msg){
		super(msg);
	}
}
