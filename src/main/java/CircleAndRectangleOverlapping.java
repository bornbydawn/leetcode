public class CircleAndRectangleOverlapping {

    public static void main(String[] args) {
        CircleAndRectangleOverlapping circleAndRectangleOverlapping = new CircleAndRectangleOverlapping();
        //System.out.println(circleAndRectangleOverlapping.checkOverlap(1, 1, 1, -3, -3, 3, 3));
        System.out.println(circleAndRectangleOverlapping.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
     
        int closestX = 0;
        int closestY = 0;
        double distance = Integer.MAX_VALUE;

        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                double currDistance = Math.sqrt(Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2));
                if(currDistance < distance){
                    distance = currDistance;
                    closestX = x;
                    closestY = y;
                }
            }
        }

        if(Math.sqrt(Math.pow(closestX - x_center, 2) + Math.pow(closestY - y_center, 2)) <= radius){
            return true;
        }
        
        return false;
    }
}
