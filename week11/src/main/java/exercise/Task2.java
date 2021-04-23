package exercise;

import exercise.listnode.ListNode;

import java.util.Stack;

/**
 * @author
 * @description
 * @create 2021-04-21 22:17
 */
public class Task2 {

    public static void main(String[] args) {
        Task2 task=new Task2();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(1);

        l1.next=l2;
        l2.next=l3;
        System.out.println(task.isValidList(l1));
    }

    public boolean isValidList(ListNode head){
        Stack<Integer> stack=new Stack<>();
        ListNode head1=head;
        while(head1!=null){
            stack.push(head1.value);
            head1=head1.next;
        }
        while(head!=null){
            if(head.value!=stack.pop()){
                return false;
            }
        }
        return true;
    }

}
