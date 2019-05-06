package com.practice.jai.ds;

import java.util.HashSet;

public class LinkedList1
{
    private Node head = null;


    public void addElement(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head == null)
        {
            head = node;
            node.setNextNode(null);
        }
        else
        {
            node.setNextNode(head);
            head = node;
        }
    }

    public void deleteElementFromHead()
    {
        if(head != null)
        {
            head = head.getNextNode();
        }
    }

    public void insertAtSortedList(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head == null){
            head = node;
        }
        else
        {
            Node current = head;
            while (current != null)
            {
                if(data < current.getData())
                {
                    addElement(data);
                    break;
                }
               else if (data < current.getNextNode().getData())
                {
                    node.setNextNode(current.getNextNode());
                    current.setNextNode(node);
                    break;
                }

               current = current.getNextNode();
            }
        }
    }


    public LinkedList1 reverse()
    {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current!= null)
        {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }

        head = previous;

        return this;
    }

    public LinkedList1 removeDuplicates()
    {
        Node current = head;
        HashSet<Integer> s = new HashSet<>();
        s.add(head.getData());

        while (current!= null)
        {
            /*if(current.getNextNode()!= null && !s.add(current.getNextNode().getData()))
            {
                current.setNextNode(current.getNextNode().getNextNode());
            }*/


            s.add(current.getData());

            if(current.getNextNode()!= null && s.contains(current.getNextNode().getData()))
            {
                current.setNextNode(current.getNextNode().getNextNode());
            }

            current = current.getNextNode();
        }

        return this;
    }

    @Override
    public String toString()
    {
        Node node = head;
        StringBuilder data = new StringBuilder("data { ");
        while (node != null)
        {
            data.append(node.getData()).append(" ");
            node = node.getNextNode();
        }
        return data.toString() + "}";
    }
}