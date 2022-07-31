package com.bridgelabz.hashtable;
import java.util.ArrayList;
import java.util.Objects;

    public class MyHashTable<K,V> {
        Integer bucketSize;
        ArrayList<LinkedList<K,V>> bucketList;

        public MyHashTable() {
            this.bucketSize = 10;
            this.bucketList = new ArrayList<>(bucketSize);
            for(int i=0;i<bucketSize;i++){
                bucketList.add(null);
            }
        }

        public Integer getIndex(K key) {
            Integer index = Math.abs(key.hashCode()) % bucketSize;
            return index;
        }


        public V get(K key ){
            int index = getIndex(key);
            LinkedList<K,V> linkedList = bucketList.get(index);
            if(linkedList == null){
                return null;
            }
            MyMapNode<K,V> myMapNode = linkedList.search(key);
            return (myMapNode == null)? null : myMapNode.value;
        }

        public void remove(K key){
            int index = getIndex(key);
            LinkedList<K,V> list =  bucketList.get(index);
            list.delete(key);
        }



        public void add(K key, V value){
            int index = getIndex(key);
            LinkedList<K,V> linkedList = bucketList.get(index);
            if(linkedList == null){
                linkedList = new LinkedList<>();
                bucketList.set(index,linkedList);
            }
            MyMapNode<K,V> myMapNode = linkedList.search(key);
            if(myMapNode == null){
                myMapNode = new MyMapNode<>(key,value);
                linkedList.append(myMapNode);
            }
            else{
                myMapNode.value = value;
            }
        }

        void print(){
            int i=1;
            for(LinkedList<K,V> linkedList: bucketList){
                if(linkedList == null){
                    continue;
                }
                System.out.println("Linked list "+i);
                linkedList.print();
                i++;
            }

        }
    }

