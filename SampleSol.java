package LeetCode;

public class SampleSol {
    public static void main(String[] args) {
        ListNode ln=new ListNode(1);
        ln.next=new ListNode(4);
        ln.next.next=new ListNode(3);
        ln.next.next.next=new ListNode(2);
        ln.next.next.next.next=new ListNode(5);
        ln.next.next.next.next.next=new ListNode(2);
        ListNode ans=ln.solve(ln,3);
        while (ans!=null){
            System.out.println(ans.val+"/n");
            ans=ans.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;


    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode solve(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        ListNode temp1 = new ListNode(-1);
        dummy.next = temp1;
        ListNode pointer = new ListNode(-1);
        ListNode temp2 = new ListNode(-1);
        pointer.next=temp2;

        ListNode iter = head;
        while (iter != null) {
            if (iter.val < k) {
                temp1.next = new ListNode(iter.val);
                temp1 = temp1.next;
            } else {
                temp2.next = new ListNode(iter.val);
                temp2 = temp2.next;
            }
        }

        temp1.next = pointer.next.next;

        return dummy.next.next;
    }
}
