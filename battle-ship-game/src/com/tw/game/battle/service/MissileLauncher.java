package com.tw.game.battle.service;

import java.util.List;

import com.tw.game.battle.common.Coordinate;
/*
 * MissileLauncher is a representation of missile launcher which can be used for 
 * launching missiles on enemy.
*/
public class MissileLauncher {

	private static MissileLauncher launcher = new MissileLauncher();

	private MissileLauncher() {
	}

	public static MissileLauncher getMissleLauncher() {
		return launcher;
	}

	/*
	 * the method fire triggers the missile on the battle field
	 */
	public boolean fire(Missile missile) {
		BattleField battleField = missile.getTargetBattleField();
		List<Coordinate> occupiedCoordinates = battleField
				.getOccupiedCoordinates();
		boolean rslt = occupiedCoordinates.contains(missile
				.getTargetCoordinate());
		int life = 0;
		if (rslt) {
			life = battleField.getField()[missile.getTargetCoordinate()
					.getxCoordinate()][missile.getTargetCoordinate()
					.getyCoordinate()];
			life--;
			if (life == 0) {
				occupiedCoordinates.remove(missile.getTargetCoordinate());
			}
			battleField.getField()[missile.getTargetCoordinate()
					.getxCoordinate()][missile.getTargetCoordinate()
					.getyCoordinate()] = life;
		}
		return rslt;
	}
}
