public class Actions {
    public static void printGameMenu() {
        System.out.println("Choose your action:");
        System.out.println("1.Feed the pet");
        System.out.println("2.Water the pet");
        System.out.println("3.Take pet to the toilet");
        System.out.println("4.Take pet to the shower");
        System.out.println("5.Caress pet");
        System.out.println("6.To do nothing");
    }

    private static void printWhatPetNeed(Pet pet,String whatNeed) {
        System.out.println(pet.getPetType()+" need "+ whatNeed);
    }



    public static void printCreatePetMenu() {
        System.out.println("CREATE A PET");
        System.out.println("Choose your pet:");
        System.out.println("1.DOG");
        System.out.println("2.CAT");
    }

    public static void checkPetStatus(Pet pet){
        final int GOOD_LEVEL=50;
        if(pet.isNeedAShower()){
            printWhatPetNeed(pet," a shower");
        }

        if(pet.isNeedAToilet()){
            printWhatPetNeed(pet," a toilet");
        }

        if(pet.getFoodLevel()<GOOD_LEVEL){
            printWhatPetNeed(pet," food");
        }
        if(pet.getWaterLevel()<GOOD_LEVEL){
            printWhatPetNeed(pet," water");
        }

        if(pet.getStress()>GOOD_LEVEL){
            printWhatPetNeed(pet," affection");
        }
    }

    public static void checkDamage(Pet pet){
        int anotherDamage=0;
        if(pet.getPetType()== PetsType.CAT){
            anotherDamage=10;
        }
        if(pet.getStress()>=100){
            pet.decreaseHealthPoints(30+anotherDamage);
        }
        if(pet.getFoodLevel()<=0 || pet.getFoodLevel()>=200){
            pet.decreaseHealthPoints(30+anotherDamage);
        }
        if(pet.getWaterLevel()<=0){
            pet.decreaseHealthPoints(30+anotherDamage);
        }
        if(pet.isNeedAShower()){
            pet.increaseStress(25);
        }
        if(pet.isNeedAToilet()){
            pet.increaseStress(50);
        }
    }

    public static void checkRegen(Pet pet){
        if(pet.getStress()<50){
            pet.increaseHealthPoints(5);
        }
        if(pet.getFoodLevel()>50 && pet.getFoodLevel()<100){
            pet.increaseHealthPoints(10);
        }
        if(pet.getWaterLevel()>50) {
            pet.increaseHealthPoints(10);
        }
    }
}
