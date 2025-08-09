/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bsttree;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author matt
 */
public class BST<E> implements Tree<E> {

  
   private  TreeNode<E> root;
    
   private int size;
   
    private Comparator<E> c;
    
    public BST(){
        c = (e1, e2) -> ( ((Comparable<E>) e1).compareTo(e2) );
    }
    
    public BST(Object[] e){
        
        for (int i = 0; i < e.length; i++ )
        {
            add( e[i] );
        }
        
    }

    public BST(Comparator<E> c)
    {
        this.c = c;
    }

    
    
    public TreeNode<E> getRoot(){
        return root;
    }

    
    //override java util iterator
    @Override
    public Iterator<E> iterator()
    {
        //return the inOrderIterator as it Overrides Iterator 
        return new InOrderIterator();
       
    }
    
   
   
    
   protected static class TreeNode<E>{
                  
       E element;
       
       TreeNode<E> left;
       
       TreeNode<E> right;
       
       TreeNode(E e)
       {
           element  = e;
       }
       
       
   }
   
   //method that creates a new node
   //method is from the factory pattern
     private TreeNode<E> createNewNode(E e)
   {
       return new TreeNode<E>(e);
       
   }
     
     
     //inOrder iterator to traverse elements in order
     private class InOrderIterator implements java.util.Iterator<E>{

       //stroe the index of the curent element
    private int current = 0;
      
    //store an in order list of the elements to be traversed through
    private   ArrayList<E>  list = new ArrayList<E>();
       
      
      //inOrder Iterator defualt constructor
      public InOrderIterator(){
          
          //calls the inorder method with the root
           inOrder(root);
      
      }
        
        //could put an inorder method here to basically call the other inorder method with the root as the current node

      
      private void inOrder(TreeNode<E> root)
      {
          //if root does not exist  break the inOrder method by returning nothing
          if(root == null) return ;
          
          //call the inorder method and pass current nodes left child
          inOrder(root.left);
          
          //instead of displaying the element, add it to the list
          list.add(root.element);
          
          //call the inorder method and pass current node right child
          inOrder(root.right);
         
          
      }
      
      
        @Override
        public boolean hasNext() {
               
            if(current < list.size() )
            {
                return true;
            }
            
            return false;
        }

        @Override
        public E next() {
            
            return list.get(current++);
        }

        @Override
        public void remove() {
        
            if(current == 0)
            {
                throw new IllegalStateException();
            }
            
            
            
            delete( list.get(current-- ) );
            
            list.clear();
         
            //rebuild the list
            inOrder(root);
            
        }
       
   }
     
     
     
     
     
     
     
     
     
   
     
   @Override
   public void inOrder(){
       
       //call the inOrder method and pass the root node to start
      inOrder(root);
       
       
   }
   
   
   private void inOrder(TreeNode<E> root){
       
       //if the node does not exit break the method by returning nothing
       if(root == null) return ;
       
       //recrusivly call inOrder method and pass the left child
       inOrder(root.left);
       
       //display the nodes value
       System.out.print(root.element + " ");
       
       //recursivly call the inOrder method and pass the right child
       inOrder(root.right);
       
       
   }
   
   @Override
   public void preOrder()
   {
       //call preOrder method and pass root to it
       preOrder(root);
       
   }
   
   private void preOrder(TreeNode<E> root)
   {
       //if the node does not exist, return nothing to break the PreOrder method
       if(root == null) return ;
       
       //display the current nodes value
       System.out.print(root.element + " ");
       
       //call the preOrder method and pass the current nodes left child
       preOrder(root.left);
       
       //call the preOrder method and pass the current nodes right child
       preOrder(root.right);
              
   }
   
   
   
   @Override
   public void postOrder()
   {
       postOrder(root);
   }
   
   private void postOrder(TreeNode<E> root){
       
       if(root == null) return ;
       
       postOrder(root.left);
       
       postOrder(root.right);
       
       System.out.print(root.element + " ");
       
   }
   
     
     
     
     
     
   

   @Override
   public boolean insert(E e){
       
       //if the list is empty
      if(root == null)
      {
          //assign the element as the new node
          root = createNewNode(e);
          
          //return that the element was entered  
          return true;
      }
      
      //if the list is not empty
      else
      {
          //parent points to parent of the current node
          //assign the parent to null as root does not have a parent
          TreeNode<E> parent = null;
          
          //current points to current node selected
          //assign current to the root node to start with the list
          TreeNode<E> current = root;
          
          //while current does not equal to nothing
          while(current != null)
          {
              //if the element to be inserted is less than the current element
              if(c.compare(e, current.element) < 0)
              {
                  //assigh the current node to parent
                 parent = current;
                 
                
                 //go to the current left subtree within the tree
                 current = current.left;
                  
                  
              }
              
           
              //if the element to be inserted is greater than the current element
              else if( c.compare(e, current.element) > 0 )
              {
                  //assign the current node to the parent
                  parent = current;
                  
                    //go to the current left subtree within the tree
                  current = current.right;
                  
              }
              //if the element equals the current's node element
              else
                  //return false
                  return false;
              
          }
          
          
          if(c.compare(e, parent.element) < 0)
          {
              parent.left = createNewNode(e);
          }
          else
          {
              parent.right = createNewNode(e);
          }
          
      }
      
      
    
      return true;
   }
   
   
    @Override
    public boolean search(E e) {
   
       TreeNode<E> current = root;
        
       while(current != null)
       {
           if(c.compare(e, current.element) < 0)
           {
               current = current.left;
           }
           else if(c.compare(e, current.element) > 0)
           {
               current = current.right;
           }
           else
                return true ;
               
           
       }
   
        return false;
        
    }
   
   
   @Override
   public boolean delete(E e)
   {
       //parent is currents parent
     TreeNode<E> parent = null;
     
     //holds the current element
     TreeNode<E> current = root;
     
     
     //locate the current element and parent
     while(current != null)
     {
         //if element is smaller then current node
         if(c.compare( e,  current.element) < 0)
         {
             parent = current;
             
             current = current.left;
         }
         
         
         //else if element is bigger then current node
         else if( c.compare(e, current.element) > 0)
         {
             parent = current;
             
             current = current.right;
         }
         
         ///if they are the same
         else
             break;
     }
     
     
     
     
     //if the element does not exist in the tree, return false
    if(current == null)
    {
       return false;
    }
    
    
    
    //element does exist in the tree
    else
    {
        
        //case 1 if the current node does not have a left child
        if(current.left == null)
        {
            //if parent is null, meaning if current is root
            if(parent == null)
            {
                //assign root to current elements right child
                root = current.right;
            }
            //if parent is not null, meaning if current is the node that has the current element
            else                
            {               
                //if the element is greater then the current elements node
                if(c.compare(e, current.element ) > 0 )
                {
                    
                    //assign the parent's right child to the current's right child
                    parent.right = current.right;
                }
                else
                {
                    //assign the parents left child to the currents right child
                    parent.left = current.right;
                }
            }
       }
        
        
       //case 2 if current node has a left child
        else 
        {
            //store the parent of right most
            TreeNode<E> ParentOfRightMost = current;
           
            //store the biggest node on the left side of the current 
            TreeNode<E> rightMost = current.left;
            
            
         
            //search for the largest element in currents left subtree and assign it to right most
          while(rightMost.right != null)
          {
              //assign the older value of  rightmost element as the parent of rightmost
              ParentOfRightMost = rightMost;
              
                //assign the right most element to the right most
              rightMost = rightMost.right;
          }
          
          
          //swap the current nods element with the right most element
          current.element = rightMost.element;
          
          //compare the parent of right most node to the right most node
          
          //if the parrent of right most is equal to rightmost
          if(ParentOfRightMost == rightMost)
          {
              //connect the ParentOfRightMost's right child to the rightMost's left child
              ParentOfRightMost.right = rightMost.left;
          }
          
          //special case ParentOfRightMost = current
          else
          {
              //connect the ParentOfRightMost's left child to the rightMost's left child
              ParentOfRightMost.left = rightMost.left;
          }
           
            
        }
    }
     
    //decrement size
    size--;
    
    //element has been deleted
    return true;
   }
   
   
   
   

 
   @Override
   public int getSize(){
       
       return this.size;
   }
   
   
   
    @Override
    public void clear() {
    
        root = null;
        
        size = 0;
        
    }
   
   
   
   
   
   
   
}
