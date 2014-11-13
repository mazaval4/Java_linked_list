// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   
  
    //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }
   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
      
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {    
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
         
       }
   }
   

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
     
      //change the first reference to the new node.
      first = newNode;
      
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }
 
   //prints the strings in the linked list
   public String toString()
   {
       ListIterator iterator = listIterator();
       
       String toString = "{ ";
       
       while(iterator.hasNext())
       {
       toString += iterator.next()+" ";
       }
       return toString + "}\n";
       
       
   }
    
   //checks to see if the linked list is empty
   public boolean isEmpty()
   {
       boolean flag = false;
       ListIterator iterator = listIterator();
       
       if(iterator.hasNext() == false) 
       {
           flag = true;
       }
       else 
       {
           flag = false;
       }
      return flag;
   }

   //adds an element into the linked list
   public void addElement(int index, Object element) 
   {
       
      ListIterator iterator = listIterator();
       int count = 0;
       
      if(index <  0 )
       {
           IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
           throw ex;
       }
       
      do
       {
           if(count == index )
           {
               iterator.add(element);
               return;
           }
           count++;
           if(iterator.hasNext())
           {iterator.next();}
           
           else
               break;
        }
      
      while(count <= index);
       
        for(int i =0; i < index ; i++) 
        {
           if(iterator.hasNext() == false)
           {
               IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
               throw ex;
           }
       }
   }
   
   
   //sets the element at a given index
   public void setElement(int index, Object element)
   {
       
       
       ListIterator iterator = listIterator();
       int count = 0;
       
      if(index <  0 )
       {
           IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
           throw ex;
       }
       
      do
       {
           
           if(index == 0 )
           {
            iterator.next();
            iterator.set(element);
               
           }
           else if (count == index )
           {
               
               iterator.set(element);
               return;
           }
           count++;
           if(iterator.hasNext())
           {iterator.next();}
           
           else
               break;
        }
      
      while(count <= index);
       
        for(int i =0; i < index ; i++) 
        {
           if(iterator.hasNext() == false)
           {
               IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
               throw ex;
           }
       }
   }
   
   
   //removes a string at the given index
   public Object removeElement(int index)
    {
       ListIterator iterator = listIterator();
       int count = 0;
       String returnString = "";
       
       if(index <  0 )
       {
           IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
           throw ex;
       }
       
       if(index == 0)
       {
         returnString +=iterator.next();
         iterator.remove();
          
       }
       else
       {
        do
        {
           iterator.next();
           count++;
        }
        while(count < index && iterator.hasNext() );
       
        returnString += iterator.next();
        iterator.remove();
       }
       return returnString;
   }

   //removes the first few elements in the linked list
   public void removeFirstFew(int howMany)
   {
   
         ListIterator iterator = listIterator();
         int count = 0;
         
         if(howMany <= 0)
         {return;}
         else
       {
        do
        {
           iterator.next();
           iterator.remove();
           count++;
        }
        while(count < howMany );
       
       }
   
   
   
   
   }
  
   
   //finds the largest of the strings in the linked list
   public Object findLargest( )
   {
   
        ListIterator iterator = listIterator();
        
        if(iterator.hasNext() == false)
        { 
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
        }
        String largest = (String) iterator.next();
        while(iterator.hasNext())
        {
        
            String nextString = (String) iterator.next();
            
            if(largest.compareTo(nextString) < 0)
                largest = nextString;
        
        
        
        }
   
        return largest;
   
   }
   
   
     //removes all of the occurences of a string in the linked list
   public void removeAllOccurrences(Object stringToBeRemoved)
   {
   
        ListIterator iterator = listIterator();
       
        
        while(iterator.hasNext())
        {
            String largest = (String) iterator.next();
            if(largest.equals((String)stringToBeRemoved))
            iterator.remove();
        
        
        
        }
   
       
   
   }
       
   
   
       
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element before the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class