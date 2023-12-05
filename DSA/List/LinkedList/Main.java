class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node head;
    LinkedList(){
        head=null;
    }
    void Insert(int data){
        Node Newnode=new Node(data);
        if(head==null){
            head=Newnode;
        }else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=Newnode;
        }
    }
    void ArrInsert(int[] arr){
        for(int i=0;i<arr.length;i++){
            Insert(arr[i]);
        }
    }

    void Athead(int data){
        Node Hnode=new Node(data);
        if(head==null){
            head=Hnode;
        }else{
            Hnode.next=head;
            head=Hnode;
        }   
    }

    void MiddleNode(){
        if(head==null){
            System.out.println("Empty");
        }else{
            Node slow=head,fast=head;
            while(fast != null && fast.next !=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            System.out.print(slow.data);
        }

    }
    void print(){
        if(head==null){
            System.out.println("Empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
    }
    void Dhead(){
        if(head==null){
            System.out.println("Empty");
        }else{
            head=head.next;
        }
    }

    void Dlast(){
        Node temp=head;
        while(temp.next.next != null){
            temp=temp.next;
        }
        temp.next=null;
    }

    void SortedInsert(int data){
        Node NewNode=new Node(data);
        Node temp=head;
        if(head==null){
            head=NewNode;
        }
        if(data<head.data){
            NewNode.next=head;
            head=NewNode;
        }
        while(temp.next !=null && temp.next.data<data){
            temp=temp.next;
        }
        NewNode.next=temp.next;
        temp.next=NewNode;
    }
    void AtIndex(int data,int index){
        Node NewNode=new Node(data);
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            if(cnt==index-1){
                NewNode.next=temp.next;
                temp.next=NewNode;
            }
            cnt++;
            temp=temp.next;
        }
    }
    void RemoveIndex(int index){
        int count=0;
        Node temp=head;
        if(index==0){
            Dhead();
        }
        while(temp!=null){
            if(count==index-1){
                temp.next=temp.next.next;
            }
            count++;
            temp=temp.next;
        }
    }
    void Getfromlast(int n){
        int len=0;
        Node temp=head;
        if(head==null){
            System.out.println("Empty");
        }
        Node first=head;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        Node second=head;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        System.out.println(second.data);
    }
    void Reverse(){
        Node curr=head,Next=null,prev=null;
        while(curr!=null){
            Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        head=prev;
        print();
    }

}

class Main{
    public static void main(String[] args){
        LinkedList ll=new LinkedList();
        int[] arr={10,20,30,40,50};
        ll.ArrInsert(arr);
        System.out.println();
        ll.print();
        System.out.println("");
        ll.Reverse();
        // ll.RemoveIndex(4);
        // System.out.println("");
        // ll.print();
        // System.out.println("");
        // System.out.println();
        // System.out.println();
        // ll.MiddleNode();
        // ll.Dhead();
        // System.out.println();
        // ll.print();
        // System.out.println();
        // ll.Dlast();
        // ll.print();
        // System.out.println();
        // //ll.SortedInsert(90);
        // ll.Getfromlast(2);
        // ll.print();

    }
}