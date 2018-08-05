package ninemanmorris;

import java.util.*;
/**
 *
 * @author scott
 */
public class Player
{
    private PlayerInterface listen;
    private final char color;
    private String name;
    private final Map<Integer, Integer> positions;
    
    public Player(char color)
    {
        this.color = color;
        
        positions = new HashMap<>();
        positions.put(11, 1);
        positions.put(41, 2);
        positions.put(71, 3);
        positions.put(22, 4);
        positions.put(42, 5);
        positions.put(62, 6);
        positions.put(33, 7);
        positions.put(43, 8);
        positions.put(53, 9);
        positions.put(14, 10);
        positions.put(24, 11);
        positions.put(34, 12);
        positions.put(54, 13);
        positions.put(64, 14);
        positions.put(74, 15);
        positions.put(35, 16);
        positions.put(45, 17);
        positions.put(55, 18);
        positions.put(26, 19);
        positions.put(46, 20);
        positions.put(66, 21);
        positions.put(17, 22);
        positions.put(47, 23);
        positions.put(77, 24);
    }
    
    public void addListener(PlayerInterface listener)
    {
        this.listen = listener;
    }
    
    public void askName()
    {
        System.out.print("Player " + color + " enter your name: ");
        name = Game.SCANNER.nextLine();
    }
    
    private int getCoordinates()
    {
        String input;
        int pos;
        do 
        {
            do
            {
                System.out.print("Enter valid coordinates: ");
                input = Game.SCANNER.nextLine();
                
                if (input.equals("undo"))
                {
                    listen.undoLastMove();
                    return (-1);
                }
            } while (!input.matches("^-?\\d+$"));

            pos = Integer.parseInt(input);

        } while (!positions.containsKey(pos));
        
        return positions.get(pos);
    }
    
    public void placeToken()
    {
        System.out.print(name + " place a token on the board. ");
        
        int pos;
        do
        {
            pos = getCoordinates();
            if (pos == (-1))
            {
                return;
            }
        } while (listen.getIntersectInfo(pos) != ' ');

        listen.putToken(color, pos);
    }
    
    public int stealToken()
    {
        System.out.print(name + " choose a token to steal: ");
        
        int pos;
        do
        {
            do
            {
                pos = getCoordinates();
                if (pos == (-1))
                {
                    return (-1);
                }
            } while (listen.getIntersectInfo(pos) == color);
        } while(listen.isMillActive(pos));
        
        return pos;
    }
    
    public void moveToken()
    {
        System.out.print(name + " choose a token to move (fromPos [space] toPos): ");
        
        int fromCoord, toCoord, fromPos, toPos;        
        
        do
        {
            do 
            {
                String input;
                String[] splitInput;
                boolean isInt;

                do
                {
                    do
                    {
                        System.out.print("Enter valid coordinates: ");
                        input = Game.SCANNER.nextLine();
                        
                        if (input.equals("undo"))
                        {
                            listen.undoLastMove();
                            return;
                        }
                        
                        splitInput = input.split(" ");

                    } while (splitInput.length != 2);

                    isInt = true;

                    for (String s: splitInput)
                    {
                        if (!s.matches("^-?\\d+$"))
                        {
                            isInt = false;
                        }
                    }
                } while (!isInt);
                
                fromCoord = Integer.parseInt(splitInput[0]);
                toCoord = Integer.parseInt(splitInput[1]);

            } while (!positions.containsKey(fromCoord) ||
                    !positions.containsKey(toCoord));

            fromPos = positions.get(fromCoord);
            toPos = positions.get(toCoord);

        } while ((listen.getIntersectInfo(fromPos) != color) ||
                (listen.getIntersectInfo(toPos) != ' ') ||
                (!listen.moveToken(fromPos, toPos, color)));
    }
}