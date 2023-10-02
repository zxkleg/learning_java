import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class Pyramid implements Shape {
    private final float sideLength;
    private final float height;
    public float getVolume() {
        return (float) 1 / 3 * this.sideLength * this.sideLength * this.height;
    }
}