package ninemanmorris;

/**
 *
 * @author scott
 */
public interface PlayerInterface
{
    char getIntersectInfo(int id);
    void putToken(char token, int id);
    boolean isMillActive(int intersectionId); ///for steal token
    boolean moveToken(int fromLocation, int toLocation, char color);
    void undoLastMove();
}