package Exercies;

public class CircleOject {
    private float raduis;

    public CircleOject(float raduis) {
        this.raduis = raduis;
    }

    public float getArea(){
        return (float) (Math.PI*raduis*raduis);
    }
}
