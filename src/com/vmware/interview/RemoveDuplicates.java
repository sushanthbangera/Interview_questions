package com.vmware.interview;

public class RemoveDuplicates {

	public void removeDuplicates(Node head) {

		Node dummy = new Node(0);
		dummy.next = head;

		Node prev = dummy.next;
		Node current = prev.next;

		while (current != null) {

			while (current.next != null && prev.next.data == current.next.data) {
				current = current.next;
			}

			// different numbers - in that case current would not have moved
			if (prev.next == current) {
				prev = prev.next;
			} else {
				// the current would be pointing to last duplicate value
				prev.next = current.next;
			}

			current = current.next;
		}

		head = dummy.next;
	}
}

class Node {

	int data;

	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
