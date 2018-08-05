package ninemanmorris;

/**
 *
 * @author scott
 */
public class UndoMove
{
    private Token currentToken;
    private Intersection currentIntersection;
    
    private Token previousToken;
    private Intersection previousIntersection;
    
    public void updateData(Token token, Intersection intersection)
    {
        previousIntersection = currentIntersection;
        previousToken = currentToken;
        
        currentToken = new Token(token);
        currentIntersection = new Intersection(intersection);
    }
    
    public Pair<Token, Intersection> restoreData()
    {
        return new Pair<>(new Token(previousToken),
                new Intersection(previousIntersection));
    }
}
