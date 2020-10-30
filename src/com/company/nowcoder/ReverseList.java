package com.company.nowcoder;

import com.company.base.BaseDemo;
import com.company.base.ListNode;
// 翻转链表
// https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&tags=&title=&diffculty=0&judgeStatus=0&rp=1
public class ReverseList extends BaseDemo {
    @Override
    public void solution() throws InterruptedException {
        ListNode testListNode = new ListNode();
        ListNode tempNode = testListNode;
        for (int i = 0; i < 50; i++) {
            tempNode.next = new ListNode(i);
            tempNode = tempNode.next;
        }

        tempNode = testListNode;
        while (tempNode != null) {
            System.out.print(tempNode.val + " ");
            tempNode = tempNode.next;
        }
        System.out.println("------------");

        ListNode reverseList = ReverseList(testListNode);
        tempNode = reverseList;
        while (tempNode != null) {
            System.out.print(tempNode.val + " ");
            tempNode = tempNode.next;
        }
    }


    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode nex = null;
        while(cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    public ListNode ReverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode indexNode = head.next;
        if(head.next.next == null) {
            head.next = null;
            indexNode.next = head;
            return indexNode;
        }

        ListNode preNode = head;
        ListNode nextNode = head.next.next;
        head.next = null;
        while(indexNode.next != null) {
            nextNode = indexNode.next;
            indexNode.next = preNode;
            preNode = indexNode;
            indexNode = nextNode;
        }
        indexNode.next = preNode;
        return indexNode;
    }
}
