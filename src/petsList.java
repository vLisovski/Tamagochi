public enum petsList {
    DOG("Dog"),
    CAT("Cat");


    String typeName = " ";
    private static int petsInList = 2;

    petsList(String petName) {
        this.typeName = petName;
    }

    public static int getPetsInList() {
        return petsInList;
    }
}
