public class Lattice {
    private int altitude;
    private int visits = 0;
    public Lattice(int alt){
        this.altitude = alt;
    }
    public void visit(){
        this.visits++;
    }
    public void raise(){
        this.altitude++;
    }
    public void lower(){
        this.altitude--;
    }
    public int getAltitude() {
        return altitude;
    }
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
