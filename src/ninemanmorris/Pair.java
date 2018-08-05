/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;

/**
 *
 * @author scott
 * @param <T1>
 * @param <T2>
 */
public class Pair<T1, T2>
{
    public final T1 t1;
    public final T2 t2;
    
    Pair(T1 t1, T2 t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }
}
