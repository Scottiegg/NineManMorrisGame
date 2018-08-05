package ninemanmorris;

import java.util.Scanner;

/**
 *
 * @author scott
 */
public class Game implements BoardInterface, PlayerInterface, MillInterface
{
    public static final Scanner SCANNER = new Scanner(System.in);
    Intersection intersection;
    Board board;
    Token token;
    Mill mill;
    Player playerOne;
    Player playerTwo;
    UndoMove undoMove;
    
    public Game()
    {
        intersection = new Intersection();
        board = new Board();
        token = new Token();
        mill = new Mill();
        playerOne = new Player('W');
        playerTwo = new Player('B');
        undoMove = new UndoMove();
    }
        
    @Override
    public char getIntersectInfo(int id)
    {
        return intersection.getToken(id);
    }
    
    @Override
    public void putToken(char tokenType, int id)
    {
        if(!intersection.assignToken(tokenType, id))
        {
            System.err.println("ERROR: Token not assigned: Position full");
        }
        else
        {
            this.token.placeToken(tokenType);
        }
    }
    
    
    @Override
    public boolean isMillActive(int intersectionId)
    {
        return mill.isMillActive(intersectionId);
    }
    
    @Override
    public boolean moveToken(int fromLocation, int toLocation, char color)
    {
        if (token.isThreeTokens(color))
        {
            char tokenToMove = intersection.removeToken(fromLocation);
            intersection.assignToken(tokenToMove, toLocation);
            return true;
        }
        else
        {
            int[] neighbours;
            neighbours = intersection.getNeighbourList(fromLocation);

            for (int n: neighbours)
            {
                if (n == toLocation)
                {
                    char tokenToMove = intersection.removeToken(fromLocation);
                    intersection.assignToken(tokenToMove, toLocation);
                    return true;
                }
            }
            return false;
        }
    }
    
    @Override
    public void undoLastMove()
    {
        Pair<Token, Intersection> newData = undoMove.restoreData();
        token = newData.t1;
        intersection = newData.t2;
        
        mill.checkMills();
    }
    
    @Override
    public void millFound(char color)
    {
        int pos;
        
        System.out.println("New mill has formed. ");
        if (color == 'W')
        {
            pos = playerOne.stealToken();
            
            if (pos == (-1))
            {
                return;
            }
            
            intersection.removeToken(pos);
            token.deactivateToken(Token.ColorType.BLACK);
        } else if (color == 'B')
        {
            pos = playerTwo.stealToken();
            
            if (pos == (-1))
            {
                return;
            }
            
            intersection.removeToken(pos);
            token.deactivateToken(Token.ColorType.WHITE);
        }
        
        board.drawBoard();
    }
    
    private void setup()
    {
        board.addListener(this);
        playerOne.addListener(this);
        playerTwo.addListener(this);
        mill.addListener(this);
        
        playerOne.askName();
        playerTwo.askName();
        
        board.drawBoard();
        undoMove.updateData(token, intersection);
        undoMove.updateData(token, intersection);
    }
    
    public void start()
    {
        setup();

        while (!token.checkWinner())
        {
            if (token.lessThanNine(Token.ColorType.WHITE))
            {
                playerOne.placeToken();
            }
            else
            {
                playerOne.moveToken();
            }

            board.drawBoard();
            undoMove.updateData(token, intersection);
            mill.checkMills();
            
            if (!token.checkWinner())
            {
                if (token.lessThanNine(Token.ColorType.BLACK))
                {
                    playerTwo.placeToken();
                }
                else
                {
                    playerTwo.moveToken();
                }
                board.drawBoard();
                undoMove.updateData(token, intersection);
                mill.checkMills();
            }
        }
        
        SCANNER.close();
    }
}
