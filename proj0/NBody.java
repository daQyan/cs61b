public class NBody {
    // here this method has to be static!
    public static double readRadius(String file) {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
        int i = 0;

        while(!in.isEmpty()) {

            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            planets[i] = new Planet(xxPos, yyPos, xV, yV, mass, imgFileName);
            i++;
            // break poibt: Not to read the words afterwards
            if (i == number) {
                break;
            }
        }

        return planets;
    }


    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();
		StdDraw.enableDoubleBuffering();

        int time = 0;

        while (time != T) {
            double[] xForces = new double[5];
            double[] yForces = new double[5];
            int i = 0;
            for (Planet p:planets) {
                xForces[i] = p.calcNetForceExertedByX(planets);
                yForces[i] = p.calcNetForceExertedByY(planets);
                p.update(dt, xForces[i], yForces[i]);
                p.draw();
                i++;
                StdDraw.show();
               
            }

            StdDraw.picture(0, 0, imageToDraw);
            StdDraw.pause(10);
            dt++;
        }        
        StdDraw.show();

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }


    }



}