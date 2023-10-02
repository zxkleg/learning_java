public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(2.2f);
        Pyramid pyramid = Pyramid.builder().side_length(2.2F).height(2.2F).build();

        System.out.println(cube.getSide_length());

        System.out.println(cube.getVolume());

        System.out.println(pyramid.getSide_length());
        System.out.println(pyramid.getHeight());

        System.out.print(pyramid.getVolume());
    }
}