public class Pet {

    private int healthPoints = 100;
    private int waterLevel = 100;
    private int foodLevel = 100;
    private int stress = 0;

    private boolean needAToilet = false;
    private boolean needAShower = false;

    private PetsType petType;

    public Pet(PetsType petType) {
        this.petType = petType;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public Pet(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public int getStress() {
        return stress;
    }

    public boolean isNeedAToilet() {
        return needAToilet;
    }

    public boolean isNeedAShower(){return needAShower;}

    public PetsType getPetType() {
        return petType;
    }


    public void increaseHealthPoints(int healthPoints) {
        this.healthPoints += healthPoints;
    }
    public void decreaseHealthPoints(int healthPoints) {
        this.healthPoints -= healthPoints;
    }

    public void increaseWaterLevel(int waterLevel){
        this.waterLevel += waterLevel;
    }
    public void decreaseWaterLevel(int waterLevel){
        this.waterLevel -= waterLevel;
    }

    public void increaseFoodLevel(int foodLevel){
        this.foodLevel += foodLevel;
    }
    public void decreaseFoodLevel(int foodLevel){
        this.foodLevel -= foodLevel;
    }

    public void increaseStress(int stress) {
        this.stress += stress;
    }
    public void decreaseStress(int stress) {
        this.stress -= stress;
    }
    public void setNeedAToilet(boolean needAToilet) {
        this.needAToilet = needAToilet;
    }

    public void setNeedAShower(boolean needAShower){
        this.needAShower = needAShower;
    }


}
