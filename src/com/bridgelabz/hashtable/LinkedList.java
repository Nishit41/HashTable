package com.bridgelabz.hashtable;
public class LinkedList<K,V> {
        MyMapNode<K,V> head;
        MyMapNode<K,V> tail;


        public MyMapNode<K,V> search(K searchData) {
            MyMapNode<K,V> temp = head;
            while(temp != null){
                if(temp.key.equals(searchData))
                    return temp;
                temp = temp.next;
            }
            return null;
        }


        public void delete(K key){
            MyMapNode<K,V> temp = head;
            MyMapNode<K,V> searchedElement = search(key);
            while(temp.next != searchedElement){
                temp = temp.next;
            }
            temp.next = searchedElement.next;
        }


        public void append(MyMapNode<K,V> node ) {

            if(head == null) {
                head = node;
                tail = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
        }

        public void print(){
            MyMapNode<K,V> temp = head;
            while(temp != null){
                System.out.println(temp);
                temp = temp.next;
            }
        }

        @Override
        public String toString() {
            return "LinkedList{" +
                    "head=" + head +
                    ", tail=" + tail +
                    '}';
        }

    }
