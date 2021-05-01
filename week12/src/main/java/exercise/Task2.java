package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create 2021-04-28 22:24
 */
public class Task2 {

    public static void main(String[] args) {
        Task2 task = new Task2();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l2;
        System.out.println(task.hasCycle(l1));
    }


    public boolean hasCycle(ListNode head) {

        if(head==null||head.next==null){
            return false;
        }

        List<ListNode> list=new ArrayList<>();

        ListNode node=head;

        //遍历链表，遍历一个节点就向list中添加一个节点并删除该节点
        while(head!=null){
            list.add(node);
            head=head.next;
            node.next=null;
            node=head;
        }

        //若有循环列表，那么最后的那个元素一定是重复的那个节点
        for (int i = 0; i <list.size()-1; i++) {
            if(list.get(list.size()-1)==list.get(i)){
                return true;
            }
        }
        return false;

    }
}
