/**
 * Full Name: Ilyad Hemmatjoo
 * ID: 40205441
 * Course: COMP249
 * Assignment: Assignment 3
 * Due Date: December 2, 2023
 */

// -----------------------------------------------------
// Assignment (3)
// Class: (3)
// Written by: (Ilyad Hemmatjoo ---- ID: 40205441)
// -----------------------------------------------------

package CellPhoneRecords;

import java.util.*;



public class CellList implements PubliclyCloneable {
	
	public static class CellNode {
		private cellPhone cellPhone;
		private CellNode next; 
		
		public CellNode() {
			this.cellPhone = null;
			this.next = null;
		}
		public CellNode(cellPhone c1 , CellNode next) {
			cellPhone = c1;
			this.next  = next;
		}
		
		//Copy constructor
		public CellNode(CellNode otherNode) {
		    this.cellPhone = otherNode.cellPhone;
		    this.next = otherNode.next;
		}
		
		 //Clone method
		public CellNode clone() {
			cellPhone cellPhone2 = (cellPhone)cellPhone;
			cellPhone clonedPhone = cellPhone2.clone(); 
            return new CellNode(clonedPhone, null);
		}
		
		
		
		public cellPhone getCellPhone() {
			return this.cellPhone;
		}
		
		public CellNode getNext(){
			return this.next;
		}
		
		public void setNext(CellNode next) {
			this.next = next;
		}
		
		
	}
	
	private CellNode head;
	private int size;
	
	public CellList() {
        head = null;
        size = 0;
    }
	
	//Copy constructor
	public CellList(CellList otherList) {
		if(otherList.head == null) {
			this.head = null;
			this.size=0;
		}else {
			this.head = new CellNode(otherList.head.cellPhone, null);
			CellNode current = this.head;
			CellNode otherCurrent = otherList.head.next;
            
            while (otherCurrent != null) {
                current.next = new CellNode(otherCurrent.cellPhone, null);
                current = current.next;
                otherCurrent = otherCurrent.next;
            }
            
            this.size = otherList.size;
		}
	}
	
	//Clone method
	public CellList clone() {
		CellList clonedList = new CellList();
        if (this.head != null) {
            CellNode current = this.head;
            CellNode clonedNode = clonedList.head = current.clone();

            while (current.getNext() != null) {
                current = current.getNext();
                clonedNode.setNext(current.clone());
                clonedNode = clonedNode.getNext();
            }
        }
        clonedList.size = this.size; 
        return clonedList;
		
    }
	
	private CellNode copyList(CellNode cn1) {
		CellNode temp = cn1;
		CellNode newHead = null;
		CellNode end = null;	
		newHead = new CellNode((cellPhone)(temp.cellPhone).clone(), null);	
		
		end = newHead;
		temp = temp.next;
		
		while (temp != null)
		{
			end.next = new CellNode((cellPhone)(temp.cellPhone).clone(), null);	

			
			end = end.next;
			temp = temp.next;
		}
		
		return newHead;
	}
	
	public void addToStart(cellPhone cellphone) {
		CellNode newNode = new CellNode(cellphone, head);
		head = newNode;
		size++;
		
	}
	
	public void add(cellPhone cellphone) {
		CellNode newNode = new CellNode(cellphone, null);
		
		if (head == null) {
	        head = newNode;
	    } else {
	        CellNode current = head;
	        while (current.next != null) {
	            current = current.next;
	        }


	        current.next = newNode;
	    }
		
		size++;
	}
	
	public void insertAtIndex(cellPhone cellphone , int index) throws Exception {
		if(!(index>= 0 && index<= size -1)) {
			//Cant import NoSuchElementException !!!!
			throw new Exception("Invalid sytanx");
		}
		
		CellNode newNode = new CellNode(cellphone, null);
		
		
	    if (index == 0) {
	    	
	        newNode.next = head;
	        head = newNode;
	    } else {
	    	
	    	CellNode current = head;
	        for (int i = 0; i < index-2; i++) {
	        	current = current.next;
	        }
	        newNode.next = current.next;
	        current.next = newNode;
	    }

	    size++;
	}
	
	public void deleteFromIndex(int index) throws Exception {
		if(!(index>= 0 && index<= size -1)) {
			//Cant import NoSuchElementException !!!!
			throw new Exception("Invalid sytanx");
		}
		if(index == 0) {
			head = head.next;
		}else {
			
			CellNode current = head;
			for (int i = 0; i < index - 2; i++) {
                current = current.next;
            }
			current.next = current.next.next;
		}
		
	}
	
	public boolean deleteFromStart() {
		if (head != null)
		{
			head = head.next;	 
			size--;
			return true;
		}
		else
			return false;
		
	}
	
	public void replaceAtIndex(cellPhone newCellphone , int index) {
		if(!(index>= 0 && index<= size -1)) {
			//Cant import NoSuchElementException !!!!
			return;
		}else {
			CellNode current = head;
			for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
			
			current.cellPhone = newCellphone;
			
		}
		
		
	}
	
	public CellNode find(long serialNumber) {
		CellNode current = head;
        int iterations = 0;
        
        while(current != null) {
        	iterations++;
        	cellPhone newCurrent = (cellPhone)current.cellPhone;
        	if(newCurrent.getSerialNum() == serialNumber) {
        		System.out.println("Phone found after " + iterations + " iterations.");
                return current;
        	}
        	
        	current = current.next;
        }
        
        System.out.println("Phone not found after " + iterations + " iterations.");
        return null;
	}
	
	public boolean contains(long serialNumber) {
		CellNode current = head;
		int iterations = 0;
		
		while(current != null) {
	        	iterations++;
	        	cellPhone newCurrent = (cellPhone)current.cellPhone;
	        	if(newCurrent.getSerialNum() == serialNumber)
	        		return true;
	        	
	        	current = current.next;
	    }
		
		return false;
	}
	
	public void showContents() {
		CellNode current = head;
		if (current == null)
			System.out.println("There is nothing to display; list is empty." );
		else
			System.out.println("Here are the contents of the list." );
		
		int iterations = 0;
		
		while(current != null) {
	        	iterations++;
	        	cellPhone newCurrent = (cellPhone)current.cellPhone;
	        	System.out.println("["+ newCurrent.getSerialNum()+ ": "+ newCurrent.getBrand()+ " "+ newCurrent.getPrice()+" "+ newCurrent.getYear()+"] ---> ");
	        	current = current.next;
	    }
		System.out.println("X");
		
	}
	
	public boolean equals(CellList cellList) {
		CellNode currentThis = head;
		CellNode currentOther = cellList.head;
		int iterations = 0;
		
		while(currentThis != null) {
				cellPhone newCurrentThis = (cellPhone)currentThis.cellPhone;
				cellPhone newCurrentOther = (cellPhone)currentOther.cellPhone;
	        	if(newCurrentThis.getBrand().equals(newCurrentOther.getBrand()) && newCurrentThis.getPrice()==newCurrentOther.getPrice() && newCurrentThis.getYear()== newCurrentOther.getYear())
	        		return true;
	        		
	        	currentThis = currentThis.next;
	            currentOther = currentOther.next;
	    }
		return false;
	}
	
	
}
