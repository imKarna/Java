class Node{
    int data;
    Node next;
    static  int pos;
    Node(int data){
        this.data=data;
        this.next=null;
        this.pos=0;
    }
}

class Stack{
    Node head;
    Stack(){
        head=null;
    }
    void push(int data){
        Node NewNode=new Node(data);
        if(head==null){
            head=NewNode;
        }else{
            NewNode.next=head;
            head=NewNode;
        }
    }
    void peek(){
        if(head==null){
            System.out.println("Empty");
        }else{
            System.out.println(head.data);
        }  
    }
    void pop(){
        if(head==null){
            System.out.println("Stack empty");
        }else{
            System.out.print(head.data+" ");
            head=head.next;
            System.out.println(" poped");
        }
        
    }

    void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    void size(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        System.out.println(count);
    }
    void empty(){
        if(head!=null){
            System.out.println("Not empty");
        }else{
            System.out.println("");
            System.out.println("| "+"Empty"+" |");
            System.out.println("---------");
        }
    }
    void Display(){
        Node temp=head;
        System.out.println(" ");
        while(temp!=null){
            System.out.println("|   "+temp.data+"   |");
            System.out.println("---------");
            temp=temp.next;
        }
    }

    void ArrPush(int[] arr){
        for(int i=0;i<arr.length;i++){
            push(arr[i]);
        }
    }
}

class StackList{
    public static void main(String[] args){
        int[] arr={9,8,7,6,5,4,3,2,1,0};
        Stack ls=new Stack();
        ls.ArrPush(arr);
        ls.peek();
        // ls.pop();
        ls.size();
        ls.empty();
        ls.Display();
        ls.pop();
        ls.Display();
        // boolean lop=true;
        // while(lop!=true){
        //     System.out.print("Your choice: ");
        //     int test=sc.nextInt();
        //     if
        // }
    }
}