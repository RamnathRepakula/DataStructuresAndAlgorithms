package linkedlist.implementations.singlelinkedlist;

public class SingleLinkedList {
	
	private int length = 0;
	
	private ListNode head;
	
	public synchronized ListNode getHead() {
		return this.head;
	}
	
	public int getLength() {
		return length;
	}
	
	/********************************************************
	 * Insert Methods
	 ********************************************************/
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length ++;
	}
	
	public synchronized void insertAtEnd(ListNode node) {
		if(head == null) {
			head = node;
		} else {
			ListNode p, q;
			//Go to end of the list
			for(p = head; (q = p.getNext()) != null ; p=q);
			p.setNext(node);
			length++;
		}
	}
	
	public void insert (int data, int position) {
		if(position < 0) {
			position = 0;
		} 
		if(position > length) {
			position = length;
		}
		
		if(head == null) {
			head = new ListNode(data);
		} else if(position == 0) {
			//Insert at the starting position
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			//Insert at the required position
			ListNode temp = head;
			for(int i=1; i< position; i++) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		length ++;
	}
	/********************************************************
	 * End of Insert Methods
	 ********************************************************/
	
	/********************************************************
	 * Remove Methods
	 ********************************************************/
	public synchronized ListNode removeFromBegin() {
		ListNode nodeTobeDeleted = head;
		if(nodeTobeDeleted != null) {
			head = nodeTobeDeleted.getNext();
			nodeTobeDeleted.setNext(null);
			length --;
		}
		return nodeTobeDeleted;
	}
	
	public synchronized ListNode removeFromEnd() {
		if(head == null) {
			return null;
		}
		ListNode currentNode = head, previousNode = null, nextNode = head.getNext();
		
		if(nextNode == null) {
			head = null;
			return currentNode;
		}
		while((nextNode = currentNode.getNext()) != null) {
			previousNode = currentNode;
			currentNode = nextNode;
		}
		previousNode.setNext(null);
		length --;
		return currentNode;
	}
	
	public synchronized void removedMatched(ListNode nodeTobeDeleted) {
		if(head == null) {
			return;
		}
		if(nodeTobeDeleted.equals(head)) {
			head = head.getNext();
			return;
		}
		
		ListNode currentNode = head, loopNode = null;
		while( (loopNode = currentNode.getNext()) != null) {
			if(nodeTobeDeleted.equals(loopNode)) {
				currentNode.setNext(loopNode.getNext());
				length --;
				return;
			}
			currentNode = loopNode;
		}
	}
	
	public void removeAtPosition(int position) {
		if(position < 0) {
			position = 0;
		}
		if(position >= length) {
			position = length-1;
		}
		
		if(head == null) {
			return;
		}
		
		if(position == 0) {
			head = head.getNext();
		} else {
			ListNode temp = head;
			for (int i=1; i< position ; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length --;
	}
	
	/********************************************************
	 * End of Remove Methods
	 ********************************************************/
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		if(head == null) {
			result.append("]");
		}  else {
			ListNode currentNode = head;
			while(currentNode != null) {
				result.append( currentNode.getData() + ", ");
				currentNode = currentNode.getNext();
			}
			result.append("]");
		}
		return result.toString();
	}
	
	
	public int getPosition(int data) {
		ListNode currentNode = head;
		int position = 0;
		
		while(currentNode != null) {
			if(currentNode.getData() == data) {
				return position;
			}
			position ++;
			currentNode = currentNode.getNext();
		}
		return Integer.MIN_VALUE;
	}
	
	public void clearList() {
		head = null;
		length = 0;
	}
	
}
