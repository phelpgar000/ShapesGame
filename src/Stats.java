public class Stats {

    private static boolean leftPressed, rightPressed;

    public static void toggleLeft(){
        if(leftPressed){
            leftPressed = false;
        }
        else{
            leftPressed = true;
        }
    }

    public static void toggleRight(){
        if(rightPressed){
            rightPressed = false;
        }
        else{
            rightPressed = true;
        }
    }

    public static boolean isLeftPressed(){ return leftPressed;};
    public static boolean isRightPressed(){ return rightPressed;};

}
