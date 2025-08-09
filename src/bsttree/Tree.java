/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bsttree;

import  java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author matt
 */
public interface Tree<E> extends Collection<E>
{
   boolean search(E e);
   
   boolean insert(E e);
   
   boolean delete(E e);

  
    
    public default void inOrder(){
        
    }
    
    public default void preOrder(){
        
    }
   
    public default void postOrder(){
        
    }
    
    
    
    public  int getSize();

    

    @Override
    public default boolean isEmpty() {
    
        return size() == 0;
        
    }

      
   @Override
   public default boolean add(Object e)
   {
       return insert((E) e);
   }
   
   @Override
    public default boolean contains(Object e){
    
        return search((E) e);
      
   }
    
    @Override
    public default boolean remove(Object e)
    {
        return delete((E) e);
        
    }
    
    @Override
    public default int size(){
        return getSize();
    }
   
    
    
   @Override
    public default Object[] toArray() {
            return null;
    }

    @Override
    public default  <T> T[] toArray(T[] a) {
            return null;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
    return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
    
        return false;
    }

    
}
