public class Stats {

    private static boolean leftPressed, rightPressed;
    private static Integer Score = new Integer(0);

    public static void leftYes(){
        leftPressed = true;
    }

    public static void rightYes(){
            rightPressed = true;

    }

    public static void leftNo(){
        leftPressed = false;
    }

    public static void rightNo(){
        rightPressed = false;

    }

    public static void increaseScore(){
        Score += 100;
    }

    public static void decreaseScore(){
        Score += -300;
    }


    public static Integer getScore(){ return Score;}
    public static boolean isLeftPressed(){ return leftPressed;}
    public static boolean isRightPressed(){ return rightPressed;}

}
