package com.tw.game.battle.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tw.game.battle.common.BattleShipInputVO;
/*
 * BattleShipInputProcessor class is responsible for processing input
 * to be used by the game. It reads the input from a text file and 
 * Prepares BattleShipInputVO value object.
*/
public class BattleShipInputProcessor {
	
	/*
	 * process method prepare the value object from the input
	 */
	public BattleShipInputVO process() {
		
		StringBuffer sb = readFile("resources/input.txt");
		BattleShipInputVO inputVo = new BattleShipInputVO();
		
		String[] input = sb.toString().split("\n");

		inputVo.setBattleAreaWidth(Integer.parseInt(input[0].substring(0, 1)));
		inputVo.setBattleAreaHeight(input[0].charAt(2));
		inputVo.setNoOfBattleShip(Integer.parseInt(input[1]));
		
		char[] shipType = new char[inputVo.getNoOfBattleShip()];
		int[] shipWidht = new int[inputVo.getNoOfBattleShip()];
		int[] shipHeight = new int[inputVo.getNoOfBattleShip()];
		List<String[]> missilesLists = new ArrayList<String[]>();
		String[][] positions = new String[inputVo.getNoOfBattleShip()][];
		
		List<String> ships = new ArrayList<String>();

		for (int i = 0; i < inputVo.getNoOfBattleShip(); i++) {
			String[] shipDetails = input[2 + i].split(" ");
			ships.add(input[2 + i]);
			shipType[i] = shipDetails[0].charAt(0);
			shipWidht[i] = Integer.parseInt(shipDetails[1]);
			shipHeight[i] = Integer.parseInt(shipDetails[2]);
			String[] missiles = input[4 + i].split(" ");
			missilesLists.add(missiles);
		}

		positions = getShipPositions(ships);
		
		inputVo.setShipType(shipType);
		inputVo.setShipWidht(shipWidht);
		inputVo.setShipHeight(shipHeight);		
		inputVo.setMissilesLists(missilesLists);
		inputVo.setPositions(positions);
		
		return inputVo;
	}

	/* reasFile method reads the input from the file and give a 
	 * StringBuffer object containing lines in the given file
	 */
	private StringBuffer readFile(String filePath){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(fis);
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine() + "\n");
		}
		sc.close();
		return sb;
	}
	
	private String[][] getShipPositions(List<String> input) {
		String[][] matrix = new String[input.size()][2];
		String[][] transposeMatrix = new String[input.size()][2];
		for (int a = 0; a < input.size(); a++) {

			String[] record = input.get(a).split(" ");

			for (int i = 3; i < record.length; i++) {
				String s = record[i].trim();
				matrix[a][i - 3] = s;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				transposeMatrix[i][j] = matrix[j][i];
			}
		}

		return transposeMatrix;
	}
}
