package exercise;

import exercise.listnode.ListNode;

/**
 * @author
 * @description 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @create 2021-04-21 19:35
 */
public class Task1 {
    public static void main(String[] args) {
        Task1 task=new Task1();
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
        ListNode head1=l1;
        ListNode head2;
        ListNode h1=new ListNode(1);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(3);
        ListNode h4=new ListNode(4);
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        head2=h1;
        ListNode listNode = task.mergeList(head1, head2);
        while(listNode!=null){
            System.out.println(listNode.value);
            listNode=listNode.next;
        }

    }


    public ListNode mergeList(ListNode head1,ListNode head2){

        if(head1==null){
            return head2;
        }else if(head2==null){
            return head1;
        }else if(head1.value<head2.value){
            head1.next=mergeList(head1.next,head2);
            return head1;
        }else{
            head2.next=mergeList(head1,head2.next);
            return head2;
        }
    }
}
