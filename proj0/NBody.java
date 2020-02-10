public class NBody{
  /* read the Radius from a NBody file */
  public static double readRadius(String filename){
    In in = new In(filename);
    int N = in.readInt();
    double Radius = in.readDouble();
    return Radius;
  }

  /* read the Planet from a Nbody file */
  public static Planet[] readPlanets(String filename){
    In in = new In(filename);
    int N = in.readInt();
    double Radius = in.readDouble();
    Planet[] allPlanets = new Planet[N];
    for (int i = 0; i < N; i++){
      double xxPos = in.readDouble();
      double yyPos = in.readDouble();
      double xxVel = in.readDouble();
      double yyVel = in.readDouble();
      double mass = in.readDouble();
      String name = in.readString();
      allPlanets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,name);
    }
    return allPlanets;
  }

  /* main function */
  public static void main(String[] args){
    if (args.length != 3){
      System.out.println("Please enter two doubles and one filename");
    }
    String background = "images/starfield.jpg";
    /* read all the parameter */
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = readRadius(filename);
    Planet[] allPlanets = readPlanets(filename);
    StdDraw.setScale(-1*radius, radius);
    StdDraw.clear();
    StdDraw.picture(0, 0, background);
    for (Planet b : allPlanets){
      b.draw();
    }
    StdDraw.show();
    /* to make the animation smoothly */
    StdDraw.enableDoubleBuffering();

    double time = 0;
    int length = allPlanets.length;
    StdAudio.play("audio/2001.mid");
    while (time <= T){
      double[] xForces = new double[length];
      double[] yForces = new double[length];

      /* calculate the force */
      for (int i = 0; i < length; i++){
        xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
      }
      /* update the positions of all planets */
      for (int i = 0; i < length; i++){
        allPlanets[i].update(dt,xForces[i],yForces[i]);
      }
      /* draw the position */
      StdDraw.clear();
      StdDraw.picture(0, 0, background);
      for (Planet b : allPlanets){
        b.draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      time += dt;
    }
    System.out.printf("%d\n",allPlanets.length);
    System.out.printf("%.2e\n",radius);
    for (int i = 0; i < length; i++){
      System.out.printf("%11.4e %11.4e % 11.4e %11.4e %11.4e %12s\n",
                        allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                        allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
    }
}

}
