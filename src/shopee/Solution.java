package shopee;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next= l3;
        l3.next = null;

        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = null;

//        ListNode res = reverse(l1);
//        System.out.println(res);
        System.out.println(cal(l1,r1));

    }

    public static ListNode cal(ListNode l1,ListNode r1){
        ListNode l1r = reverse(l1);
        ListNode r1r = reverse(r1);

        ListNode li = l1r;
        ListNode ri = r1r;
        ListNode res = null;
        ListNode resi = res;
        int add = 0;

        while (li != null && ri != null){
            int result = li.value+ ri.value +add;
            if (result < 10){
                if (resi == null){
                    resi = new ListNode(result);
                }else {
                    resi.next = new ListNode(result);
                }
                resi = resi.next;
                add = 0;
            }else {
                if (resi == null){
                    resi = new ListNode(result%10);
                }else {
                    resi.next = new ListNode(result%10);
                }
                resi = resi.next;
                add = 1;
            }
            li = li.next;
            ri = ri.next;
        }
        if (li == null && ri == null){
            if (add == 1){
                resi.next = new ListNode(1);
                resi = resi.next;
            }
            return reverse(resi);
        }else {
            if (li == null){

            }
        }



        return null;


    }

    public static ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }
        if (node.next == null){
            return node;
        }
        ListNode p1 = node;
        node.next = null;
        ListNode p2 = node.next;
        ListNode p3;
        if (p2.next != null){
            p3 = p2.next;
        }else {
            p2.next = p1;
            p1.next = null;
            return p2;

        }
        while (p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }

}
class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}