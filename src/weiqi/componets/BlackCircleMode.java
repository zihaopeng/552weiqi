
package weiqi.componets;


public class BlackCircleMode implements Mode {
    public Shape create(int x1, int y1, int x2, int y2) {
        return new BlackCircle(x1,y1, x2-x1,y2-y1);
    }
}