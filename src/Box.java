import processing.core.PApplet;
public class Box extends PApplet{
boolean hasShape;
int minX;
int maxX;
int minY;
int maxY;
String shapeType;

public Box(int x1, int x2, int y1, int y2, boolean isFilled, String fillType) {
    hasShape = isFilled;
    minX = x1;
    maxX = x2;
    minY = y1;
    maxY = y2;
    shapeType = fillType;

}

public void fillBox(boolean isFilled, String fillType) {
    hasShape = isFilled;
    shapeType = fillType;

}

}
