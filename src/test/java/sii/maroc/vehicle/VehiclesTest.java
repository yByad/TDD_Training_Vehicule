package sii.maroc.vehicle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/************
 * _ door 1 | | door 2 door 3 |_| door 4
 * 
 *************/
public class VehiclesTest {

    private Vehicles vehicles;

    @Before
    public void initVehicles() {
	vehicles = new Vehicles("Diesel:5%,Fuel:6%,Hybrid:3%");
    }

    @Test
    public void testTwoDoorsCar() {
	String report = vehicles.move("TwoDoorsCar", "Diesel", "1 2", "200 KM");
	Assert.assertEquals("DOORS OK, MOVING. The TwoDoorsCar will consume 10.00 L", report);
    }

    @Test
    public void testTwoDoorsCarOpenDoor() {
	String report = vehicles.move("TwoDoorsCar", "Diesel", "1 ", "200 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " l_l\n" + " |_\\\n" + " l_l", report);
    }

    @Test
    public void testCar() {
	String report = vehicles.move("CAR", "Diesel", "1 2 3 4", "200 KM");
	Assert.assertEquals("DOORS OK, MOVING. The CAR will consume 10.00 L", report);
    }

    @Test
    public void testTruck() {
	String report = vehicles.move("TRUCK", "Diesel", "1 2", "1000 KM");
	Assert.assertEquals("DOORS OK, MOVING. The TRUCK will consume 50.00 L", report);
    }

    @Test
    public void testMotorCycle() {
	String report = vehicles.move("MOTORCYCLE", "Fuel", "", "50 KM");
	Assert.assertEquals("DOORS OK, MOVING. The MOTORCYCLE will consume 3.00 L", report);
    }

    @Test
    public void testCarBackLeftDoorNotClosed() {
	/***********
	 * _ | | /_|
	 * 
	 ************/
	String report = vehicles.move("CAR", "Hybrid", "1 2 4", "200 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " | |\n" + " /_|", report);
    }

    @Test
    public void testTruckRightDoorOpen() {
	String report = vehicles.move("TRUCK", "Diesel", "1", "1000 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " |_\\\n", report);
    }

    @Test
    public void testCarFrontRightDoorNotClosed() {
	/***********
	 * _ | \ |_|
	 * 
	 ************/
	String report = vehicles.move("CAR", "Fuel", "1 3 4", "200 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " | \\\n" + " |_|", report);
    }

    @Test
    public void testTruckLeftDoorOpen() {
	String report = vehicles.move("TRUCK", "Diesel", "2", "1000 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " /_|", report);
    }

    @Test
    public void testCarAllDoorsOpen() {
	String report = vehicles.move("CAR", "Hybrid", "", "200 KM");
	Assert.assertEquals("DOORS KO, BLOCKED \n" + "  _\n" + " / \\\n" + " /_\\\n", report);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarFiveDoors() {
	vehicles.move("CAR", "Hybrid", "1 2 3 4 5", "200 KM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCarTwoSameDoors() {
	vehicles.move("CAR", "Hybrid", "1 2 3 3", "200 KM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMotorcycleDoor() {
	vehicles.move("MOTORCYCLE", "Hybrid", "1", "200 KM");
    }
}
