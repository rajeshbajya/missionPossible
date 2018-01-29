package javaW;

public class LinkedList1 {

	
	class node{
		int value;
		node next;
		node(int val){
			value=val;
			next=null;
		}
	}
	public void print(node head){
		if(head==null)return;
		else{
			node temp=head;
			while(temp!=null){
				System.out.print(temp.value+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	
	public node insertNode(int value,node head){
		if(head==null){
			head=new node(value);
					}
		else{
			node temp=head;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=new node(value);
		}
		return head;
	}
	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		node head1= null;
		head1 = list.insertNode(1, head1);
		head1 = list.insertNode(1, head1);
		head1= list.insertNode(1, head1);
		head1 = list.insertNode(1, head1);
		head1=list.insertNode(1, head1);
		node head2= null;                           //       8 5 8 7 2
		head2 = list.insertNode(1, head2);
		head2 = list.insertNode(1, head2);
		head2= list.insertNode(1, head2);
		head2 = list.insertNode(1, head2);
		head2 = list.insertNode(9, head2);
		
		
		list.print(list.getFinalList(head1, head2));
		
	}
	
	public node getFinalList(node head1, node head2){
		if(head1==null)return head2;
		else if(head2==null)return head1;
		else{
			node temp;
			node temp1=head1;
			node temp2=head2;
			node prev1=null;
			node prev2=null;
			int carry=0;
			while(temp1!=null && temp2!=null){
				prev1=temp1;
				prev2=temp2;
				int val=temp1.value+temp2.value+carry;
				carry=0;
				if(val>9){
					carry=1;
					val=val-10;
				}
				temp1.value=val;
				temp2.value=val;
				temp1=temp1.next;
				temp2=temp2.next;
			}
			
			if(prev1.next==null && prev2.next==null){
				if(carry>0)
					{
					prev1.next=new node(carry);
					}
				return head1; // or head2
			}
			else if(prev1.next==null){
			
				while(temp2!=null){
					prev2=temp2;
					int value=temp2.value+carry;
					
					carry=0;
					if(value>9){
						carry=1;
						value=value-10;
					}
					temp2.value=value;
					temp2=temp2.next;
				}
				if(carry>0){
					prev2.next=new node(carry);
				}
				return head2;
			}
			else{
				while(temp1!=null){
					prev1=temp1;
					int value=temp1.value+carry;
					carry=0;
					if(value>9){
						carry=1;
						value=value-10;
					}
					temp1.value=value;
					temp1=temp1.next;
				}
				if(carry>0){
					prev1.next=new node(carry);
				}
			}
			return head1;
		}
				
	}

}
