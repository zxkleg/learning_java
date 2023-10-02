import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Cube implements Shape {
    private final float sideLength;
    public float getVolume(){
        return this.sideLength * this.sideLength * this.sideLength;
    }
}