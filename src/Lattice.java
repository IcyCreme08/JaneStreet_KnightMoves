public class Lattice {
    private double altitude;
    private int visits = 0;
    public Lattice(int alt){
        altitude = alt;
    }
    public void visit(){
        visits++;
    }
    public void raise(){
        altitude++;
    }
    public void lower(){
        altitude--;
    }
    public double getAltitude() {
        return altitude;
    }
    public int getVisits(){
        return visits;
    }
    public void setAltitude(double newAltitude) {
        altitude = newAltitude;
    }
}
