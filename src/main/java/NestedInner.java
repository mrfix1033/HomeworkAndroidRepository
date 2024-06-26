import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NestedInner {
    public static void main(String[] args) {

        class EngineParameters {
            private final char type;
            private final int numberOfPistons;
            private final int hp;

            public EngineParameters(char type, int numberOfPistons, int hp) {
                this.type = type;
                this.numberOfPistons = numberOfPistons;
                this.hp = hp;
            }

            public char getType() {
                return type;
            }

            public int getNumberOfPistons() {
                return numberOfPistons;
            }

            public int getHp() {
                return hp;
            }
        }

        class BreakSystemParameters {
            private final double force;
            private final List<Car.BreakSystem.BreakDisk> disks = new ArrayList<>();

            BreakSystemParameters(double force) {
                this.force = force;
                for (int i = 0; i < 4; i++)
                    disks.add(new Car.BreakSystem.BreakDisk("cast iron", "Very good"));
            }

            public double getForce() {
                return force;
            }

            public List<Car.BreakSystem.BreakDisk> getDisks() {
                return new ArrayList<>(disks);
            }
        }
        EngineParameters engineParameters = new EngineParameters('V', 8, 1160);
        BreakSystemParameters breakSystemParameters = new BreakSystemParameters(1280);

        Car car = new Car("Koenigsegg", 444.6, 1395, engineParameters.getType(), engineParameters.getNumberOfPistons(), engineParameters.getHp(), breakSystemParameters.getForce(), breakSystemParameters.getDisks());
        System.out.println(car.getCarBrand() + "\nEngine started: " + car.getEngine().start());
        System.out.println("Max speed: " + car.getSpeed());
        car.getBreakSystem().startBreaking();
        System.out.println("is breaking: " + car.getBreakSystem().isBreaking());
    }
}

class Car {
    private final String carBrand;
    private final double speed, weight;
    private final Engine engine;
    private final BreakSystem breakSystem;

    Car(String carBrand, double speed, double weight, char engineType, int engineNumberPoints, int engineHP, double breakSystemForce, List<BreakSystem.BreakDisk> disks) {
        this.carBrand = carBrand;
        this.speed = speed;
        this.weight = weight;
        engine = new Engine(engineType,
                engineNumberPoints,
                engineHP);
        breakSystem = new BreakSystem(breakSystemForce, disks);
    }

    public double getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    public Engine getEngine() {
        return engine;
    }

    public BreakSystem getBreakSystem() {
        return breakSystem;
    }

    class Engine {
        private final char type;
        private final List<Piston> pistons = new ArrayList<>();
        private boolean isStarted;
        private final int hp;

        Engine(char type, int numberPistons, int hp) {
            this.type = type;
            this.hp = hp;
            for (int i = 0; i < numberPistons; i++)
                pistons.add(new Piston("", "very good"));
        }

        public char getType() {
            return type;
        }

        public List<Piston> getPistons() {
            return new ArrayList<>(pistons);
        }

        public int getHp() {
            return hp;
        }

        class Piston {
            private final String material, status;  // very good, good, normal, bad

            Piston(String material, String status) {
                this.material = material;
                this.status = status;
            }
        }

        /**
         * Starts the engine
         *
         * @return is it successful
         */
        public boolean start() {
            if (!isStarted)
                isStarted = new Random().nextFloat() < 0.995;  // new car
            return isStarted;
        }

        public void stop() {
            isStarted = false;
        }

        public boolean isStarted() {
            return isStarted;
        }
    }

    class BreakSystem {
        private final double force;
        private final List<BreakDisk> disks;
        private boolean isBreaking = false;

        BreakSystem(double force, List<BreakDisk> disks) {
            this.force = force;
            this.disks = disks;
        }

        public double getForce() {
            return force;
        }

        public List<BreakDisk> getDisks() {
            return disks;
        }

        static class BreakDisk {
            private final String material, status;

            public BreakDisk(String material, String status) {
                this.material = material;
                this.status = status;
            }

            public String getMaterial() {
                return material;
            }

            public String getStatus() {
                return status;
            }
        }

        public void startBreaking() {
            isBreaking = true;
        }

        public void stopBreaking() {
            isBreaking = false;
        }

        public boolean isBreaking() {
            return isBreaking;
        }
    }

    public String getCarBrand() {
        return carBrand;
    }
}
