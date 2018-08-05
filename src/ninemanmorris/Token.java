package ninemanmorris;

/**
 *
 * @author scott
 */
public class Token
{
    public enum ColorType {WHITE, BLACK}
    
    private int whiteActive, blackActive, whitePlaced, blackPlaced;
    
    public Token()
    {
        whiteActive = 9;
        blackActive = 9;
        whitePlaced = 0;
        blackPlaced = 0;
    }
    
    public Token(Token other)
    {
        this.blackActive = other.blackActive;
        this.whiteActive = other.whiteActive;
        this.blackPlaced = other.blackPlaced;
        this.whitePlaced = other.whitePlaced;
    }
    
    public void deactivateToken(ColorType color)
    {
        if (color == ColorType.WHITE)
        {
            whiteActive--;
        } else if (color == ColorType.BLACK)
        {
            blackActive--;
        }
    }
    
    public void placeToken(char color)
    {
        if (color == 'W')
        {
            whitePlaced++;
        } else if (color == 'B')
        {
            blackPlaced++;
        }
    }
    
    public boolean lessThanNine(ColorType color)
    {
        if (color == ColorType.WHITE)
        {
            return (whitePlaced < 9);
        } else if (color == ColorType.BLACK)
        {
            return (blackPlaced < 9);
        }
        
        return false;
    }
    
     public boolean isThreeTokens(char color)
     {
        if (color == 'W')
        {
            if (whiteActive == 3)
            {
                return true;
            }
        } else if (color == 'B')
        {
            if (whiteActive == 3)
            {
                return true;
            }
        }
        return false;
     }
    
    public boolean checkWinner()
    {
        if (whiteActive <= 2)
        {
            System.out.println("Black wins");
            return true;
        }
        else if (blackActive <= 2)
        {
            System.out.println("White wins");
            return true;
        }
        return false;
    }
}