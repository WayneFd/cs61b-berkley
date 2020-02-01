public class Planet{
    /* this is the parameter */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double G = 6.67e-11;
    /* init method */
    public Planet(double xP,double yP, double xV, double yV, double m, String img){
	     xxPos = xP;
	     yyPos = yP;
	     xxVel = xV;
	     yyVel = yV;
	     mass = m;
	     imgFileName = img;
    }

    /* copy another Planet */
    public Planet(Planet b){
        this.xxPos = b.xxPos;
	      this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    /* calculate the distance between two planets */
    public double calcDistance(Planet b){
      double dx = b.xxPos - this.xxPos;
      double dy = b.yyPos - this.yyPos;
      double distance = Math.sqrt(dx*dx + dy*dy);
      return distance;
    }

    /* calculate the force exerted on the planet by the given planet */
    public double calcForceExertedBy(Planet b){
      double distance = this.calcDistance(b);
      double force = G * this.mass * b.mass / (distance * distance);
      return force;
    }

    /* calculate the force exerted on the x axis by the given planet */
    public double calcForceExertedByX(Planet b){
      double force = this.calcForceExertedBy(b);
      double distance = this.calcDistance(b);
      double dx = b.xxPos - this.xxPos;
      double xforce = force * dx / distance;
      return xforce;
    }
    /* calculate the force exerted on the y axis by the given planet */
    public double calcForceExertedByY(Planet b){
      double force = this.calcForceExertedBy(b);
      double distance = this.calcDistance(b);
      double dy = b.yyPos - this.yyPos;
      double yforce = force * dy / distance;
      return yforce;
    }

    /* calculate the net force exerted on the planet by the given planets */
    public double calcNetForceExertedByX(Planet[] allPlanets){
      double xtotal = 0.0;
      for (Planet b : allPlanets){
        if (!this.equals(b)){
        xtotal += calcForceExertedByX(b);
        }
      }
      return xtotal;
    }

    /* calculate the net force exerted on the planet by the given planets */
    public double calcNetForceExertedByY(Planet[] allPlanets){
      double ytotal = 0.0;
      for (Planet b : allPlanets){
          if (!this.equals(b)){
        ytotal += calcForceExertedByY(b);
        }
      }
      return ytotal;
    }

    /* update the velocity and pposition */
    public void update(double dt, double fX, double fY){
      double xxac = fX / this.mass;
      double yyac = fY / this.mass;
      this.xxVel += xxac * dt;
      this.yyVel += yyac * dt;
      this.xxPos += xxVel * dt;
      this.yyPos += yyVel * dt;
    }

    /* draw the picture */
    public void draw(){
      String file  = "images/"+imgFileName;
      StdDraw.picture(xxPos,yyPos,file);
    }
}
