import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "Vehicle Details: \n" + "Make: " + make + ", Model: " + model + ", VIN: " + vin + ", PlateNumber: " + plateNumber + ", Year: " + year;
    }
}
class Owner {
    private String name;
    private String address;
    private String phoneNumber;
    private Vehicle[] vehicles; 
    private int vehicleCount;
    public Owner(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.vehicles = new Vehicle[10]; 
        this.vehicleCount = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Vehicle[] getVehicles() {
        return vehicles;
    }
    public void addVehicle(Vehicle vehicle) {
        if (vehicleCount < 10) {
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Cannot add more than 10 vehicles.");
        }
    }
    @Override
    public String toString() {
        StringBuilder vehiclesList = new StringBuilder();
        for (int i = 0; i < vehicleCount; i++) {
            vehiclesList.append(vehicles[i].toString()).append("\n");
        }
        return "Owner Details: \n" + "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", Vehicles: \n" + vehiclesList;
    }
}
class DepartmentOfMotorVehicles {
    private String name;
    private String location;
    private Vehicle[] registeredVehicles;
    private int vehicleCount;
    public DepartmentOfMotorVehicles(String name, String location) {
        this.name = name;
        this.location = location;
        this.registeredVehicles = new Vehicle[100]; 
        this.vehicleCount = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPlateNumber() {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder plate = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            plate.append(characters.charAt(random.nextInt(characters.length())));
        }
        plate.append(random.nextInt(9000) + 1000); 
        return plate.toString();
    }
    public boolean isVehicleRegistered(Vehicle vehicle) {
        for (int i = 0; i < vehicleCount; i++) {
            if (registeredVehicles[i].getVin().equals(vehicle.getVin())) {
                return true;
            }
        }
        return false;
    }
    public void registerVehicle(Vehicle vehicle) {
        if (vehicleCount < 100) {
            registeredVehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Cannot register more than 100 vehicles.");
        }
    }
    @Override
    public String toString() {
        return "DMV: " + "Name: " + name + ", Location: " + location;
    }
}
class Registration {
    private Vehicle vehicle;
    private Owner owner;
    private String registrationNumber;
    private String registrationDate;
    public Registration(Vehicle vehicle, Owner owner) {
        this.vehicle = vehicle;
        this.owner = owner;
        this.registrationNumber = generateRegistrationNumber();
        this.registrationDate = getCurrentDate();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public boolean isRegistrationValid() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date regDate = sdf.parse(registrationDate);
            long diff = new Date().getTime() - regDate.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            return days <= 365; 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private String generateRegistrationNumber() {
        return "REG-" + new Random().nextInt(10000); 
    }
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    @Override
    public String toString() {
        return "Registration Details: \n" + vehicle.toString() + ", Owner: " + owner.getName() + ", RegistrationNumber: " + registrationNumber + ", RegistrationDate: " + registrationDate;
    }
}
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Toyota", "86", "1HGBH41JXMN109186", "ABC123", 1986);
        Vehicle vehicle2 = new Vehicle("Nissan", "350z", "2HGES26797H512345", "DEF456", 2005);
        Owner owner1 = new Owner("Carlos Zabala", "3250 93rd Street", "929-992-9292");
        owner1.addVehicle(vehicle1);
        owner1.addVehicle(vehicle2);
        DepartmentOfMotorVehicles dmv = new DepartmentOfMotorVehicles("City DMV", "Junction Blvd");
        dmv.registerVehicle(vehicle1);
        dmv.registerVehicle(vehicle2);
        Registration reg1 = new Registration(vehicle1, owner1);
        Registration reg2 = new Registration(vehicle2, owner1);
        System.out.println(owner1.toString());
        System.out.println(dmv.toString());
        System.out.println(reg1.toString());
        System.out.println(reg2.toString());
        System.out.println("Is vehicle1 registration valid? " + reg1.isRegistrationValid());
        System.out.println("Is vehicle2 registration valid? " + reg2.isRegistrationValid());
    }
}