import processing.core.PApplet;
import processing.core.PFont;

public class U3Project extends PApplet {
    PFont myFont;

    Box box1 = new Box(100, 200, 100, 200, false, "_");
    Box box2 = new Box(200, 300, 100, 200, false, "_");
    Box box3 = new Box(300, 400, 100, 200, false, "_");
    Box box4 = new Box(100, 200, 200, 300, false, "_");
    Box box5 = new Box(200, 300, 200, 300, false, "_");
    Box box6 = new Box(300, 400, 200, 300, false, "_");
    Box box7 = new Box(100, 200, 300, 400, false, "_");
    Box box8 = new Box(200, 300, 300, 400, false, "_");
    Box box9 = new Box(300, 400, 300, 400, false, "_");

    String shapeCounter = "o";
    Box[] boxList;

    public void setup() {
        myFont = createFont("Georgia", 16);
        textFont(myFont);
        textAlign(CENTER, CENTER);
        background(255);
    }

    public void settings() {
        size(500, 500);

    }


    public void draw() {
        for (int i = 100; i <= 500; i += 100) {
            line(i, 100, i, 400);
            line(100, i, 400, i);
        }
        boxList = new Box[10];
        boxList[0] = box1;
        boxList[1] = box2;
        boxList[2] = box3;
        boxList[3] = box4;
        boxList[4] = box5;
        boxList[5] = box6;
        boxList[6] = box7;
        boxList[7] = box8;
        boxList[8] = box9;
    }


    public boolean winCheck(Box boxNum1, Box boxNum2, Box boxNum3) {
        boolean win = boxNum1.shapeType.equals(boxNum3.shapeType) && boxNum2.shapeType.equals(boxNum3.shapeType) && !boxNum1.shapeType.equals("_");
        if (win) {
            noStroke();
            if (boxNum1.shapeType.equals("o")) {
                fill(0, 0, 255);
            } else {
                fill(255, 0, 0);
            }
            rect(boxNum1.minX, boxNum1.minY, 100, 100);
            rect(boxNum2.minX, boxNum2.minY, 100, 100);
            rect(boxNum3.minX, boxNum3.minY, 100, 100);
            stroke(0);
            if (boxNum1.shapeType.equals("o")) {
                ellipse(boxNum1.minX + 50, boxNum1.minY + 50, 50, 50);
                ellipse(boxNum2.minX + 50, boxNum2.minY + 50, 50, 50);
                ellipse(boxNum3.minX + 50, boxNum3.minY + 50, 50, 50);
            } else {
                line(boxNum1.minX + 25, boxNum1.minY + 25, boxNum1.minX + 75, boxNum1.minY + 75);
                line(boxNum1.minX + 75, boxNum1.minY + 25, boxNum1.minX + 25, boxNum1.minY + 75);
                line(boxNum2.minX + 25, boxNum2.minY + 25, boxNum2.minX + 75, boxNum2.minY + 75);
                line(boxNum2.minX + 75, boxNum2.minY + 25, boxNum2.minX + 25, boxNum2.minY + 75);
                line(boxNum3.minX + 25, boxNum3.minY + 25, boxNum3.minX + 75, boxNum3.minY + 75);
                line(boxNum3.minX + 75, boxNum3.minY + 25, boxNum3.minX + 25, boxNum3.minY + 75);
            }
        }
        return win;
    }


    public void drawX(Box boxNum) {
        noStroke();
        fill(255, 190, 190);
        rect(boxNum.minX, boxNum.minY, 100, 100);
        stroke(0);
        boxNum.shapeType = "x";
        boxNum.hasShape = true;
        shapeCounter = "o";
        if (winCheck(box1, box2, box3)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box4, box5, box6)) {
            System.out.println(box4.shapeType + " wins!");
        } else if (winCheck(box7, box8, box9)) {
            System.out.println(box7.shapeType + " wins!");
        } else if (winCheck(box1, box4, box7)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box2, box5, box8)) {
            System.out.println(box2.shapeType + " wins!");
        } else if (winCheck(box3, box6, box9)) {
            System.out.println(box3.shapeType + " wins!");
        } else if (winCheck(box1, box5, box9)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box3, box5, box7)) {
            System.out.println(box3.shapeType + " wins!");
        }
        line(boxNum.minX + 25, boxNum.minY + 25, boxNum.minX + 75, boxNum.minY + 75);
        line(boxNum.minX + 75, boxNum.minY + 25, boxNum.minX + 25, boxNum.minY + 75);
    }

    public void drawO(Box boxNum) {
        noStroke();
        fill(190, 220, 255);
        rect(boxNum.minX, boxNum.minY, 100, 100);
        stroke(0);
        boxNum.shapeType = "o";
        boxNum.hasShape = true;
        shapeCounter = "x";
        if (winCheck(box1, box2, box3)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box4, box5, box6)) {
            System.out.println(box4.shapeType + " wins!");
        } else if (winCheck(box7, box8, box9)) {
            System.out.println(box7.shapeType + " wins!");
        } else if (winCheck(box1, box4, box7)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box2, box5, box8)) {
            System.out.println(box2.shapeType + " wins!");
        } else if (winCheck(box3, box6, box9)) {
            System.out.println(box3.shapeType + " wins!");
        } else if (winCheck(box1, box5, box9)) {
            System.out.println(box1.shapeType + " wins!");
        } else if (winCheck(box3, box5, box7)) {
            System.out.println(box3.shapeType + " wins!");
        }
        ellipse(boxNum.minX + 50, boxNum.minY + 50, 50, 50);
    }

    public void mouseClicked() {
        for (int i = 0; i < 9; i++) {
            if (boxList[i].minX < mouseX && mouseX < boxList[i].maxX && boxList[i].minY < mouseY && mouseY < boxList[i].maxY && !boxList[i].hasShape) {
                if (shapeCounter.equals("o")) {
                    drawO(boxList[i]);
                } else {
                    drawX(boxList[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        PApplet.main(new String[]{"U3Project"});

    }
}