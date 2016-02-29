package sii.maroc.presentation;

public class VehiculePrinter implements Printer {

    private static final VehiculePrinter INSTANCE = new VehiculePrinter();

    public static VehiculePrinter getInstance() {
	// TODO Auto-generated method stub
	return INSTANCE;
    }

    @Override
    public String writeOpenTwoDoorsCarDoors(String openDoors) {
	String result = VehiculesComponents.HEAD.getPresentation() + " l_l\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += VehiculesComponents.TAIL.getPresentation();
	result += writeFrontRightDoorStatus(openDoors) + "\n";
	result += " l_l";
	return result;
    }

    @Override
    public String writeOpenTRUCKDoors(String openDoors) {
	String result = VehiculesComponents.HEAD.getPresentation();
	result += writeFrontLeftDoorStatus(openDoors);
	result += VehiculesComponents.TAIL.getPresentation();
	result += writeFrontRightDoorStatus(openDoors);
	return result;
    }

    @Override
    public String writeOpenCARDoors(String openDoors) {
	String result = VehiculesComponents.HEAD.getPresentation();
	result += writeFrontLeftDoorStatus(openDoors) + " ";
	result += writeFrontRightDoorStatus(openDoors) + "\n";
	result += writeBackLeftDoorStatus(openDoors);
	result += VehiculesComponents.TAIL.getPresentation();
	result += writeBackRightDoorStatus(openDoors);
	return result;
    }

    private String writeBackRightDoorStatus(String openDoors) {
	if (openDoors.contains("4"))
	    return VehiculesComponents.RIGHT_OPEN.getPresentation();
	return VehiculesComponents.RIGHT_CLOSED.getPresentation();
    }

    private String writeBackLeftDoorStatus(String openDoors) {
	if (openDoors.contains("3"))
	    return VehiculesComponents.LEFT_OPEN.getPresentation();
	return VehiculesComponents.LEFT_CLOSED.getPresentation();
    }

    private String writeFrontRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return VehiculesComponents.RIGHT_OPEN.getPresentation();
	return VehiculesComponents.RIGHT_CLOSED.getPresentation();
    }

    private String writeFrontLeftDoorStatus(String openDoors) {
	if (openDoors.contains("1"))
	    return VehiculesComponents.LEFT_OPEN.getPresentation();
	return VehiculesComponents.LEFT_CLOSED.getPresentation();
    }

}
