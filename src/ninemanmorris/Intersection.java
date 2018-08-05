package ninemanmorris;
/**
 *
 * @author scott
 */
public class Intersection
{
    private class Data
    {
        private final int[] neighbour;
        private char token;
        
        private Data(int[] neighbour)
        {
            token = ' ';
            this.neighbour = neighbour;
        }
        
        private Data(Data data)
        {
            this.token = data.token;
            this.neighbour = data.neighbour.clone();
        }
    }
    
    private final Data[] intersections;
    
    public Intersection()
    {
        intersections = new Data[25];
        
        final int[] int01 = {2, 10};
        final int[] int02 = {1, 3, 5};
        final int[] int03 = {2, 15};
        final int[] int04 = {5, 11};
        final int[] int05 = {2, 4, 6, 8};
        final int[] int06 = {5, 14};
        final int[] int07 = {8, 12};
        final int[] int08 = {5, 7, 9};
        final int[] int09 = {8, 13};
        final int[] int10 = {1, 11, 22};
        final int[] int11 = {4, 10, 12, 19};
        final int[] int12 = {7, 11, 16};
        final int[] int13 = {9, 14, 18};
        final int[] int14 = {6, 13, 15, 21};
        final int[] int15 = {3, 14, 24};
        final int[] int16 = {12, 17};
        final int[] int17 = {16, 18, 20};
        final int[] int18 = {13, 17};
        final int[] int19 = {11, 20};
        final int[] int20 = {17, 19, 21, 23};
        final int[] int21 = {14, 20};
        final int[] int22 = {10, 23};
        final int[] int23 = {20, 22, 24};
        final int[] int24 = {15, 23};
        
        intersections[1] = new Data(int01);
        intersections[2] = new Data(int02);
        intersections[3] = new Data(int03);
        intersections[4] = new Data(int04);
        intersections[5] = new Data(int05);
        intersections[6] = new Data(int06);
        intersections[7] = new Data(int07);
        intersections[8] = new Data(int08);
        intersections[9] = new Data(int09);
        intersections[10] = new Data(int10);
        intersections[11] = new Data(int11);
        intersections[12] = new Data(int12);
        intersections[13] = new Data(int13);
        intersections[14] = new Data(int14);
        intersections[15] = new Data(int15);
        intersections[16] = new Data(int16);
        intersections[17] = new Data(int17);
        intersections[18] = new Data(int18);
        intersections[19] = new Data(int19);
        intersections[20] = new Data(int20);
        intersections[21] = new Data(int21);
        intersections[22] = new Data(int22);
        intersections[23] = new Data(int23);
        intersections[24] = new Data(int24);
    }
    
    public Intersection(Intersection other)
    {
        this.intersections = new Data[other.intersections.length];
        
        for (int i = 1; i < other.intersections.length; i++)
        {
            this.intersections[i] = new Data(other.intersections[i]);
        }
    }
    
    public boolean assignToken(char token, int id)
    {
        if (intersections[id].token != ' ')
        {
            return false;
        }
        
        if ((token == 'W') || (token == 'B'))
        {
            intersections[id].token = token;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public char removeToken(int id)
    {
        char result = intersections[id].token;
        intersections[id].token = ' ';
        return result;
    }
    
    public char getToken(int id)
    {
        return intersections[id].token;
    }
    
    public int[] getNeighbourList(int id)
    {
        return intersections[id].neighbour;
    }
}
