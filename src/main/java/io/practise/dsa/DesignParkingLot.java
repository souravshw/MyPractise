package io.practise.dsa;

import java.util.*;

public class DesignParkingLot {

    public enum VehicleType { BIKE, CAR, TRUCK }

    public abstract static class Vehicle {
        VehicleType type;
        String license;
        public Vehicle(VehicleType type, String license) {
            this.type = type;
            this.license = license;
        }
    }

    public static class Car extends Vehicle {
        public Car(String license) { super(VehicleType.CAR, license); }
    }

    public static class ParkingSpot {
        VehicleType type;
        boolean isFree;
        Vehicle vehicle;
        public ParkingSpot(VehicleType type) {
            this.type = type;
            this.isFree = true;
        }
        public boolean park(Vehicle v) {
            if (isFree && v.type == type) {
                this.vehicle = v;
                isFree = false;
                return true;
            }
            return false;
        }
        public void leave() {
            this.vehicle = null;
            isFree = true;
        }
    }

    public static class ParkingLot {
        List<ParkingSpot> spots;
        public ParkingLot(List<ParkingSpot> spots) {
            this.spots = spots;
        }
        public boolean parkVehicle(Vehicle v) {
            for (ParkingSpot s : spots) {
                if (s.park(v)) return true;
            }
            return false;
        }
        public void unparkVehicle(Vehicle v) {
            for (ParkingSpot s : spots) {
                if (s.vehicle == v) {
                    s.leave();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ParkingSpot spot1 = new ParkingSpot(VehicleType.CAR);
        ParkingLot lot = new ParkingLot(List.of(spot1));
        Car car = new Car("MH12-1234");

        System.out.println("--- Design Parking Lot Demonstration ---");
        System.out.println("Parking Car: " + lot.parkVehicle(car)); // true
        System.out.println("Parking same Car again (no spot): " + lot.parkVehicle(car)); // false
    }
}
