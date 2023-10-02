public class Pyramid implements Shape {
    private final float side_length;
    private final float hight;
    public Pyramid(float side_length, float hight){
        this.side_length = side_length;
        this.hight = hight;
    }
    @Override
    public float getVolume() {
        return  1F / 3F * this.side_length * this.side_length * this.hight;
    }
}
