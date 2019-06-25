import java.util.HashMap;
import java.util.Map;

public class Array {

    //You will be given a target.Find the indices that sum up to the target
    //2+7=9 -> 9-7=2
    //idea is to push the elements into hashmap() (values index)
    // if the above condition(target-element=hashmap element)
    //Hashmap numbers index
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

    public void binarySearchArray(Integer searchElement){
        Integer[] nums ={1,10,20,47,59,65,75,88,99};

        Integer low=0;
        Integer high=nums.length-1;

        while(low<=high){

            int mid = high+low/2;
            if(nums[mid]==searchElement){
                System.out.println("Element found at index "+mid);
                return;
            }

            if(searchElement<nums[mid]){
                high=mid-1;
            }

            else
            {
                low=mid+1;
            }

        }

        System.out.println("The element not found");


    }

    public static void main(String[] args) {

        Array array = new Array();
        Integer[] result = array.twoSumNumbers(9);

        if (result != null) {
            System.out.println("["+result[0] + " , " + result[1]+"]");
        }

        //binary search
        System.out.println("Binary search");
        array.binarySearchArray(65);

    }
}
