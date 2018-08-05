package ninemanmorris;

/**
 *
 * @author scott
 */
public class Board
{
    private BoardInterface listen;
    
    private final String H_BIG = " --------- ";
    private final String H_MID = " ----- ";
    private final String H_SMALL = " - ";
    private final String THREE_SP = "   ";
    private final String SEVEN_SP = "       ";
    private final String ELEVEN_SP = "           ";
    
    public void addListener(BoardInterface listener)
    {
        this.listen = listener;
    }
    
    public void drawBoard()
    {
        System.out.println("   1" + THREE_SP + "2" + THREE_SP + "3" + THREE_SP +
                "4" + THREE_SP + "5" + THREE_SP + "6" + THREE_SP + "7");
        
        System.out.println("   _________________________\n");
        
        System.out.println("1) " + listen.getIntersectInfo(1) + H_BIG + listen.getIntersectInfo(2) +
                H_BIG + listen.getIntersectInfo(3));

        System.out.println("   |" + ELEVEN_SP + "|" + ELEVEN_SP + "|");
        
        System.out.println("2) |" + THREE_SP + listen.getIntersectInfo(4) + H_MID +
                listen.getIntersectInfo(5) + H_MID + listen.getIntersectInfo(6) + THREE_SP + "|");
        
        System.out.println("   |" + THREE_SP + "|" + SEVEN_SP + "|" + SEVEN_SP +
                "|" + THREE_SP + "|");
        
        System.out.println("3) |" + THREE_SP + "|" + THREE_SP + listen.getIntersectInfo(7) +
                H_SMALL + listen.getIntersectInfo(8) + H_SMALL + listen.getIntersectInfo(9) +
                THREE_SP + "|" + THREE_SP + "|");
        
        System.out.println("   |" + THREE_SP + "|" + THREE_SP + "|" + SEVEN_SP +
                "|" + THREE_SP + "|" + THREE_SP + "|");
        
        System.out.println("4) " + listen.getIntersectInfo(10) + H_SMALL + listen.getIntersectInfo(11) +
                H_SMALL + listen.getIntersectInfo(12) + SEVEN_SP + listen.getIntersectInfo(13) +
                H_SMALL + listen.getIntersectInfo(14) + H_SMALL + listen.getIntersectInfo(15));
        
        System.out.println("   |" + THREE_SP + "|" + THREE_SP + "|" + SEVEN_SP +
                "|" + THREE_SP + "|" + THREE_SP + "|");
        
        System.out.println("5) |" + THREE_SP + "|" + THREE_SP + listen.getIntersectInfo(16) +
                H_SMALL + listen.getIntersectInfo(17) + H_SMALL + listen.getIntersectInfo(18) +
                THREE_SP + "|" + THREE_SP + "|");
        
        System.out.println("   |" + THREE_SP + "|" + SEVEN_SP + "|" + SEVEN_SP +
                "|" + THREE_SP + "|");
        
        System.out.println("6) |" + THREE_SP + listen.getIntersectInfo(19) + H_MID +
                listen.getIntersectInfo(20) + H_MID + listen.getIntersectInfo(21) + THREE_SP + "|");
        
        System.out.println("   |" + ELEVEN_SP + "|" + ELEVEN_SP + "|");
        
        System.out.println("7) " + listen.getIntersectInfo(22) + H_BIG + listen.getIntersectInfo(23) +
                H_BIG + listen.getIntersectInfo(24));
    }
}
