import jdk.jshell.execution.Util;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int FOOD_INC = 100;
        final int WATER_INC = 100;
        final int STRESS_INC = 5;
        final int FOOD_DEC = 15;
        final int WATER_DEC = 15;
        final int STRESS_DEC = 50;
        int stepWithToiletNeedCounter = 0;
        int caressCounter = 0;
        int waterCounter=0;
        Pet pet = new Pet(petsList.DOG);//питомец по умолчанию

        Actions.printCreatePetMenu();

        int numberOfPet = Utilites.enterInt("Your choose:", 1, petsList.getPetsInList());

        switch (numberOfPet) {//выбор питомца
            case 1:
                pet = new Pet(petsList.DOG);
                break;
            case 2:
                pet = new Pet(petsList.CAT);
                break;
        }

        while (pet.getHealthPoints() > 0) {//игра

            pet.decreaseFoodLevel(FOOD_DEC);//питомец пассивно теряет уровень еды и воды
            pet.decreaseWaterLevel(WATER_DEC);

            System.out.println(pet.getPetType() + " HP: " + pet.getHealthPoints());

//region CreatingWhatPetNeed
            int needChance = Utilites.randomize(1000);

            if (needChance > 350 && needChance < 650) {//в целях баланса потребности и стресс прокают с определнным шансом
                int numberOfWhatNeed = Utilites.randomize(2)+1;
                switch (numberOfWhatNeed) {//рандомный прок потребности питомца
                    case 1:
                        pet.setNeedAToilet(true);
                        break;
                    case 2:
                        pet.setNeedAShower(true);
                        break;
                    case 3:
                        pet.increaseStress(STRESS_INC);
                        break;
                    default:
                        System.out.println("Wrong numberOfNeedValue");
                }
            }
//endregion
            Actions.checkPetStatus(pet);
            Actions.printGameMenu();

            int numberOfMenuItem = Utilites.enterInt("Your choose:", 1, 6);
            switch (numberOfMenuItem) {
                case 1: {
                    pet.increaseFoodLevel(FOOD_INC);
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " eats...");
                    Thread.sleep(2000);
                    System.out.println("On the "+pet.getPetType()+" face reads full bliss");
                    Thread.sleep(2000);
                    Utilites.clearConsole();
                }
                break;
                case 2: {
                    pet.increaseWaterLevel(WATER_INC);
                    waterCounter++;
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " drink...");
                    Thread.sleep(2000);
                    System.out.println("On the "+pet.getPetType()+" face reads full bliss");
                    Thread.sleep(2000);
                    Utilites.clearConsole();
                }
                break;
                case 3: {
                    pet.setNeedAToilet(false);
                    waterCounter=0;
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " goes pee...");
                    Thread.sleep(2000);
                    Utilites.clearConsole();
                }
                break;
                case 4: {
                    pet.setNeedAShower(false);
                    if (pet.getPetType() == petsList.CAT) {//питомец CAT испытывает стресс при принятии душа
                        pet.increaseStress(20);
                    }
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " covered in foam");
                    Thread.sleep(2000);
                    Utilites.clearConsole();
                }
                break;
                case 5: {
                    if (!pet.isNeedAToilet() && !pet.isNeedAShower()) {//погладить питомца снижает стресс
                        // только если питомцу не нужно в туалет и душ
                        pet.decreaseStress(STRESS_DEC);
                    }
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " makes happy sounds");
                    Thread.sleep(2000);
                    if(pet.getPetType()==petsList.CAT){
                        System.out.println("Meeeew... <3");
                    }else{
                        System.out.println("Gav gav...<3");
                    }
                    Thread.sleep(2000);
                    Utilites.clearConsole();
                    caressCounter++;
                }
                break;
                case 6: {
                    Utilites.clearConsole();
                    System.out.println(pet.getPetType() + " walks");
                    Thread.sleep(1000);
                    System.out.println(pet.getPetType()+" still walks...");
                    Thread.sleep(1000);
                    Utilites.clearConsole();
                }
            }

//region anotherChecks
            if (pet.isNeedAToilet()) {//счет ходов, в которых питомцу нужно было в туалет
                stepWithToiletNeedCounter++;
            }
            if (stepWithToiletNeedCounter > 2) {//если питомцу надо в туалет более двух ходов он сходит к Вам в кровать
                pet.setNeedAShower(true);
                stepWithToiletNeedCounter = 0;
                pet.setNeedAToilet(false);
                Utilites.clearConsole();
                System.out.println(pet.getPetType()+" goes pee in your bed");
                Thread.sleep(2000);
                System.out.println("fuck...");
                Thread.sleep(500);
                Utilites.clearConsole();
            }
            if (pet.getHealthPoints() < 100) {//реген работает если хп меньше 100
                Actions.checkRegen(pet);
            }
            if (pet.getStress() >= 100 && pet.getPetType() == petsList.CAT) {
                caressCounter = 0;
            }
            if (caressCounter > 3 && pet.getPetType() == petsList.CAT) {//если питомец CAT то его не стоит лишний раз гладить
                //счетчик обновиться выше, если питомец испытает высокий стресс
                pet.increaseStress(10);
            }
            if(waterCounter>=3){//не стоит лишний раз поить питомца, он захочет в туалет
                pet.setNeedAToilet(true);
                //счетчик обновится, если питомец сходит в туалет
            }
//endregion
            Actions.checkDamage(pet);

            Utilites.clearConsole();

        }
        System.out.println("Your pet is dead :( ");//GG
    }
}
