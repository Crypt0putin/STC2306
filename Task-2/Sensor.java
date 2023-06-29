package org.STC2306;

import java.util.Random;

public class Sensor implements ISensor {
     public int getHumidity() {
         Random random = new Random();
         return random.nextInt(100);
    }
}
