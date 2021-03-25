package SystemDesign;

public class lc1603 {

}
class ParkingSystem {
    int[] park;
    public ParkingSystem(int big, int medium, int small) {
        this.park=new int[]{big,medium,small};
    }

    public boolean addCar(int carType) {
        if (park[carType-1]>0){
            park[carType-1]--;
            return true;
        }
        else {
            return false;
        }
    }
}

