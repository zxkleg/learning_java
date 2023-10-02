public class Cube implements Shape {
    private final float side_length;
    public Cube(float side_length){
        this.side_length = side_length;
    }
    @Override
    public float getVolume() {
        return this.side_length *this.side_length * this.side_length;
    }
}
