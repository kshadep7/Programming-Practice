package medium;

public class Microsoft {

	public static void main(String[] args) {

	}

	/*

		ill writee here now
		i know a random class in java which genartres  random umber for me
		but key here is to
		thinkinh on how exactly i should be  using weights with random class
		i am not sure if i can pass an array to raandon class methods to get a raandom numbere from the arraay

wait pucho usko
do u happen to know if there is a mrthod whcih takes an aarray??

first creatae a method
		 */
	class Node{
		String val;
		Node next;
		Node  prev;
		Node(String val, Node next,Node prev){
			val = this.val;
			next = this.next;
			prev = this.prev;
		}
	}

	class ArrayList{
		Node head;
		Node end;
		//basically building arraylist using double linkedlist
		ArrayList(){
			head = null;
			end = null;
			head.next = end;
			end.prev = head;
		}
		private boolean add(String val){
			if(end.prev == head){
				head = new Node(val,end,null);
				end.prev = head;
				return true;
			}else
			{
				end.next = new Node(val,null,end);
				end = end.next;
				return true;
			}

		}
		private boolean contains(String val){
			Node tmp = head;
			while(head != null){
				if(head.val.equals(val)){
					return true;
				}
				head = head.next;
			}
			return false;
		}
	}
	//now we have arrayList and we can use is to save data for recursive search
	//So lets say we start with a current val recursively we can visited
	//so lets write pseudocode
	//create helper function which basically when we visit each element we can recrusively search for next element
	//so basically

	boolean helper(String[] arr,String val,ArrayList all){
		if(all.contains(val)){
			return true;
		}
		boolean result = false;
		for( String s: arr){
			if(s.charAt(0) == val.charAt(val.length()-1)){
				all.add(s);
				result = result || helper(arr,s,all);
			}
		}
		return result;
	}
	public static String solution(String[] arr) {

		for (int i = 0; i < arr.length-1; i++) {

		}

		return "";
	}

}
