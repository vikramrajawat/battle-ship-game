package com.tw.game.battle.utils;

import java.util.HashSet;
import java.util.Set;

import com.tw.game.battle.common.Coordinate;
import com.tw.game.battle.common.ShipType;

/*
 * BattleShipUtils is a utility class and provides various utility functions
 * required by the BattleShip game.
*/
public class BattleShipUtils {

	public static int getEquivInt(char c) {
		return ((int) c) - 64;
	}

	public static Coordinate getCoordinate(String pos) {
		return new Coordinate(BattleShipUtils.getEquivInt(pos.charAt(0)),
				Integer.parseInt(pos.substring(1)));
	}

	public static Set<Coordinate> getCoordinates(int width, int height,
			String position) {

		Set<Coordinate> coordinates = new HashSet<Coordinate>();
		Coordinate initCoordinate = BattleShipUtils.getCoordinate(position);
		coordinates.add(initCoordinate);
		for (int w = 1; w < width; w++) {
			Coordinate newCoordinate = new Coordinate(
					initCoordinate.getxCoordinate() + 1,
					initCoordinate.getyCoordinate() + 1 + w);

			coordinates.add(newCoordinate);
		}
		for (int h = 1; h < height; h++) {
			Coordinate newCoordinate = new Coordinate(
					initCoordinate.getxCoordinate() + 1 + h,
					initCoordinate.getyCoordinate() + 1);

			coordinates.add(newCoordinate);
		}
		return coordinates;
	}

	public static ShipType getShipType(char shipType) {
		switch (shipType) {
		case 'Q':
			return ShipType.Q;
		case 'q':
			return ShipType.Q;
		case 'P':
			return ShipType.P;
		case 'p':
			return ShipType.P;
		}
		return null;
	}
}
