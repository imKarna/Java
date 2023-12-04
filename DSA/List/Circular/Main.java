class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}

class Circular{
    Node head;
    Circular(){
        head=null;
    }
    void Insert(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
            NewNode.next=head;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=NewNode;
        NewNode.next=head;
        // head=NewNode;
    }
    void Athead(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
            NewNode.next=head;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=NewNode;
        NewNode.next=head;
        head=NewNode;
    }
    void ArrInsert(int[] arr){
        for(int i=0;i<arr.length;i++){
            Insert(arr[i]);
        }
    }
    void AtIndex(int data,int index){
        Node NewNode=new Node(data);
        if(index==0){
            Athead(data);
        }
        Node temp=head;
        int count=0;
        do{
            if(count==index-1){
                NewNode.next=temp.next;
                temp.next=NewNode;
            }
            temp=temp.next;
            count++;
        }
        while(temp!=head);
        // while(index>count){
        //     temp=temp.next;
        //     ++count;
        // }
        // NewNode.next=temp.next;
        // temp.next=NewNode;
    }

    void Reverse(){
        Node curr=head;
        Node Prev=null;
        Node Next=null;
        do{
            Next=curr.next;
            curr.next=Prev;
            Prev=curr;
            curr=Next;
        }
        while(curr!=head);
        head.next=Prev;
        head=Prev;
    }
    void Display(){
        Node temp=head;
        while(temp.next!=head){
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }
        System.out.println(temp.data);

    }
    void Dindex(int index){
        if(head==null){
            System.out.println("Empty");
        }
        if(index==0){
            head=head.next;
        }
        Node temp=head;
        int count=0;
        do{
            if(count==index-1){
                temp.next=temp.next.next;
            }
            temp=temp.next;
            count++;
        }
        while(temp!=head);
    }
}

class Main{
    public static void main(String[] args){
        int[] arr={9,2,3,5,1,5,7};
        Circular c=new Circular();
        c.ArrInsert(arr);
        // c.Display();
        // c.Athead(20);
        c.AtIndex(333,7);
        c.Display();
        // c.Reverse();
        c.Dindex(7);
        c.Display();
    }
}