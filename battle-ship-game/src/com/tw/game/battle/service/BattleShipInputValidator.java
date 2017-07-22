package com.tw.game.battle.service;

import com.tw.game.battle.common.BattleShipInputVO;
import com.tw.game.battle.common.ShipType;
import com.tw.game.battle.exceptions.OutOfRangeValueException;
import com.tw.game.battle.utils.BattleShipUtils;
/*
 * BattleShipInputValidator class is responsible for validating the input and
 * it will throw exception in case found input that does not comply with supplied
 * validation rule 
 */
public class BattleShipInputValidator {
	
	public static void validate(BattleShipInputVO input){
		
		if (input.getBattleAreaWidth() <= 1 && input.getBattleAreaWidth() >= 9) {
			throw new OutOfRangeValueException(
					"Invalid Width! Try Width from 1 to 9");
		}
		
		if (BattleShipUtils.getEquivInt(input.getBattleAreaHeight()) <= 1
				&& BattleShipUtils.getEquivInt(input.getBattleAreaHeight()) >= 26) {
			throw new OutOfRangeValueException(
					"Invalid Height! Try Height from A to Z");
		}
		
		if (input.getNoOfBattleShip() < 0
				&& input.getNoOfBattleShip() > input.getBattleAreaWidth()
						* BattleShipUtils.getEquivInt(input.getBattleAreaHeight())) {
			throw new OutOfRangeValueException(
					"No of Battle Ships is out of range");
		}


		for (int i = 0; i < input.getNoOfBattleShip(); i++) {
			if (input.getShipWidht()[0] < 1 && input.getShipWidht()[0] > input.getBattleAreaWidth()) {
				throw new OutOfRangeValueException(
						"Invalid Ship Width! Try Width from 1 to "
								+ input.getBattleAreaWidth());
			}
			if (input.getShipHeight()[0] < 1 && input.getShipHeight()[0] > input.getBattleAreaHeight()) {
				throw new OutOfRangeValueException(
						"Invalid Ship Height! Try Height from 1 to "
								+ input.getBattleAreaHeight());
			}

			char c = input.getShipType()[i];
			ShipType shipType = BattleShipUtils.getShipType(c);
			if (shipType == null) {
				throw new OutOfRangeValueException(
						"Invalid Ship Type! Try Q or P");
			}

			for (int p = 0; p < input.getPositions()[i].length; p++) {
				int xCoordinate = BattleShipUtils.getEquivInt(input.getPositions()[i][p]
						.charAt(0));
				int yCoordinate = Integer
						.parseInt(input.getPositions()[i][p].substring(1));
				if (xCoordinate < 0 && xCoordinate > input.getBattleAreaWidth() - 1) {
					throw new OutOfRangeValueException(
							"Invalid X Coordinate! Try from range 1 to "
									+ input.getBattleAreaWidth());
				}
				if (yCoordinate < 0 && yCoordinate > input.getBattleAreaHeight() - 1) {
					throw new OutOfRangeValueException(
							"Invalid Y Coordinate! Try from range 1 to "
									+ input.getBattleAreaHeight());
				}
			}
		}		

	}
}
