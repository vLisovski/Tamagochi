public enum PetsType {
    DOG("Dog"),
    CAT("Cat");


    String typeName = "";
    private static int petsInList = 2;

    PetsType(String petName) {
        this.typeName = petName;
    }

    public static int getPetsInList() {
        return petsInList;
    }
}
