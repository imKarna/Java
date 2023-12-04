class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class CircularDoubly{
    Node head;
    CircularDoubly(){
        head=null;
    }
    void Insert(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
            NewNode.next=head;
            NewNode.prev=head;
        }
        Node temp=head;
        while(temp.next !=head){
            temp=temp.next;
        }
        NewNode.next=temp.next;
        temp.next.prev=NewNode;
        temp.next=NewNode;
        NewNode.prev=temp;
    }
    void Athead(int data){
        Node NewNode=new Node(data);
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=NewNode;
        NewNode.next=head;
        head.prev=NewNode;
        NewNode.prev=temp;
        head=NewNode;
    
        
    }
    void Dindex(int index){
        Node temp=head;
        int count=0;
        do{
            if(count==index-1){
                temp.next=temp.next.next;
                temp.next.prev=temp;
            }
            temp=temp.next;
            count++;
        }
        while(temp!=head);

    }
    void Atindex(int data,int index){
        if(index==0){
            Athead(data);
        }
        Node NewNode=new Node(data);
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        NewNode.next=temp.next;
        temp.next=NewNode;
    }
    void Display(){
        Node temp=head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        while(temp!=head);
         System.out.println("");
    }
    void Reverse(){
         Node temp=head;
         while(temp.next!=head){
            temp=temp.next;
         }
         while(temp!=head){
            System.out.println(temp.data);
            temp=temp.prev;
         }
         System.out.println(temp.data);

     }
}

class Main{
    public static void main(String[] args){
        CircularDoubly cd=new CircularDoubly();
        cd.Insert(10);
        cd.Insert(20);
        cd.Insert(30);
        cd.Athead(333);
        cd.Display();
        // cd.Atindex(333,1);
        cd.Dindex(2);
        // cd.Reverse();
        
    }
}