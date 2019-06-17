import java.util.HashMap;
import java.util.Map;

public class Array {

    //You will be given a target.Find the indices that sum up to the target
    //2+7=9 -> 9-7=2
    //idea is to push the elements into hashmap() (values index)
    // if the above condition(target-element=hashmap element)
    public Integer[] twoSumNumbers(Integer target) {
        Integer numbers[] = {2, 11, 5, 10, 7, 8};

        Integer result[] = new Integer[2];
        Map<Integer, Integer> elements = new HashMap();

        for (Integer i = 0; i < numbers.length; i++) {

            if (!elements.containsKey(target - numbers[i])) {

                elements.put(numbers[i], i);
            } else {
                result[0] = i;
                result[1] = elements.get(target - numbers[i]);
                break;
            }
        }


        return result;
    }

    public static void main(String[] args) {

        Array array = new Array();
        Integer[] result = array.twoSumNumbers(9);

        if (result != null) {
            System.out.println("["+result[0] + " , " + result[1]+"]");
        }

    }
}
