/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninemanmorris;
import java.util.*;
/**
 *
 * @author scott
 */
public class Mill
{
    private MillInterface listen;
    private Data[] mills;
    
    private class Data
    {
        private final int[] contains;
        private boolean millActiveWhite = false;
        private boolean millActiveBlack = false;
        
        private Data(int[] contains)
        {
            this.contains = contains;
        }
    }
    
    public Mill()
    {
        mills = new Data[17];
        int [] contains01 = {1, 2, 3};
        int [] contains02 = {4, 5, 6};
        int [] contains03 = {7, 8, 9};
        int [] contains04 = {10, 11, 12};
        int [] contains05 = {13, 14, 15};
        int [] contains06 = {16, 17, 18};
        int [] contains07 = {19, 20, 21};
        int [] contains08 = {22, 23, 24};
        int [] contains09 = {1, 10, 22};
        int [] contains10 = {4, 11, 19};
        int [] contains11 = {7, 12, 16};
        int [] contains12 = {2, 5, 8};
        int [] contains13 = {17, 20, 23};
        int [] contains14 = {9 , 13, 18};
        int [] contains15 = {6, 14, 21};
        int [] contains16 = {3, 15, 24};
        
        mills[1] = new Data(contains01);
        mills[2] = new Data(contains02);
        mills[3] = new Data(contains03);
        mills[4] = new Data(contains04);
        mills[5] = new Data(contains05);
        mills[6] = new Data(contains06);
        mills[7] = new Data(contains07);
        mills[8] = new Data(contains08);
        mills[9] = new Data(contains09);
        mills[10] = new Data(contains10);
        mills[11] = new Data(contains11);
        mills[12] = new Data(contains12);
        mills[13] = new Data(contains13);
        mills[14] = new Data(contains14);
        mills[15] = new Data(contains15);
        mills[16] = new Data(contains16);
    }
    
    public void addListener(MillInterface listener)
    {
        this.listen = listener;
    }
    
    public boolean isMillActive(int intersectionId)
    {
        List<Integer> millsToCheck = new ArrayList<>();
        for (int i = 1; i <= 16; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (mills[i].contains[j] == intersectionId)
                {
                    millsToCheck.add(i);
                }
            }
        }
        
        String[] temp = new String[3];
        
        for (Integer mill: millsToCheck)
        {
            for (int j = 0; j < 3; j++)
            {
                temp[j] = String.valueOf(listen.getIntersectInfo(mills[mill].contains[j]));
            }
            
            if (Arrays.stream(temp).allMatch(s -> s.equals(temp[0])))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public void checkMills()
    {
        String[] temp = new String[3];
        
        for (int i = 1; i <= 16; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                temp[j] = String.valueOf(listen.getIntersectInfo(mills[i].contains[j]));
            }
            
            if (Arrays.stream(temp).allMatch(s -> s.equals(temp[0])))
            {
                if (temp[0].equals("B"))
                {
                    if (!mills[i].millActiveBlack)
                    {
                        mills[i].millActiveBlack = true;
                        listen.millFound('B');
                        return;
                    }
                }
                else if (temp[0].equals("W"))
                {
                    if (!mills[i].millActiveWhite)
                    {
                        mills[i].millActiveWhite = true;
                        listen.millFound('W');
                        return;
                    }
                }
            }
            else
            {
                mills[i].millActiveWhite = false;
                mills[i].millActiveBlack = false;
            }
        }
    }
}
