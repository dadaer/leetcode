import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }

    List<? super Father> list = new ArrayList<>();
    List<? extends Father> list1 = new ArrayList<>();

    public List<? super Father> getList() {
        list.add(new Father());
        list.add(new Son());
        return list;
    }

    public List<? extends Father> getList1() {
//        list1.add(new Father());
//        list1.add(new Son());
        return list1;
    }
}

class Father{

}

class Son extends Father{

}
