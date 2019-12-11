package test;

public class Node {
        public Node pre;
        public Node next;
        public Object key;
        public Object value;
        public Node(){

        }
        public Node(Object key,Object value){
            this.key = key;
            this.value = value;
        }
}
