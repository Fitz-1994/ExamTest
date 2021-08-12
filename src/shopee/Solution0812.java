package shopee;

// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

// Given a Binary tree, calculate the maximum distance between the nodes

class Main {
    public static int max = 0;
    public static void main(String[] args) {

        Btree root = new Btree(0);
        Btree left = new Btree(1);
        Btree right = new Btree(1);
        Btree leftL = new Btree(11);
        Btree leftLL = new Btree(11);
        Btree leftLLL = new Btree(11);
        Btree leftLLLL = new Btree(11);

        Btree leftR = new Btree(0);
        Btree leftRR = new Btree(0);
        Btree leftRRR = new Btree(0);
        root.left = left;
        left.left = leftL;
        leftL.left = leftLL;
        leftLL.left = leftLLL;
        leftLLL.left = leftLLLL;


        left.right = leftR;
        leftR.right = leftRR;
        leftRR.right = leftRRR;


        root.right = right;

        new Main().maxDeep(root);
        System.out.println(max);

    }

    public int maxDeep(Btree tree){

        if(tree.isLeaf()){
            return 0;
        }
        int left =0;
        int right = 0;

        if(tree.left != null){
            left = maxDeep(tree.left)+1;
        }
        if(tree.right != null){
            right = maxDeep(tree.right)+1;
        }
        int sum = left+right;
        max = Math.max(max,sum);

        return Math.max(left,right);
    }


}


class Btree{
    Btree left;
    Btree right;
    int value;

    public Btree(int value){
        this.value = value;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }
}