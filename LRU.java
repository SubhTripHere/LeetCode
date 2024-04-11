package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
    private K key ;
    private V value;
    int cap;
    Map<K,DLL> map=new HashMap<>();

    Cache(int cap){
        this.cap=cap;
    }

    DLL head=new DLL( new Node(1,"a"));
    DLL tail=new DLL(new Node(1,"a"));

    public Object getValue(K key){
        if(map.containsKey(key))
                return map.get(key);
        else
            return null;
    }

    public void setValue(K key,V value){
        if(map.size()==cap){
            DLL pre=tail.prev;
            DLL prev=tail.prev.prev;
            prev.next=tail;
            tail.prev=prev;
            map.remove(pre.node.key);
        }
        //case 2: map has the key already
        if(map.containsKey(key)){
            DLL temp=map.get(key);
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;

        }





        DLL node=new DLL(new Node(key,value));
        DLL next=head.next;
        head.next=node;
        node.next=next;
        next.prev=node;
        node.prev=head;
        map.put(,node);

    }

}

class DLL{
    Node node;
    DLL prev;
    DLL next;

    DLL(Node node){
        this.node=node;
        this.prev=null;
        this.next=null;
    }
}

class Node<K,V>{
    K key;
    V val;

    Node(K k,V val){
        this.key=k;
        this.val=val;
    }

}

//interface  LRUStragetergy{
//    void setStratergy(StratergyType stratergy);
//
//}


class LRUUtility{
    LRU<Integer,String> lru=new LRU<>(3);

}


//  enum StratergyType{
//    LeastRecently ,
//    MostUsed,
//        }
//
// public class LRUImpl implements LRUStragetergy{
//
//
//     @Override
//     public void setStratergy(StratergyType stratergy) {
//
//     }
// }
