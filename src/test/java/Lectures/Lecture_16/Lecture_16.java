package Lectures.Lecture_16;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class Lecture_16 {

    @Test
    public void test1() {
        Car car  = new Car();
        car.setModel("Audi");
        car.setEngine(1.6);
        car.setMaxSpeed(220);
        log.info(car);
    }

    @Test
    public void test2() {
        Car audi = new Car();
        audi.setModel("Audi");

        Car tesla = new Car();
        tesla.setModel("Tesla");

        Assert.assertFalse(audi.equals(tesla));
    }

   @Test
    public void test3() {
        Pet pet = Pet.builder().name("Charli").age(10).type("Pug").build();
        log.info(pet);
   }
}
