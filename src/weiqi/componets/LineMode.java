
package weiqi.componets;


public class LineMode implements Mode {
    public Shape create(int x1, int y1, int x2, int y2) {
        return new Line(x1,y1, x2,y2);
    }
}