package linkedlist.implementations.singlelinkedlist;

public class SLLClient {
	
	public static void main(String[] args) {
		
		
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		System.out.println("List Length before Insert ==" + singleLinkedList.getLength());
		
		ListNode node = new ListNode(10);
		singleLinkedList.insertAtBegin(node);
		System.out.println("List Length after insert at first == " + singleLinkedList.getLength());
		System.out.println("List Data ==" + singleLinkedList);
		
		node = new ListNode(100);
		singleLinkedList.insertAtEnd(node);
		System.out.println("List Length after insert at last == " + singleLinkedList.getLength());
		System.out.println("List Data ==" + singleLinkedList);
		
		singleLinkedList.removeFromBegin();
		System.out.println("List Length after remove at start == " + singleLinkedList.getLength());
		System.out.println("List Data ==" + singleLinkedList);
		
	}

}
