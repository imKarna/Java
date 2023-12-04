class Stack{
    int arr[];
    int size;
    int pos;
    Stack(int n){
        pos=-1;
        size=n;
        arr=new int[size];
    }
    void push(int data){
        pos++;
        arr[pos]=data;
    }
    void pop(){
        int result=arr[pos];
        pos--;
        System.out.println(result+" poped");
    }
    void peek(){
        System.out.println(arr[pos]);
    }
    void size(){
        System.out.println(pos+1);
    }
    void isempty(){
        if(pos==-1){
            System.out.println("Empty");
        }else{
            System.out.println("Not empty");
        }
    }

    public static void main(String[] args){
        Stack s=new Stack(4);
        s.push(1);
        s.push(3);
        s.size();
        s.pop();
    }
}