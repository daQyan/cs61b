public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    //should be private
    public String imgFileName;
    private static double G = 6.67e-11; 

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Planet(Planet p) {

        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;               
    }
    
    public double calcDistance(Planet p) {
        double sqrdistance = (this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + 
                        (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
        return Math.sqrt(sqrdistance);
    }

    public double calcForceExertedBy(Planet p) {
        double force;
        double distance = this.calcDistance(p);

        force = (G * this.mass * p.mass) / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double forcex;
        forcex = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)/this.calcDistance(p);
        return forcex;
    }

    public double calcForceExertedByY(Planet p) {
        double forcex;
        forcex = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)/this.calcDistance(p);
        return forcex;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double netfx = 0;
        for (Planet p : ps) {
            if (! this.equals(p)) {
                netfx += this.calcForceExertedByX(p);
            }
        }
        return netfx;
    }
    
    public double calcNetForceExertedByY(Planet[] ps) {
        double netfx = 0;
        for (Planet p : ps) {
            if (! this.equals(p)) {
                netfx += this.calcForceExertedByY(p);
            }        
        }
        return netfx;
    }

    public void update (double dt, double fX, double fY) {
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        double vx = this.xxVel + ax*dt;
        double vy = this.yyVel + ay*dt;

        double px = this.xxPos + vx*dt;
        double py = this.yyPos + vy*dt;
        this.xxVel = vx;
        this.yyVel = vy;
        this.xxPos = px;
        this.yyPos = py;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
        
    }

    

}