package com.tw.game.battle.exceptions;

/* 
 * OutOfRangeValueException is thrown in case of any input/value 
 * is not in the required range.
 */
public class OutOfRangeValueException extends RuntimeException{

	private static final long serialVersionUID = 3222277524795142793L;

	public OutOfRangeValueException(String msg){
		super(msg);
	}
}
