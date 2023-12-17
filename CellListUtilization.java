/**
 * Full Name: Ilyad Hemmatjoo
 * ID: 40205441
 * Course: COMP249
 * Assignment: Assignment 3
 * Due Date: December 2, 2023
 */

// -----------------------------------------------------
// Assignment (3)
// Class: (1)
// Written by: (Ilyad Hemmatjoo ---- ID: 40205441)
// -----------------------------------------------------

//This program creates a linked list using the text file that contains several cell phones with different information about them such as year , brand  etc. . It has several available methods can be utilized such as a method to find a specific node
// , a method to add to list, a method to check if a node exists , a method to delete a specific node in a specific index or a method to add a node to a specific index
// a method to replace a node with another node.


package CellPhoneRecords;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

import CellPhoneRecords.CellList.CellNode;

public class CellListUtilization {
	
	

	public static void main(String[] args) {
		
		CellList cplst1 = new CellList();
		CellList cplst2 = new CellList();
		
//		-------------------Reading the file
		Scanner sc = null;
		try { 
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			while(sc.hasNextLine()) {
				String[] splitted = sc.nextLine().split("\\s+");
				
				long serialNum = Long.parseLong(splitted[0]);
				String brand = splitted[1];
				double price = Double.parseDouble(splitted[2]);
				int year = Integer.parseInt(splitted[3]);
				
				cellPhone cp = new  cellPhone(serialNum, brand,year,price);
				if(!cplst1.contains(cp.getSerialNum())) {
					cplst1.add(cp);
				}
				
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found ");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		cplst1.showContents();
		
//		------------------Menu
		Scanner sc1 = new Scanner(System.in);
		System.out.println("\nWelcome to Linked List system!\n\nPlease Enter a serial Number to serach for: ");
		try {
			long serialNum = sc1.nextLong();
			if(cplst1.contains(serialNum)) {
				CellNode cn = cplst1.find(serialNum);
				System.out.println(cn.getCellPhone());
			}else {
				System.out.println("Cell phone not found with the given serial Number! \n\nThank you for using our Linked List system!");
			}
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		System.out.println("\n\n");
		
//		------------------------------Testing methods

//		cellPhone c = new cellPhone(111111, "Apple", 2000, 34.33);
		

//		try {
//			cplst1.insertAtIndex(c, 3);
//			cplst1.deleteFromIndex(2);
//			cplst1.deleteFromStart();
//			cplst1.replaceAtIndex(c,3);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		cplst1.showContents();
		
		
		System.out.println("\n\n");
		
//		----------------------------------------
		System.out.println("Cloning linked list");
		cplst2 = cplst1.clone();
		System.out.println("cloned list:");
		
		cplst2.showContents();
		
//		---------------------------------------
		System.out.println( cplst1.equals(cplst2));

	}

}
