package com.tw.game.battle.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tw.game.battle.common.BattleShipInputVO;
import com.tw.game.battle.service.BattleField;
import com.tw.game.battle.service.BattleShip;
import com.tw.game.battle.service.BattleShipInputProcessor;
import com.tw.game.battle.service.BattleShipInputValidator;
import com.tw.game.battle.service.Fighter;
import com.tw.game.battle.service.Missile;

/*
 * BattleShipMain class is entry point of the BattleShip Game. This class is 
 * responsible for starting the game and showing results the results.
 */
public class BattleShipMain {

	private static final int NO_OF_PLAYER = 2;

	public static void main(String[] args) {

		System.out.println("Welcome to Battle Ship! Initiating the game!");
		
		BattleShipInputVO input = new BattleShipInputProcessor().process();

		BattleShipInputValidator.validate(input);

		BattleField[] battleFiellds = new BattleField[NO_OF_PLAYER];
		for (int i = 0, j = NO_OF_PLAYER - 1; i < NO_OF_PLAYER; i++, j--) {
			battleFiellds[j] = BattleField.BattleFieldBuilder.buildBattleField(
					input.getBattleAreaWidth(), input.getBattleAreaHeight())
					.placeShips(
							BattleShip.BattleShipBuilder.buildBattleShips(
									input.getShipType(), input.getShipWidht(),
									input.getShipHeight(),
									input.getPositions()[i]));
		}

		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < NO_OF_PLAYER; i++) {
			Thread t = new Thread(new Fighter(
					Missile.MissileBuilder.buildMissiles(battleFiellds[i],
							input.getMissilesLists().get(i))), "Fighter-"
					+ (i + 1));
			threads.add(t);
			t.start();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		Map<Integer, Boolean> shipLives = new HashMap<Integer, Boolean>();
		for (int i = battleFiellds.length - 1; i >= 0; i--) {
			int[][] battleFieldMatrix = battleFiellds[i].getField();

			for (int r = 0; r < battleFieldMatrix.length; r++) {
				for (int c = 0; c < battleFieldMatrix.length; c++) {
					if (battleFieldMatrix[r][c] > 0) {
						shipLives.put(battleFiellds.length - (i), true);
					}
				}
			}
		}
		
		int totalLive = 0;
		Iterator<Boolean> itr = shipLives.values().iterator();
		while (itr.hasNext()) {
			if (itr.next() == true) {
				totalLive++;
			}
		}

		if (totalLive == battleFiellds.length) {
			System.out.println("Peace Declared!");
		} else {
			for (Entry<Integer, Boolean> entry : shipLives.entrySet()) {
				if (entry.getValue() == true) {
					System.out.println("Fighter-" + entry.getKey() + " Won!");
				}
			}
		}
	}
}
