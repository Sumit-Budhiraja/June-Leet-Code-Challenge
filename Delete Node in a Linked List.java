class Solution {
    public void deleteNode(ListNode node) {
        if(node.next!=null)
        {
            ListNode temp = node.next.next;
            node.val = node.next.val;
            node.next = temp;
        }
    }
}