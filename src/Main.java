public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(2.2F);
        Pyramid pyramid = new Pyramid(2.2F,2.2F);

        System.out.println(cube.getVolume());
        System.out.print(pyramid.getVolume());
    }
}