/**
 * 招商银行笔试题
 * @author forward
 */
/*public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();

        int[] people = new int[N];

    }
    private int[] addToy(int[] people,int index){

    }
    private boolean addAble(int[] people,int index){
        if (index == people.length-1){
            int left = people[index] - people[index-1];
            if (left<1){
                return true;
            }else {
                return false;
            }
        }
        if (index == 0){
            int right = people[0] - people[1];
            if (right<1){
                return true;
            }else {
                return false;
            }
        }
        int left = people[index] - people[index-1];
        int right = people[index] - people[index+1];
        if (left<1 && right<1){
            return addAble(people,index-1) && addAble(people,index+1);
        }
    }
}*/
