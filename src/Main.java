public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(2.0f);
        Pyramid pyramid = Pyramid.builder().sideLength(2.0F).height(2.0F).build();

        System.out.println(cube.getSideLength());

        System.out.println(cube.getVolume());

        System.out.println(pyramid.getSideLength());
        System.out.println(pyramid.getHeight());

        System.out.print(pyramid.getVolume());
    }
}