/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bsttree;

import bsttree.BST.TreeNode;
import java.util.Stack;

/**
 *
 * @author matt
 */
public class BstTravelWithNoRecursion<E> {
    
   private TreeNode<E> root;
   
    
    public BstTravelWithNoRecursion(BST bst)
            {
                this.root = bst.getRoot();
                
              
            }

    
    public void inOrderWithStack()
    {
        Stack<TreeNode<E> > stack = new Stack< TreeNode<E> >();
       
        
        TreeNode<E> current = root;
        
        while(current != null || stack.size() > 0 )
        {
           while(current != null)
            {
            stack.push(current );
            
            current = current.left;
            
           }
          
            current = stack.pop();
            
          System.out.print( current.element + " " );
            
          current = current.right;
          
            
        }
        
       
        
        
        
        
    }
    
    
    public void PreOrderWithStack()
    {
        TreeNode<E> current  = root;
     
        Stack<TreeNode<E>> stack = new Stack<>();
        

           stack.push(root);
           
           
           while(!stack.isEmpty())
           {
               current = stack.peek();
               
               stack.pop();
               
               System.out.println(current.element );
               
               if(current.left != null)
               stack.push(current.left);
               
               if(current.right != null)
               stack.push(current.right);
           }
        
    }
    

}
