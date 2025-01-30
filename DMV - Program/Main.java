import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
  private String make;
  private String model;
  private String vin;
  private String plateNumber;
  private int year;

  public Vehicle(String make, String model, String vin, String plateNumber, int year) {
    this.make = make;
    this.model = model;
    this.vin = vin;
    this.plateNumber = plateNumber;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Vehicle [make=" + make + ", model=" + model + ", vin=" + vin + ", plateNumber=" + plateNumber + ", year="
        + year + "]";
  }
}

class Owner {
  private String name;
  private String address;
  private ArrayList<Vehicle> vehicles;

  public Owner(String name, String address) {
    this.name = name;
    this.address = address;
    this.vehicles = new ArrayList<>();
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Owner [name=").append(name).append(", address=").append(address).append("]\n");
    sb.append("Vehicles:\n");
    for (Vehicle vehicle : vehicles) {
      sb.append(vehicle).append("\n");
    }
    return sb.toString();
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter your name:");
    String name = scanner.nextLine();

    System.out.println("Enter your address:");
    String address = scanner.nextLine();

    Owner owner = new Owner(name, address);

    while (true) {
      System.out.println("Enter vehicle make:");
      String make = scanner.nextLine();

      System.out.println("Enter vehicle model:");
      String model = scanner.nextLine();

      System.out.println("Enter vehicle VIN:");
      String vin = scanner.nextLine();

      System.out.println("Enter vehicle plate number:");
      String plateNumber = scanner.nextLine();

      System.out.println("Enter vehicle year:");
      int year = scanner.nextInt();
      scanner.nextLine(); // consume the newline

      Vehicle vehicle = new Vehicle(make, model, vin, plateNumber, year);
      owner.addVehicle(vehicle);

      System.out.println("Vehicle information:");
      System.out.println(vehicle);

      System.out.println("Do you want to add another vehicle? (yes/no)");
      String response = scanner.nextLine();
      if (!response.equalsIgnoreCase("yes")) {
        break;
      }
    }

    System.out.println("Owner and vehicle information:");
    System.out.println(owner);

    scanner.close();
  }
}
