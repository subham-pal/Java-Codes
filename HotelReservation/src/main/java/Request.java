import com.sun.corba.se.impl.encoding.TypeCodeOutputStream;

public class Request {
    private Day day;
    private Type type;

    public Request(Day day, Type type) {
        this.day = day;
        this.type = type;
    }

    public Day getDay() {
        return day;
    }

    public Type getType() {
        return type;
    }


    @Override
    public int hashCode() {
        System.out.println();
        return day.getId() * 31 + type.getId() * 31 * 31;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Request)obj).getDay() == day && ((Request)obj).getType() == type);
    }
}
