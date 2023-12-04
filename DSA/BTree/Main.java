import java.util.*;
class Binary{
    int data;
    Binary left;
    Binary right;
    Binary(int data){
        this.data=data;
    }
    void inorder(Binary root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    void AtdistK(Binary root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
        }else{
            AtdistK(root.left,k-1);
            AtdistK(root.right,k-1);
        }
    }

    int Max(Binary root){
        if(root==null){
            return 0;
        }else{
            return Math.max(root.data,Math.max(Max(root.left),Max(root.right)));
        }
    }
    int TotalNodes(Binary root){
        if(root==null){
            return 0;
        }else{
            return TotalNodes(root.left)+TotalNodes(root.right)+1;
        }
    }

    int Height(Binary root){
        if(root==null){
            return 0;
        }else{
            return Math.max(Height(root.right),Height(root.left))+1;
        }
    }

    void LevelOrder(Binary root){
        int H=Height(root);
        for(int i=0;i<H;i++){
            AtdistK(root,i);
        }
    }


    void BrethFirst(Binary root){
        Queue<Binary> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Binary temp=q.poll();
            if(temp==null){
                if(q.isEmpty()){
                    return;
                }
                q.add(null);
                System.out.println();
                continue;
            }
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }

    }

    void Iterative(Binary root){
        Stack<Binary> st=new Stack<>();
        Binary temp=root;
        while(temp!=null||!st.isEmpty()){
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            temp=st.pop();
            System.out.print(temp.data+" ");
            temp=temp.right;
        }
    }

    void ItrPre(Binary root){
        Stack<Binary> st= new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Binary temp=st.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
    }

    // boolean Search(Binary root,int var){
    //     if(root.data==var){
    //         return true;
    //     }
    //     if(root.data<var){
    //         return Search(root.right,var);
    //     }else{
    //           return Search(root.left,var);
    //     }
    // }

    boolean Search(Binary root,int val){
        Binary temp=root;
        while(temp!=null){
            if(temp.data==val){
                return true;
            }else if(temp.data<val){
               temp=temp.right;
            }else{
                temp=temp.left;
            }
        }
        return false;
    }

    Binary Insert(Binary root,int data){
            if(root==null){
                root= new Binary(data);
                return root;
            }
            if(root.data<data){
                root.right=Insert(root.right,data);
            }else{
                root.left=Insert(root.left,data);
            }
            return root;
    }


    Binary Delete(Binary root,int data){
        if(root==null){
            return null;
        }
        if(root.data>data){
            root.left=Delete(root.left,data);
        }else if(root.data<data){
            root.right=Delete(root.right,data);
        }
        else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                Binary succ=Getsucc(root);
                root.data=succ.data;
                root.right=Delete(root.right,root.data);
            }
        }
        return root;
    }

    Binary Getsucc(Binary root){
        Binary temp=root.right;
        while(temp!=null&& temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }

    Binary Floor(Binary root,int data){
        Binary temp=null;
        while(root!=null){
            if(root.data==data){
                return root;
            }else if(root.data>data){
                root=root.left;
            }else{
                temp=root;
                root=root.right;
            }
        }
        return temp;
    }

    Binary Ceil(Binary root,int data){
        Binary temp=null;
        while(root!=null){
            if(root.data==data){
                return root;
            }else if(root.data<data){
                root=root.right;
            }else{
                temp=root;
                root=root.left;
            }
        }
        return temp;
    }
}

class Main{
    public static void main(String[] args){
        Binary b=new Binary(10);
        b.left=new Binary(7);
        b.left.left=new Binary(3);
        b.left.left.right=new Binary(6);
        b.left.left.right.left=new Binary(5);
        b.right=new Binary(20);
        b.right.left=new Binary(16);
        b.right.right=new Binary(37);
        // b.inorder(b);
        // b.AtdistK(b,0);
        // System.out.println(b.Max(b));
        // System.out.println(b.TotalNodes(b));
        // System.out.println(b.Height(b));
        // b.LevelOrder(b);
        // b.BrethFirst(b);
        // b.Iterative(b);
        // b.ItrPre(b);
        // boolean res=b.Search(b,37);
        // if(res==true){
        //     System.out.print("Item found");
        // }else{
        //     System.out.print("Not found");
        // }
        // b.Insert(b,50);
        // b.ItrPre(b);
        // b.Preorder(b);
        // System.out.println();
        // b.Delete(b,20);
        // b.ItrPre(b);
        b.inorder(b);
        System.out.println();
        // Binary res=b.Floor(b,12);
        Binary res=b.Ceil(b,4);
        System.out.println(res.data);
    }
}