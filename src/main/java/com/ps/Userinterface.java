package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class Userinterface {
    private Dealership dealership;
    public Scanner scanner = new Scanner(System.in);

    private void init() {
        dealership = DealershipFileManager.getDealership();
        DealershipFileManager.saveDealership(dealership);
    }

    public Userinterface() {
        init();
    }

    public void display() {
        int mainMenuCommand;
        System.out.println("Welcome to Car dealership App");
        do {
            System.out.println("\n------Main Menu Commands-------");
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("c. Sell/ Lease A Vehicle");
            System.out.println("0. EXIT");
            System.out.print("Command:");

            if (scanner.hasNextInt()) {
                mainMenuCommand = scanner.nextInt();
            } else {
                String input = scanner.nextLine();
                if (input.length() == 1) {
                    mainMenuCommand = input.charAt(0);
                } else {
                    mainMenuCommand = -1;
                }
            }

            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 'c':
                    saleOrLeaseVehicle();
                    break;
                case 0:
                    System.out.println("Exiting...");
                default:
            }
        } while (mainMenuCommand != 0);
    }//Main menu

    private void saleOrLeaseVehicle() {
        int contractMenuCommand;
        do {
            System.out.println("---Dealership Contacts Menu---");
            System.out.println("1. Sale Contact");
            System.out.println("2. Lease Contract");
            System.out.println("0. Back to Main Menu");
            System.out.print("\nCommand:");
            contractMenuCommand = scanner.nextInt();
            switch (contractMenuCommand) {
                case 1:
                    saleContract();
                    break;
                case 2:
                    leaseContract();
                    break;
                case 0:
                    System.out.println("Going Back to Main Menu.");
                    display();//
                    break;
                default:
            }
        } while (contractMenuCommand != 0);
    }//menu

    private void saleContract() {
        //todo create an if statement, if the veh is sold then final sale option or not then use the finance option
        System.out.println("Are you financing today?");
        boolean financing = true;
        if (!financing) {
            System.out.println("financing the vehicle");
            //todo input vin for veh info, then purchasers info
        } else {
            System.out.println("Cash Purchase");
            //todo input vin for veh info, then purchasers info
            System.out.print("Input VIN:");
            int pVin = scanner.nextInt();
            ArrayList<Vehicle>saleInProgress=dealership.

        }
    }// needs work

    private void leaseContract() {
        System.out.println("You are Leasing a Vehicle today!");

    }// needs work

    private void processGetByPriceRequest() {
        System.out.println("---display vehicles by price---");
        System.out.print("min:");
        double min = scanner.nextDouble();

        System.out.print("max:");
        double max = scanner.nextDouble();
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByPrice(min, max);
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetByMakeModelRequest() {
        System.out.println("---display vehicles by Make and Model---");
        System.out.print("Make:");
        String make = scanner.next();

        System.out.print("Model:");
        String model = scanner.next();
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMakeModel(make, model);
        System.out.println("your filtered result:\n");
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetByYearRequest() {
        System.out.println("---display vehicles by Year---");
        System.out.print("Starting Year:");
        int startYear = scanner.nextInt();

        System.out.print("Ending Year:");
        int endingYear = scanner.nextInt();
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByYear(startYear, endingYear);
        System.out.println("your filtered result:\n");
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetByColorRequest() {
        System.out.println("---display vehicles by Color---");
        System.out.print("Make:");
        String color = scanner.next();
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByColor(color);
        System.out.println("your filtered result:\n");
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetByMileageRequest() {
        System.out.println("---display vehicles by Mileage---");
        System.out.print("Min Mileage:");
        int minMileage = scanner.nextInt();

        System.out.print("Max Mileage:");
        int maxMileage = scanner.nextInt();
        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMileage(minMileage, maxMileage);
        System.out.println("your filtered result:\n");
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetByVehicleTypeRequest() {
        System.out.println("---display vehicles by Type---");
        System.out.print("Type:");
        String type = scanner.next();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByType(type);
        System.out.println("your filtered result:\n");
        displayVehicles(filteredVehicles);
    }//Done

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("All the Vehicle available");
        displayVehicles(vehicles);
    }//Done

    private void processAddVehicleRequest() {
        System.out.println("---Add a vehicle details for new inventory---\n");
        System.out.print("Vin:");
        int vin = scanner.nextInt();
        System.out.print("Year:");
        int year = scanner.nextInt();
        System.out.print("Make:");
        String make = scanner.next();
        System.out.print("Model:");
        String model = scanner.next();
        System.out.print("Type:");
        String type = scanner.next();
        System.out.print("Color:");
        String color = scanner.next();
        System.out.print("Odometer:");
        int odometer = scanner.nextInt();
        System.out.print("Price:");
        double price = scanner.nextDouble();

        Vehicle addVehicle = new Vehicle(vin, year, make, model.trim(), type.trim(), color.trim(), odometer, price);
        dealership.addVehicle(addVehicle);
        DealershipFileManager.saveDealership((dealership));
        System.out.println("Vehicle has been SUCCESSFULLY added to inventory.");

    }//Done

    private void processRemoveVehicleRequest() {
        System.out.println("---Remove a vehicle from the inventory---\n");
        System.out.print("Vin:");
        int vin = scanner.nextInt();
        ArrayList<Vehicle> rmVehicle = dealership.getAllVehicles();
        for (Vehicle vehicle : rmVehicle) {
            if (vin == vehicle.getVin()) {
                dealership.removeVehicle(vehicle);
                DealershipFileManager.saveDealership(dealership);
                System.out.println("Vehicle has been SUCCESSFULLY removed from inventory.");
                break;
            }
        }
    }// Done

    public static void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }//done
}