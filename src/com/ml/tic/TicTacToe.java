package com.ml.tic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
static ArrayList<Integer> playerPosotion = new ArrayList<Integer>() ;
static ArrayList<Integer> cpuPossition = new ArrayList<Integer>() ;

/**
 * 
 * Author =  @Vasu 
 */
	public static void main(String[] args) {
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },

		};
		
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the placement from 1-9");
			int pos = sc.nextInt();
			while(playerPosotion.contains(pos) || cpuPossition.contains(pos)) {
				System.out.println("Possition Already taken!");
				pos = sc.nextInt();
			}
			placement(gameBoard, pos, "player");
			String result = Winning();
			 if(result.length()>0) {
				 System.out.println(result);
				 break;
			 }
			Random rand = new Random();
			int pos1 = rand.nextInt(9) + 1;
			while(playerPosotion.contains(pos1) || cpuPossition.contains(pos1)) {
				pos1 = rand.nextInt(9) + 1;
			}
			placement(gameBoard, pos1, "cpu");
			frame(gameBoard);
			 result = Winning();
			 if(result.length()>0) {
				 System.out.println(result);
				 break;
			 }
			

		}
	}

	public static void frame(char[][] gameBoard) {

		for (char[] c : gameBoard) {
			for (char cd : c) {
				System.out.print(cd);
			}
			System.out.println();
		}
	}

	public static void placement(char[][] gameBoard, int pos, String user) {
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPosotion.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPossition.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			System.out.println("oops! Wrong Number..number should be from 1-9 only!");
			break;

		}
	}
	
	public static String Winning() {
		List firstrow = Arrays.asList(1,2,3);
		List middlerow = Arrays.asList(4,5,6);
		List lastrow = Arrays.asList(7,8,9);
		List firstcol = Arrays.asList(1,4,7);
		List secondcol = Arrays.asList(2,5,8);
		List thirdcol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List> winingcondition = new ArrayList<List>();
		winingcondition.add(firstrow);
		winingcondition.add(middlerow);
		winingcondition.add(lastrow);
		winingcondition.add(firstcol);
		winingcondition.add(secondcol);
		winingcondition.add(thirdcol);
		winingcondition.add(cross1);
		winingcondition.add(cross2);
		
		for (List l : winingcondition) {
			if(playerPosotion.containsAll(l)) {
				return "Congrats!! you Won!";
			}
			else if(cpuPossition.containsAll(l)) {
				return "CPU won! Better luck next time :(";
			}
			else if (playerPosotion.size() + cpuPossition.size() == 9) {
				return "CAT!" ;
			}
		}
		return "" ;
		
		
	}

}
