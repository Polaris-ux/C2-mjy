package exercise;

import exercise.listnode.ListNode;

/**
 * @author
 * @description
 * @create 2021-04-21 19:12
 */
public class Task0 {

    public static void main(String[] args) {

        Task0 task=new Task0();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        ListNode listNode = task.reverseList1(l1);
        while(listNode!=null){
            System.out.println(listNode.value);
            listNode=listNode.next;
        }
    }


    //递归方法
    public ListNode reverseList(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }

    //设两个标志节点
    public ListNode reverseList1(ListNode head){
        //当前节点的前一个节点
        ListNode pre=null;
        //当前节点
        ListNode cur=head;
        //当前节点的下一个节点
        ListNode nex=null;
        while(cur!=null){
            nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
        return pre;
    }

}

