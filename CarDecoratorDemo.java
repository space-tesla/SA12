// Component Interface
interface Car {
    void assemble();
}

// Concrete Component
class BasicCar implements Car {
    public void assemble() {
        System.out.print("Basic Car");
    }
}

// Abstract Decorator
class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    public void assemble() {
        car.assemble();
    }
}

// Concrete Decorator: Sports Car
class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" + Sports Features");
    }
}

// Concrete Decorator: Luxury Car
class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" + Luxury Features");
    }
}

// Test class
public class CarDecoratorDemo {
    public static void main(String[] args) {

        System.out.println("---- Basic Car ----");
        Car basic = new BasicCar();
        basic.assemble();

        System.out.println("\n\n---- Sports Car ----");
        Car sports = new SportsCar(new BasicCar());
        sports.assemble();

        System.out.println("\n\n---- Luxury Car ----");
        Car luxury = new LuxuryCar(new BasicCar());
        luxury.assemble();

        System.out.println("\n\n---- Sports + Luxury Car ----");
        Car sportsLuxury = new LuxuryCar(new SportsCar(new BasicCar()));
        sportsLuxury.assemble();
    }
}
