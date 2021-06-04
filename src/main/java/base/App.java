/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Liam Pido
 */

/*
Exercise 23 - Troubleshooting Car Issues

An expert system is a type of artificial intelligence program that uses a knowledge base and a set of rules to perform a task that a human expert might do.
Many websites are available that will help you self-diagnose a medical issue by answering a series of questions.
And many hardware and software companies offer online troubleshooting tools to help people solve simple technical issues before calling a human.

Create a program that walks the user through troubleshooting issues with a car. Use the following decision tree to build the system:

@startuml
if (Is the car silent when you turn the key?) then (yes)
    if (Are the battery terminals corroded?) then (yes)
        :Clean terminals and try starting again.;
        stop
    else (no)
        :Replace cables and try again.;
        stop
    endif
else (no)
    if (Does the car make a slicking noise?) then (yes)
        :Replace the battery.;
        stop
    else (no)
        if (Does the car crank up but fail to start?) then (yes)
            :Check spark plug connections.;
            stop
        else (no)
            if (Does the engine start and then die?) then (yes)
                if (Does you car have fuel injection?) then (yes)
                    :Get it in for service.;
                    stop
                else (no)
                    :Check to ensure the choke is opening and closing.;
                    stop
                endif
            else (no)
                :This should not be possible.;
                stop
            endif
        endif
    endif
endif
@enduml

Example Output

Is the car silent when you turn the key? y
Are the battery terminals corroded? n
The battery cables may be damaged.
Replace cables and try again.

Constraint

Ask only questions that are relevant to the situation and to the previous answers. Don’t ask for all inputs at once.

Challenge

Investigate rules engines and inference engines. These are powerful ways to solve complex problems that are based on rules and facts. Identify a rules engine for your programming language and use it to solve this problem
 */

package base;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        String silent = myApp.readSilent();
        if(silent.toLowerCase().equals("y")) {
            String corroded = myApp.readCorroded();
            if(corroded.toLowerCase().equals("y")) {
                System.out.println("Clean terminals and try starting again.");
                return;
            } else {
                System.out.println("Replace cables and try again.");
                return;
            }
        } else {
            String slicking = myApp.readSlicking();
            if(slicking.toLowerCase().equals("y")) {
                System.out.println("Replace the battery.");
                return;
            } else {
                String crank = myApp.readCrank();
                if(crank.toLowerCase().equals("y")) {
                    System.out.println("Check spark plug connections.");
                    return;
                } else {
                    String engine = myApp.readEngine();
                    if(engine.toLowerCase().equals("y")) {
                        String fuel = myApp.readFuel();
                        if(fuel.toLowerCase().equals("y")) {
                            System.out.println("Get it in for service.");
                            return;
                        } else {
                            System.out.println("Check to ensure the choke is opening and closing.");
                            return;
                        }
                    } else {
                        System.out.println("This should not be possible.");
                        return;
                    }
                }
            }
        }

    }

    public String readFuel() {
        System.out.print("Does you car have fuel injection? ");
        String input = in.nextLine();
        return input;
    }

    public String readEngine() {
        System.out.print("Does the engine start and then die? ");
        String input = in.nextLine();
        return input;
    }

    public String readCrank() {
        System.out.print("Does the car crank up but fail to start? ");
        String input = in.nextLine();
        return input;
    }

    public String readSlicking() {
        System.out.print("Does the car make a slicking noise? ");
        String input = in.nextLine();
        return input;
    }

    public String readCorroded() {
        System.out.print("Are the battery terminals corroded? ");
        String input = in.nextLine();
        return input;
    }

    public String readSilent() {
        System.out.print("Is the car silent when you turn the key? ");
        String input = in.nextLine();
        return input;
    }
}
