class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
class Binary{
    Node root;
    Binary(){
        root=null;
    }
    public void insert(int data){
        root=insert(root,data);
    }

    Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }else if(data>root.data){
            root.right=insert(root.right,data);
        }
        return root;
    }

    void inorder(Node root){
            if(root!=null){
                inorder(root.left);
                System.out.print(root.data+" ");
                inorder(root.right);
            }
            // System.out.println();
    }
    void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        // System.out.println();
    }
    void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
    void  arrinsert(int[] arr){
      
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
    }
    int Height(Node root){
        if(root==null){
            return 0;
        }else{
            return Math.max(Height(root.right),Height(root.left))+1;
        }
    }

    void Bheight(){
        int h=Height(root);
        System.out.println(h);
    }

    int SBinary(Node root){
        if(root==null){
            return 0;
        }
        else{
            return 1+SBinary(root.left)+SBinary(root.right);
        }
    }

    void Size(){
        System.out.println(SBinary(root));
    }

    void ValuesAtK(Node root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
        }else{
            ValuesAtK(root.left,k-1);
            ValuesAtK(root.right,k-1);
        }
    }

    void LevelOrder(Node root){
        
    }
}

class Btree{
    public static void main(String[] args){
        // Node root=new Node(10);
        // root.left= new Node(20);
        // root.right=new Node(30);
        // root.right.left=new Node(40);
        // root.right.left=new Node(50);
        // inorder(root);
        int[] arr={4,1,2,3,6};
        Binary B=new Binary();
        // B.insert(4);
        // B.insert(6);
        // B.insert(2);
        // B.insert(3);
        // B.insert(1);
        // B.insert(5);
        B.arrinsert(arr);
        // B.inorder(B.root);
        // System.out.println();
        // B.preorder(B.root);
        // System.out.println();
        // B.postorder(B.root);
        // System.out.println();
        // B.Bheight();
        B.Size();
        B.ValuesAtK(B.root,3);
    }
}
