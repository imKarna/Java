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
class DoublyLinked{
    Node head;
    DoublyLinked(){
        head=null;
    }
    void Athead(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
        }else{
            NewNode.next=head;
            head.prev=NewNode;
            head=NewNode;
        }
    }
    void Insert(int data){
        if(head==null){
            Athead(data);
        }else{
            Node NewNode=new Node(data);
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=NewNode;
            NewNode.prev=temp;
        }
    }

    void ArrInsert(int[] arr){
        for(int i=0;i<arr.length;i++){
            Insert(arr[i]);
        }
    }
    void Dhead(){
        if(head==null){
            System.out.println("Empty");
        }else{
            head=head.next;
            head.prev=null;
        }

    }
    void Dindex(int index){
          if(index==0){
            Dhead();
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(count==index-1){
                if(temp.next.next==null){
                    temp.next=null;
                }else{
                    temp.next=temp.next.next;
                    temp.next.prev=temp;
                }
            }
                   
            temp=temp.next;
            count++;
        }
    }

    void AtIndex(int data,int index){
        if(index==0){
            Athead(data);
        }else{
            Node NewNode=new Node(data);
            Node temp=head;
            int count=0;
            while(temp!=null){
                if(count==index-1){
                    NewNode.next=temp.next;
                    if(temp.next!=null){
                        temp.next.prev=NewNode;
                    }
                    temp.next=NewNode;
                    NewNode.prev=temp;
                }
                temp=temp.next;
                count++;
            }
        }
    }
    void GetLastNode(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        System.out.println(temp.data);
    }

    void Dlast(){
        Node temp=head;
        while(temp.next.next!=null){ 
            temp=temp.next;
        }
        temp.next=null;

    }

    void Display(){
        Node temp=head;
        if(head==null){
            System.out.println("Empty");
        }
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(" <===> ");
            }
            temp=temp.next;
        }
        System.out.println(" ");
    }
    /*void Reverse(){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.prev!=null){
                System.out.print(" <===> ");
            }
            temp=temp.prev;
        }
    }*/
    void Reverse(){
        Node curr=head;
        Node temp=null;
        while(curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if(temp!=null){
            head=temp.prev;
        }
    }
    void Nthnode(int k){
        Node first=head;
        Node second=head;
        for(int i=0;first!=null;i++ ){
            first=first.next;
        }
        while(first!=null){
            second=second.next;
            first=first.next;
        }
        System.out.print(second.data);
    }
    void MiddleNode(){
        Node first=head,second=head;
        while(first !=null&& first.next!=null){
            second=second.next;
            first=first.next.next;
        }
        System.out.println(second.data);
    }
}
class Main{
    public static void main(String[] args){
        DoublyLinked d=new DoublyLinked();
        int[] arr={3,5,6,7,3,2,1};
        // d.Athead(19);
        // d.Athead(20);
        d.ArrInsert(arr);
        d.Display();
        // d.AtIndex(333,1);
        // d.Display();
        // // d.Reverse();
        // d.Athead(50);
        // d.Display();
        // d.GetLastNode();
        // d.Dlast();
         d.Dindex(5);
        // d.Dhead();
        // d.Reverse();
        // d.Nthnode(3);
        // d.MiddleNode();
        d.Display();
        // System.out.println(d.head.data);
        // System.out.println(d.head.prev);
    }
}