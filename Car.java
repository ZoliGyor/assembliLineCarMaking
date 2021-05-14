import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    private String name;
    private int secondsToBuild;
    private Engine engine;
    private Frame frame; 
    private ArrayList<Seat> seats = new ArrayList<Seat>();
    private ArrayList<Tire> tires = new ArrayList<Tire>();

    public Car(){
        System.out.println("Welcome to my Car making game! Your objective is to build a car. First of all, what will be the name of your car?");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        
        
        System.out.println("Okay, now you will build your car, named " + name + ". Here are the rules:");
        System.out.println("A fully built car consists of the following things: 4 tires, 5 seats, 1 engine and 1 frame");
        System.out.println("However, it takes different time for the constructor to build and insert a part of the car.");
        System.out.println("A tire takes 2 seconds\nA seat takes 3 seconds\nAn engine takes 7 seconds\nAnd a frame takes 5 seconds to be built");

        int counterForEngine = 0;
        int counterForFrame = 0;

        String instruction = "";

        int counter = 0;

        while (counterForEngine < 1 || counterForFrame < 1 || seats.size() < 5  || tires.size() < 4){
            System.out.println("What 3 items would you like to add to your card?\nTo add an Engine write: 1\nTo add a Frame write: 2\nTo add a Seat write: 3\nTo add a Tire write: 4");
            instruction = scanner.nextLine();
            System.out.print("Adding a(n) ");
            while(counter < 3){
                if(counterForEngine == 1 && counterForFrame == 1 && seats.size() == 5 && tires.size() == 4){
                    break;
                }
                if(instruction.equals("1")){
                    if(counterForEngine < 1){
                        System.out.println("Engine");
                        counterForEngine++;
                        counter++;
                        engine = new Engine();
                        secondsToBuild += engine.getSecondsToBuildOne();
                        System.out.println("You have " + counterForEngine + " engines");
                    }else{
                        System.out.println("\nYou cannot have more than 1 enginge in your car");
                    }
                }else if(instruction.equals("2")){
                    if(counterForFrame < 1){
                        System.out.println("Frame");
                        counterForFrame++;
                        counter++;
                        frame = new Frame();
                        secondsToBuild += frame.getSecondsToBuildOne();
                        System.out.println("You have " + counterForFrame + " frames");
                    }else{
                        System.out.println("\nYou cannot have more than 1 frame in your car");
                    }
                }else if(instruction.equals("3")){
                    if(seats.size() < 5){
                        System.out.println("Seat");
                        counter++;
                        seats.add(new Seat());
                        secondsToBuild += new Seat().getSecondsToBuildOne();
                        System.out.println("You have " + seats.size() + " seats");
                    }else{
                        System.out.println("\nYou cannot have more than 5 seats in your car");
                    }
                }else if(instruction.equals("4")){
                    if(tires.size() < 4){
                        System.out.println("Tire");
                        counter++;
                        tires.add(new Tire());
                        secondsToBuild += new Tire().getSecondsToBuildOne();
                        System.out.println("You have " + tires.size() + " tires");
                    }else{
                        System.out.println("\nYou cannot have more than 4 tires in your car");
                    }
                }else{
                    System.out.println("ERROR, please make sure you write a number between 1 and 4");
                }
                if(counter != 3){
                    instruction = scanner.nextLine();
                }
            }
            System.out.println("Your time currenlty is: " + secondsToBuild);
            counter = 0;
            System.out.println("Your car, " + name + " currently has the following parts:\nEngine: " + counterForEngine + "\nFrame: " + counterForFrame
            + "\nSeats: " + seats.size() + "\nTires: " + tires.size());
            System.out.println("Counter is: " + counter);
        }
        System.out.println("In the end, it took you " + secondsToBuild + " seconds to build a car. Well done!");
    }
}