class Sort{
    public static void main(String[] args){
        int[] arr={8,4,9,1,4,6,3,12,11,20,17};
        // Buble(arr);
        // Selection(arr);
        Insertion(arr);
        Print(arr);
    }
    static void Buble(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    static void Print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
         System.out.println(" ");
    }

    static void Selection(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index=j;
                }
                 int temp=arr[i];
                 arr[i]=arr[index];
                 arr[index]=temp;
            }
        }
    }

    static void Insertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}