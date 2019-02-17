enum Type{
    REGULAR(3), REWARD(4);
    private int id;

    Type(int value){
        id = value;
    }

    public int getId(){
        return id;
    }
}