package test;

import java.util.HashMap;

/**
 *LRU arithmetic
 * 最近最少使用算法
 * */
public class LRUCache {
     private Node head;
     private Node end;
     //缓存存储上限
    private int limit;

    private HashMap<String,Node> hashMap;
    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<String,Node>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return (String)node.value;
    }

    public void put(String key,String value){
        Node node = hashMap.get(key);
        if (node == null){
            //如果key不存在，则插入key-value
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(key);
            }
            node = new Node(key,value);
            addNode(node);
        }else {
            //如果key存在，则刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问节点的位置
     * @param node 被访问的节点
     * */
    private void refreshNode(Node node){
        //如果访问的是尾节点，则无需移动节点
        if (node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 删除节点
     * @param node 要删除节点
     * */
    private String removeNode(Node node){
        if (node == head && node == end){
            //移除唯一节点
            head = null;
            end = null;
        }else  if(node == end){
            //移除尾节点
            end = end.pre;
            end.next = null;
        }else if(node == head){
            //移除头节点
            head = head.next;
            head.pre = null;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return  (String) node.key;
    }

    /**
     * 尾部插入节点
     * @param node
     * */
    private void addNode(Node node){
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","用户1信息");
        lruCache.put("002","用户1信息");
        lruCache.put("003","用户1信息");
        lruCache.put("004","用户1信息");
        lruCache.put("005","用户1信息");
        lruCache.get("002");
        lruCache.put("004","用户2信息更新");
        lruCache.put("006","用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }

}
