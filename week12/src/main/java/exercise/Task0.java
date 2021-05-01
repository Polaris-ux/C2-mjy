package exercise;

/**
 * @author
 * @description
 * @create 2021-04-28 21:06
 */
public class Task0 {

    public static void main(String[] args) {
        Task0 task = new Task0();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node4.next=node5;
        node5.next=node6;

        ListNode listNode = task.mergeTowLists(node1, node4);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    public ListNode mergeTowLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next=mergeTowLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTowLists(l1,l2.next);
            return l2;
        }
    }

}
