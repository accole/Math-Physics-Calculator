/*
Menu program to calculate simple calculations in physics and calculus like
Work, Power, Force, Acceleration, Friction, etc.

created by Adam Cole
08/31/17
 */
package mathphyscalc;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class MathPhyscalc {

    private static final double g = 9.8;

    public static void main(String[] args) {
        // Welcome page and the menu header
        String[] options = {"Physics", "Calculus", "EXIT"};
        String[] physoptions = {"F=ma", "Friction", "Work", "Power", "BACK"};
        String[] calcoptions = {"derivative", "integral", "summation rules", "formula sheet", "Trig", "BACK"};
        int option;
        int physoption;
        int calcoption;
        DecimalFormat dec = new DecimalFormat("00.00");
        do {
            option = JOptionPane.showOptionDialog(null, "Choose a topic", "Topics",
                    JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    options, options[0]);
            switch (option) {
                case 0:
                    //Physics
                    do {
                        physoption = JOptionPane.showOptionDialog(null, "Choose a formula:",
                                "Physics", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                                null, physoptions, physoptions[0]);
                        switch (physoption) {
                            case 0:
                                //F=MA
                                String[] newt = {"Force", "Mass", "Acceleration", "BACK"};
                                int fmaoption;
                                do {
                                    fmaoption = JOptionPane.showOptionDialog(null,
                                            "Which variable are you solving for?",
                                            "select a variable", JOptionPane.NO_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE, null, newt, newt[0]);
                                    switch (fmaoption) {
                                        case 0:
                                            double mass = Double.parseDouble(JOptionPane.showInputDialog("enter mass in Kg"));
                                            double acceleration = Double.parseDouble(JOptionPane.showInputDialog("enter acceleration in m/s^2"));
                                            JOptionPane.showMessageDialog(null, dec.format(Force(0.0, mass, acceleration)) + " N");
                                            break;
                                        case 1:
                                            double force = Double.parseDouble(JOptionPane.showInputDialog("enter force in N"));
                                            double acceleration2 = Double.parseDouble(JOptionPane.showInputDialog("enter acceleration in m/s^2"));
                                            JOptionPane.showMessageDialog(null, dec.format(Force(force, 0.0, acceleration2)) + " Kg");
                                            break;
                                        case 2:
                                            double force2 = Double.parseDouble(JOptionPane.showInputDialog("enter force in N"));
                                            double mass2 = Double.parseDouble(JOptionPane.showInputDialog("enter mass in Kg"));
                                            JOptionPane.showMessageDialog(null, dec.format(Force(force2, mass2, 0.0)) + " m/s^2");
                                            break;
                                        case 3:
                                            break;
                                    }
                                } while (fmaoption != -1 && fmaoption != 3);
                                break;
                            case 1:
                                //Friction
                                double coeff = Double.parseDouble(JOptionPane.showInputDialog("enter the coefficient of friction"));
                                double mass = Double.parseDouble(JOptionPane.showInputDialog("enter the mass of the object in kg"));
                                int incline = JOptionPane.showConfirmDialog(null,
                                        "is the friction on a slope?", "is theta involved?", JOptionPane.YES_NO_OPTION);
                                int yesno;
                                yesno = JOptionPane.showConfirmDialog(null,
                                        "is the object on earth?", "select planet",
                                        JOptionPane.YES_NO_OPTION);
                                if (incline == JOptionPane.NO_OPTION) {
                                    double gravity;
                                    if (yesno == JOptionPane.YES_OPTION) {
                                        gravity = g;
                                    } else {
                                        gravity = Double.parseDouble(
                                                JOptionPane.showInputDialog("enter the"
                                                        + " magnitude of the gravitational force"));
                                    }
                                    JOptionPane.showMessageDialog(null, dec.format(Friction(coeff, mass, gravity))
                                            + "N of frictional force");
                                } else {
                                    String[] trig = {"sin", "cos"};
                                    int sincos = JOptionPane.showOptionDialog(null,
                                            "choose a trig function", "trig",
                                            JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, trig, trig[0]);
                                    double theta = Double.parseDouble(JOptionPane.showInputDialog("enter the angle in degrees"));
                                    theta = Degree2Radian(theta);
                                    switch (sincos) {
                                        case 0:
                                            double gravity;
                                            if (yesno == JOptionPane.YES_OPTION) {
                                                gravity = g;
                                            } else {
                                                gravity = Double.parseDouble(
                                                        JOptionPane.showInputDialog("enter the"
                                                                + " magnitude of the gravitational force"));
                                            }
                                            JOptionPane.showMessageDialog(null,
                                                    dec.format(Friction(coeff, mass, gravity, Math.sin(theta)))
                                                    + "N of frictional force");
                                            break;
                                        case 1:
                                            double gravity2;
                                            if (yesno == JOptionPane.YES_OPTION) {
                                                gravity2 = g;
                                            } else {
                                                gravity2 = Double.parseDouble(
                                                        JOptionPane.showInputDialog("enter the"
                                                                + " magnitude of the gravitational force"));
                                            }
                                            JOptionPane.showMessageDialog(null,
                                                    dec.format(Friction(coeff, mass, gravity2, Math.cos(theta)))
                                                    + "N of frictional force");
                                            break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "If the force applied to the object is less"
                                        + " than the static friction force then the object will not move."
                                        + "\n\nIf greater, the box will accelerate down the slope with a force that "
                                        + "is the difference between the static force and the force applied");
                                break;
                            case 2:
                                //Work
                                //W->=FDcos(theta) or F dot F
                                String[] choices = {"F * D", "FDcos@", "BACK"};
                                int choice = JOptionPane.showOptionDialog(null, "Calculate using dot products or multiplication?"
                                        , "choose function", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
                                switch (choice) {
                                    case 0:
                                        //dot product
                                        int fx = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "enter the x component of the Force vector"));
                                        int fy = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "enter the y component of the Force vector"));
                                        int dx = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "enter the x component of the Displacement vector"));
                                        int dy = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                "enter the y component of the Displacement vector"));
                                        JOptionPane.showMessageDialog(null, dec.format(Work(fx,fy,dx,dy) + " J of work done"));
                                        break;
                                    case 1:
                                        //multiplication
                                        double force = Double.parseDouble(JOptionPane.showInputDialog(null,
                                                "enter the magnitude of the force"));
                                        double displacement = Double.parseDouble(JOptionPane.showInputDialog(null,
                                                "enter the magnitude of the force"));
                                        double theta = Double.parseDouble(JOptionPane.showInputDialog(null,
                                                "enter the angle between the force and the displacement"));
                                        theta = Degree2Radian(theta);
                                        JOptionPane.showMessageDialog(null, dec.format(Work(force, displacement, theta)) + "J of work done");
                                        break;
                                    case 2:
                                        //back
                                        break;
                                }
                                break;
                            case 3:
                                //Powera
                                //power = W/S or FV
                                String[] power = {"Work/seconds", "Force x Velocity", "Comparison", "BACK"};
                                int pow = JOptionPane.showOptionDialog(null, "Calculate using work or velocity?", 
                                        "choose a method", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                        null, power, power[0]);
                                switch (pow) {
                                    case 0:
                                        //work/seconds
                                        double work = Double.parseDouble(JOptionPane.showInputDialog(
                                                "enter the work done in Joules"));
                                        double time = Double.parseDouble(JOptionPane.showInputDialog(
                                                "enter the interval of time taken in seconds"));
                                        JOptionPane.showMessageDialog(null, dec.format(Power2(work,
                                                time)) + " Watts of power");
                                        break;
                                    case 1:
                                        //force x velocity
                                        double force = Double.parseDouble(JOptionPane.showInputDialog(
                                                "enter the amount of force applied in newtons"));
                                        double velocity = Double.parseDouble(JOptionPane.showInputDialog(
                                                "enter the velocity of the object in m/s"));
                                        JOptionPane.showMessageDialog(null, dec.format(Power(force,
                                                velocity)) + " Watts of power");
                                        break;
                                    case 2:
                                        //comparison
                                        double w1 = Double.parseDouble(JOptionPane.showInputDialog(
                                                null, "enter the work done in Joules", "first object", JOptionPane.INFORMATION_MESSAGE));
                                        double t1 = Double.parseDouble(JOptionPane.showInputDialog(
                                                null, "enter the interval of time taken in seconds", "first object", JOptionPane.INFORMATION_MESSAGE));
                                        double w2 = Double.parseDouble(JOptionPane.showInputDialog(
                                                null, "enter the work done in Joules", "second object", JOptionPane.INFORMATION_MESSAGE));
                                        double t2 = Double.parseDouble(JOptionPane.showInputDialog(
                                                null, "enter the interval of time taken in seconds", "second object", JOptionPane.INFORMATION_MESSAGE));
                                        if (Power2(w1,t1) - Power2(w2,t2) == 0) {
                                            JOptionPane.showMessageDialog(null, "The objects are equally powerful");
                                        } else if (MorePower(w1,t1,w2,t2)) {
                                            JOptionPane.showMessageDialog(null, "Object 1 is more powerful by " 
                                                    + dec.format(Power2(w1,t1) - Power2(w2,t2)) + " Watts");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Object 2 is more powerful by " 
                                                    + dec.format(Power2(w2,t2) - Power2(w1,t1)) + " Watts");
                                        }
                                        break;
                                    case 3:
                                        //back
                                        break;
                                }
                                break;
                            case 4:
                                //Back
                                break;
                        }
                    } while (physoption != -1 && physoption != 4);
                    break;
                case 1:
                    //Math
                    do {
                        calcoption = JOptionPane.showOptionDialog(null, "choose a function",
                                "Calculus", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, calcoptions, calcoptions[0]);
                        switch (calcoption) {
                            case 0:
                                //differentiate
                                break;
                            case 1:
                                //integrate
                                break;
                            case 2:
                                //summation rules
                                break;
                            case 3:
                                //formula sheet
                                break;
                            case 4:
                                //Trig
                                String[] trig = {"sin", "cos", "tan"};
                                int trigoption = JOptionPane.showOptionDialog(null,
                                        "Choose a trig function", "Trig", JOptionPane.NO_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE, null, trig, trig[0]);
                                double angle = Double.parseDouble(JOptionPane.showInputDialog("enter theta in degrees"));
                                angle = Degree2Radian(angle);
                                switch (trigoption) {
                                    case 0:
                                        //sin
                                        JOptionPane.showMessageDialog(null, dec.format(Math.sin(angle)));
                                        break;
                                    case 1:
                                        //cos
                                        JOptionPane.showMessageDialog(null, dec.format(Math.cos(angle)));
                                        break;
                                    case 2:
                                        //tan
                                        if (angle == Math.PI / 2 || angle == 3 * Math.PI / 2) {
                                            JOptionPane.showMessageDialog(null, "undefined");
                                        } else {
                                            JOptionPane.showMessageDialog(null, dec.format(Math.tan(angle)));
                                        }
                                        break;
                                }
                                break;
                            case 5:
                                //Back
                                break;
                        }
                    } while (calcoption != -1 && calcoption != 5);
                    break;
            }
        } while (option != -1 && option != 2);
    }

    
    
    
    
//------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    private static double Force(double force, double mass, double acceleration) {
        //F=MA method
        //
        //PRE: all units are correct - force in N, mass in KG, acceleration in m/s^2
        //POST: force, mass, or acceleration is returned in a dec format
        double f = force;
        double m = mass;
        double a = acceleration;
        if (f == 0.0) {
            //find force
            return m * a;
        } else if (m == 0.0) {
            //find mass
            return f / a;
        } else {
            return f / m;
        }
    }

    private static double Friction(double coeff, double mass, double gravity) {
        //Friction on a flat surface method
        //
        //PRE: all units are correct (mass=kg) (gravity=m/s^2)
        //POST: frictional force in newtons is returned
        return coeff * mass * gravity;
    }

    private static double Friction(double coeff, double mass, double gravity, double angle) {
        //Friction on a sloped surface method
        //
        //PRE: all units are correct (mass=kg) (gravity=m/s^2) (angle=trig(radians))
        //POST: frictional force is returned in newtons
        return coeff * mass * gravity * angle;
    }

    private static double Degree2Radian(double degree) {
        //PRE: valid degree measure is inputted 0<angle,360
        //POST: angle in radians is returned
        return degree * Math.PI / 180;
    }

    private static int Work(int forcex, int forcey, int displacementx, int displacementy) {
        //PRE: enters a valid double of force and displacement
        //POST:  returns work in Joules
        int x1 = forcex; int y1 = forcey;
        int x2 = displacementx; int y2 = displacementy;
        return (x1*x2) + (y1*y2);
    }
    
    private static double Work(double force, double displacement, double theta) {
        //PRE: valid radians degree
        //POST: returns Work in Joules
        return force*displacement*Math.cos(theta);
    }
    
    private static double Power(double force, double velocity) {
        //PRE: force in newtons and velocity in m/s
        //POST: Power in J/s or Watts
        return force*velocity;
    }
    
    private static double Power2(double Work, double time) {
        //PRE: time in seconds and work in J
        //POST: Power in J/s or Watts
        return Work/time;
    }
    
    private static boolean MorePower(double work, double time, double work2, double time2) {
        //PRE: work in J time in S
        //POST: true is returned if the first object is more powerful and false
        //      if they are just as powerful or the second object is more powerful
        double p1 = Power2(work, time);
        double p2 = Power2(work2,time2);
        return p1 > p2;
    }
    
    private static double Torque(double radius, double force, double angle) {
     //R x F = |R||F|sin@
     //
     //PRE: radius is in meters and force is in newtons and angle is in radians
     //POST: Torque is returned in newton meters (Nm)
     return radius*force*Math.sin(angle);
    }
    
}
