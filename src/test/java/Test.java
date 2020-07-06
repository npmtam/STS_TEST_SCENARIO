import java.util.ArrayList;
import java.util.List;

public class Test {
    static boolean isContained;
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("ABC");
        list.add("ACBDERF");
        list.add("EFSHS");
        System.out.println(isArrayListContains(list, "a"));
    }

    private static boolean isArrayListContains(List<String> arraylist, String keyword){
        for(String str : arraylist){
            if(!str.toLowerCase().contains(keyword)){
                return false;
            }
        }return true;
    }

}
