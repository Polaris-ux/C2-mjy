package exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @description
 * @create 2021-04-28 21:24
 */
public class Task1 {

    public static void main(String[] args) {
        Task1 task = new Task1();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        ListNode listNode = task.deleteDuplicates(l1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    //自己实现的，忘记了升序这个条件
    public ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        Set<Integer> set=new HashSet<>();
        set.add(head.val);
        ListNode tmp=head;
        ListNode tmp2=head.next;
        while(tmp2!=null){
            if(set.contains(tmp2.val)){
                tmp.next=tmp2.next;
                tmp2=tmp2.next;
            }else{
                set.add(tmp2.val);
                tmp=tmp2;
                tmp2=tmp2.next;
            }
        }
        return head;
    }

    //递归
    public ListNode deleteDuplicates1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        head.next=deleteDuplicates1(head.next);
        if(head.val==head.next.val) head=head.next;
        return head;
    }

    //循环
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null&&cur.next.val==cur.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
