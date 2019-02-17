enum Day{
    WEEKEND(1), WEEKDAY(2);
    private int id;

    Day(int value){
        id = value;
    }
    public int getId(){
        return id;
    }
}
