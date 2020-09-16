import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter mass of water in grams:");
    double mass = reader.nextDouble();
    System.out.println("Enter initial temperature of water in Celcius:");
    double i = reader.nextDouble();
    if (i<-273.14){
      i = -273.14;}
     System.out.println("Enter final temperature of water in Celcius:");
    double f = reader.nextDouble();
    if (f<-273.14){
      f = -273.14;}
    String initialPhase = "liquid";
    if (i < 0)
      initialPhase = "solid";
    if (i >100)
      initialPhase = "gas";
    String endPhase = "liquid";
    if (f < 0)
      endPhase = "solid";
    if (f > 100)
      endPhase = "gas";
    System.out.println("Mass: " + mass + "g");
    System.out.println("Initial tempeature: " + i + "C " + initialPhase);
    System.out.println("Final tempeature: " + f + "C " + endPhase);
    boolean endothermic = false;
    if (f > i)
      endothermic = true;
    double heatEnergy = 0;

    if (initialPhase.equals("solid")){
      heatEnergy += tempChangeSolid(mass, i, f, endPhase, endothermic);
      if (!endPhase.equals("solid")){
        heatEnergy += fusion(mass, endothermic);
        heatEnergy += tempChangeliquid(mass, 0, f, endPhase, endothermic);
      }
      if (endPhase.equals("gas")){
        heatEnergy += vaporization(mass, endothermic);
        heatEnergy += tempChangeVapor(mass, 100, f, endPhase, endothermic);
      }
    }
    if (initialPhase.equals("liquid")){
      heatEnergy += tempChangeliquid(mass, i, f, endPhase, endothermic);
      if (endPhase.equals("solid")){
        heatEnergy += fusion(mass, endothermic);
        heatEnergy += tempChangeSolid(mass, 0, f, endPhase, endothermic);
      }
      if (endPhase.equals("gas")){
        heatEnergy += vaporization(mass, endothermic);
        heatEnergy += tempChangeVapor(mass, 100, f, endPhase, endothermic);
      }
    }
    if (initialPhase.equals("gas")){
      heatEnergy += tempChangeVapor(mass, i, f, endPhase, endothermic);
      if (!endPhase.equals("gas")){
        heatEnergy += vaporization(mass, endothermic);
        heatEnergy += tempChangeliquid(mass, 100, f, endPhase, endothermic);
      }
      if (endPhase.equals("solid")){
        heatEnergy += fusion(mass, endothermic);
        heatEnergy += tempChangeSolid(mass, 0, f, endPhase, endothermic);
      }
    }


    heatEnergy = round(heatEnergy);
    System.out.println("Total heat energy " + heatEnergy + " kJ");
  }
  public static double tempChangeSolid(double mass, double i, double f, String endPhase, boolean endothermic){
    if (!endPhase.equals("solid"))
      f = 0;
   double energychange = round(mass*0.002108*(f-i));
    if (endothermic)
      System.out.println("Heating (solid): " + energychange + "kJ");
    else
      System.out.println("Cooling (solid): " + energychange + "kJ");
    return energychange;
  }

  public static double tempChangeVapor(double mass, double i, double f, String endPhase, boolean endothermic){
     if (!endPhase.equals("gas"))
       f = 100;
     double energychange = round(mass*0.001996*(f-i));
     if (endothermic)
      System.out.println("Heating (gas): " + energychange + "kJ");
     else
      System.out.println("Cooling (gas): " + energychange + "kJ");
    return energychange;
  }

  public static double tempChangeliquid(double mass, double i, double f, String endPhase, boolean endothermic){
   if (endPhase.equals("solid"))
     f = 0;
    if (endPhase.equals("gas"))
      f = 100;
   double energychange = round(mass*0.004184*(f-i));
   if (endothermic)
     System.out.println("Heating (Liquid): " + energychange + "kJ");
   else
     System.out.println("Cooling (Liquid): " + energychange + "kJ");
   return energychange;
   
  }

  public static double fusion(double mass, boolean endothermic){
  double energychange;
   if (endothermic){
     energychange = round(0.333 * mass); 
     System.out.println("Melting: " + energychange + "kJ");}
   else {
     energychange = round(-0.333 * mass);
     System.out.println("Freezing: " + energychange + "kJ");}
   return energychange; 
  }

  public static double vaporization(double mass, boolean endothermic){
   double energychange;
   if (endothermic){
     energychange = round(2.257 * mass); 
     System.out.println("Evaporation: " + energychange + "kJ");}
   else {
     energychange = round(-2.257 * mass);
   System.out.println("Condensation: " + energychange + "kJ");}
   return energychange; 
  }

  public static double round(double x) {
   x *= 1000;
   if(x > 0)
     return (int)(x + 0.5) / 1000.0;
   else
     return (int)(x - 0.5) / 1000.0;
  }
}