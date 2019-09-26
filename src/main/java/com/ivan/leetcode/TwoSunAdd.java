package com.ivan.leetcode;

public class TwoSunAdd {


    public static void main(String[] args){
        TwoSunAdd test=new TwoSunAdd();
        test.testList();
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void testList(){
        ListNode listNode13=new ListNode(3);
        ListNode listNode12=new ListNode(4);
        listNode12.next=listNode13;
        ListNode p1=new ListNode(2);
        p1.next=listNode12;

        ListNode listNode23=new ListNode(4);
        ListNode listNode22=new ListNode(6);
        listNode22.next=listNode23;
        ListNode p2=new ListNode(5);
        p2.next=listNode22;

//        ListNode p1=listNode1,p2=listNode2;
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        int carried=0;
        while (p1!=null || p2!=null){
            int a=p1!=null?p1.val:0;
            int b=p2!=null?p2.val:0;
            cur.next=new ListNode((a+b+carried)%10);
            carried=(a+b+carried)/10;
            cur=cur.next;

            p1=p1!=null?p1.next:null;
            p2=p2!=null?p2.next:null;

        }
        if(carried==1){
            cur.next=new ListNode(carried);
        }

        ListNode ret=dummyHead.next;
        show(ret);

//        public:
//        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
//
//            ListNode *p1 = l1, *p2 = l2;
//            ListNode *dummyHead = new ListNode(-1);
//            ListNode* cur = dummyHead;
//            int carried = 0;
//            while(p1 || p2 ){
//                int a = p1 ? p1->val : 0;
//                int b = p2 ? p2->val : 0;
//                cur->next = new ListNode((a + b + carried) % 10);
//                carried = (a + b + carried) / 10;
//
//                cur = cur->next;
//                p1 = p1 ? p1->next : NULL;
//                p2 = p2 ? p2->next : NULL;
//            }
//
//            cur->next = carried ? new ListNode(1) : NULL;
//            ListNode* ret = dummyHead->next;
//            delete dummyHead;
//            return ret;
//        }

//        ListNode list=getResult(listNode1,listNode2,0,null);
//
//        show(list);
    }


    public static void show(ListNode listNode){
        System.out.println(listNode.val);
        if(listNode.next!=null){
            show(listNode.next);
        }

    }

    public static ListNode setNode(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node1.next!=null){
            return setNode(node1.next,node2);
        }else{
            node1.next=node2;
            return node1;
        }
    }

//    public static ListNode getResult(ListNode listNode1,ListNode listNode2,int num,ListNode result){
//        int target;
//        if(listNode1==null&&listNode2==null){
//            if(num==0){
//                return result;
//            }
//            target=num;
//            ListNode listNode=new ListNode(target%10);
//            result=setNode(result,listNode);
//            return listNode;
//        }else{
//            int val1=(listNode1==null?0:listNode1.val);
//            int val2=(listNode2==null?0:listNode2.val);
//            target=val1+val2+num;
//            ListNode listNode=new ListNode(target%10);
//            result=setNode(result,listNode);
//            ListNode next1=(listNode1==null?null:listNode1.next);
//            ListNode next2=(listNode2==null?null:listNode2.next);
//            if(target>=10){
//                return getResult(next1,next2,1,result);//只会进1
//            }else{
//                return getResult(next1,next2,0,result);
//            }
//        }
//
//
//    }

}
