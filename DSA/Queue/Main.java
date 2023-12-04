class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Queue{
    Node head;
    Queue(){
        head=null;
    }

    void Enque(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
        }else{
            NewNode.next=head;
            head=NewNode;
        }
    }

    void Dqueue(){
        if(head==null){
            System.out.println("Empty");
        }else if(head.next==null){
            head=null;
        }else{
            Node temp=head;
            while(temp!=null && temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    void Display(){
        System.out.println(" ");
        if(head==null){
            System.out.println("|   | Empty Queue");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print("| "+temp.data+"  ");
            temp=temp.next;
        }
        System.out.println("");
    }
    void ArrEnque(int[] arr){
        for(int i=0;i<arr.length;i++){
            Enque(arr[i]);
        }
    }

    void size(){
        System.out.println("");
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        System.out.println(count);
    }
}
class Main{
    public static void main(String[] args){
        int[] arr={0,1,2,3,4,5,6,7,8,9,};
        Queue q=new Queue();
        q.ArrEnque(arr);
        q.Display();
        q.Dqueue();
        q.Display();
        q.size();
    }
}