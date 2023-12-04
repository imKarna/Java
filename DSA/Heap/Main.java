class Heap{
    int[] arr;
    int size;
    int capacity;
    Heap(int capacity){
        arr=new int[capacity];
        size=0;
        this.capacity=capacity;
    }
    
    int left(int i){
        return(2*i+1);
    }

    int right(int i){
        return(2*i+2);
    }

    int parent(int i){
        return(i-1)/2;
    }

    void Insert(int x){
        if(capacity==x){
            return;
        }
        size++;
        arr[size-1]=x;
        for(int i=size-1;i!=0 && arr[parent(i)]<arr[i];){
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }

    void Display(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

class Main{
    public static void main(String[] args){
        Heap h=new Heap(5);

        h.Insert(3);
        h.Insert(4);
        h.Insert(1);
        h.Insert(9);
        h.Insert(2);
        h.Display();
    }
}