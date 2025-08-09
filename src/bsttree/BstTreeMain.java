/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bsttree;

import java.util.Iterator;

/**
 *
 * @author matt
 */
public class BstTreeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        BST<Integer> intBst = new BST<Integer>();
        
        for(int i = 0; i <= 5; i++)
        {
            intBst.insert(i);
            
           // System.out.println(i + " was inserted into intBst");
        }
        
        
      
        System.out.println("The Bst in inOrder");
         intBst.inOrder();
        
         
        
       
       
       
         System.out.println("\n The Bst in preOrder");
      intBst.preOrder();


       System.out.println("\n The Bst in PostOrder ");
       
      intBst.postOrder();
       
//        
//      Iterator it = intBst.iterator();
//
//      
//      while (it.hasNext() )
//      {
//          System.out.print(it.next() );
//      }
     
        
        
      
      //no recursion exersises 
//      BstTravelWithNoRecursion<Integer> BWN = new BstTravelWithNoRecursion<Integer>(intBst);
//      
//      
//      BWN.inOrderWithStack();
//      
//      BWN.PreOrderWithStack();
      
      
    }
 
    
}
