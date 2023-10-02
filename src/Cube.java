import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Cube implements Shape {
    private final float side_length;
    public float getVolume(){
        return this.side_length * this.side_length * this.side_length;
    }
}