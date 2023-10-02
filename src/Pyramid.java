import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class Pyramid implements Shape {
    private final float side_length;
    private final float height;
    public float getVolume() {
        return (float) 1 / 3 * this.side_length * side_length * side_length;
    }
}