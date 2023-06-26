import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Collection {
    public static void main(String[] args) {
        System.out.println("===============Ex1===============");
        ArrayList<Integer> exampleList = new ArrayList<Integer>(
                List.of(1, 2, 10_000_000, 2_123_423_423, 2_145_423_423, 2, 3, 2));
        System.out.println("Sum number in list: " + sumInArray(exampleList));

        System.out.println("===============Ex2===============");
        System.out.println("Create Hashset from Arraylist: " + createHasSet(exampleList));

        System.out.println("===============Ex3===============");
        LinkedList<String> exLinkedList = new LinkedList<>(
                List.of("Apple", "Banana", "Mango", "peach", "strawberry", "Banana"));
        reverse(exLinkedList);
        System.out.println("Reverse : " + exLinkedList);

        System.out.println("===============Ex4===============");
        System.out.println("Number Max in array: " + findMax(exampleList));

        System.out.println("===============Ex5===============");
        HashMap<String, Integer> exHashMap = new HashMap<>(Map.of("Nam", 7, "Tien", 8, "Tu", 9, "hoang", 10));
        hashMapToString(exHashMap);

        System.out.println("===============Ex6===============");
        System.out.println("Array have value 1: " + checkArrayList(exampleList, 1));

        System.out.println("===============Ex7===============");
        ArrayList<String> exArrayListString = new ArrayList<String>(List.of("Apple",
                "Mango", "Banana", "Apple"));
        sortAcending(exArrayListString);
        System.out.println("ArrayList after sort: " + exArrayListString);

        System.out.println("===============Ex8===============");
        printTreeMap(exampleList);

        System.out.println("===============Ex9===============");
        arrayListToHashSet(exampleList);

        System.out.println("===============Ex10===============");
        System.out.println("exampleList: " + exampleList);
        removeDuplicate(exampleList);

        System.out.println("===============Ex11===============");
        ArrayList<Integer> copyArrayList = copyArray(exampleList);
        System.out.println("Array After copy: " + copyArrayList);

        System.out.println("===============Ex12===============");
        System.out.println("Check str: " + checkStr("hello, you are my friend, hello friend."));

        System.out.println("===============Ex13===============");
        System.out.println("Counter string: " + strCounter(exLinkedList, "Apple"));

        System.out.println("===============Ex14===============");
        System.out.println("ArrayList is Empty: " + checkEmpty(exampleList));

        System.out.println("===============Ex15===============");
        insertValue(exArrayListString, "Apple", 3);

        System.out.println("===============Ex16===============");
        createPriorityQueue(exArrayListString);

        System.out.println("===============Ex17===============");
        ArrayList<String> checkDuplicateArray2 = new ArrayList<>(List.of("Apple", "Banana"));
        checkDuplicateArray(exArrayListString, checkDuplicateArray2);
        System.out.println("===============Ex18===============");
        LinkedList<Integer> exLinkedListNumber = new LinkedList<>(List.of(3, 4, 5));
        // LinkedList<Integer> exLinkedListNumber = new LinkedList<>(List.of());
        sortDescending(exLinkedListNumber);
        System.out.println("===============Ex19===============");
        createHasSetFromArray(new String[]{"abc", "bac"});
        System.out.println("===============Ex20===============");
        System.out.println("exampleList: " + exampleList);
        getValueList(exampleList);

    }

    //1. Tạo một ArrayList chứa các số nguyên và tính tổng của tất cả các phần tử.
    public static double sumInArray(ArrayList<Integer> numList) {
        double result = 0;
        for (Integer num : numList) {
            result += num;
        }
        return result;
    }

    //2. Viết một chương trình để tạo một HashSet từ một ArrayList.
    public static HashSet<Integer> createHasSet(ArrayList<Integer> numList) {
        return new HashSet<>(numList);
    }

    //3. Tạo một LinkedList chứa các chuỗi và đảo ngược thứ tự của các phần tử trong danh sách.
    public static void reverse(LinkedList<String> exLinkedList) {
        Collections.reverse(exLinkedList);
    }

    //4. Viết một phương thức để tìm phần tử lớn nhất trong một ArrayList.
    public static int findMax(ArrayList<Integer> numList) {
        if (numList.size() <= 0) {
            return 0;
        }
        return Collections.max(numList);
    }

    //5. Tạo một HashMap chứa các tên và điểm số của sinh viên và in ra tất cả các mục.
    public static void hashMapToString(HashMap<String, Integer> studentMap) {
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " Score: " + entry.getValue());
        }
    }

    //6. Viết một phương thức để kiểm tra xem một ArrayList có chứa một giá trị cụ thể hay không.
    public static boolean checkArrayList(ArrayList<Integer> exArrayList, Integer contain) {
        return exArrayList.contains(contain);
    }

    //7. Sắp xếp một ArrayList chứa các chuỗi theo thứ tự bảng chữ cái.
    public static void sortAcending(ArrayList<String> exArrayList) {
        Collections.sort(exArrayList);
    }

    //8. Tạo một TreeSet từ một ArrayList và in ra tất cả các phần tử theo thứ tự tăng dần.
    public static void printTreeMap(ArrayList<Integer> exArrayList) {
        TreeMap<Integer, Integer> exTreeMap = new TreeMap<Integer, Integer>();
        int size = exArrayList.size();
        for (int i = 0; i < exArrayList.size(); i++) {
            exTreeMap.put(i, exArrayList.get(i));
        }
        System.out.println((int) Math.floor(size / 2) + 1);
        for (Integer key : exTreeMap.keySet()) {
            for (Integer key2 : exTreeMap.keySet()) {
                if (exTreeMap.get(key) < exTreeMap.get(key2)) {
                    int a = exTreeMap.get(key);
                    exTreeMap.replace(key, exTreeMap.get(key2));
                    exTreeMap.replace(key2, a);
                }
            }
        }
        System.out.println("printTreeMap: " + exTreeMap);
    }

    //9. Viết một chương trình để thêm tất cả các phần tử của một ArrayList vào một HashSet.
    public static HashSet<Integer> arrayListToHashSet(ArrayList<Integer> numList) {
        HashSet<Integer> numHashSet = new HashSet<Integer>();
        for (Integer num : numList) {
            numHashSet.add(num);
        }
        return numHashSet;
    }

    //10. Xóa các phần tử trùng lặp từ một ArrayList.
    public static void removeDuplicate(ArrayList<Integer> exArrayList) {
        for (int index = 0; index < exArrayList.size(); index++) {
            for (int index2 = exArrayList.size() - 1; index2 > index; index2--) {
                if (exArrayList.get(index) == exArrayList.get(index2)) {
                    exArrayList.remove(index2);
                }
            }
        }
        System.out.println("array : " + exArrayList);
    }

    //11. Viết một phương thức để sao chép một ArrayList sang một ArrayList mới.
    public static ArrayList<Integer> copyArray(ArrayList<Integer> exArrayList) {
        return new ArrayList<>(exArrayList);
    }

    //12. Tạo một TreeMap chứa các từ và tần suất xuất hiện của chúng trong một đoạn văn bản.
    public static TreeMap<String, Integer> checkStr(String str) {
        // String newStr = str.replace(",", "");
        // String newStr2 = newStr.replace(".", "");
        String[] strList = str.split("\\W+");
        TreeMap<String, Integer> newTreeMap = new TreeMap<>();
        for (int i = 0; i < strList.length; i++) {
            if (newTreeMap.get(strList[i]) != null) {
                int newVal = newTreeMap.get(strList[i]) + 1;
                newTreeMap.replace(strList[i], newVal);
            } else {
                newTreeMap.put(strList[i], 1);
            }
        }
        return newTreeMap;
    }

    //13. Tìm số lần xuất hiện của một phần tử cụ thể trong một LinkedList.
    public static int strCounter(LinkedList<String> strLinkedList, String str) {
        int count = 0;
        for (String value : strLinkedList) {
            if (value == str) {
                count += 1;
            }
        }
        return count;
    }

    //14. Kiểm tra xem một ArrayList có rỗng hay không.
    public static boolean checkEmpty(ArrayList<Integer> numArrayList) {
        return numArrayList.isEmpty();
    }

    //15. Viết một phương thức để chèn một phần tử vào một ArrayList tại vị trí xác định.
    public static void insertValue(ArrayList<String> strArrayList, String str, int index) {
        strArrayList.add(index, str);
        System.out.println("Insert element to arrayList: " + strArrayList);
    }

    //16. Tạo một PriorityQueue từ một ArrayList và in ra tất cả các phần tử theo thứ tự ưu tiên.
    public static void createPriorityQueue(ArrayList<String> strArrayList) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(strArrayList);
        System.out.println("strArrayList : " + strArrayList);
        System.out.println("PriorityQueue : " + priorityQueue);
    }

    //17. Viết một chương trình để kiểm tra xem một ArrayList có chứa tất cả các phần tử của một danh sách khác hay không.
    public static void checkDuplicateArray(ArrayList<String> strArrayListPrimary, ArrayList<String> strArrayListCheck) {
        int sizeArr1 = strArrayListPrimary.size();
        int sizeArr2 = strArrayListCheck.size();
        int size = 0;
        if (sizeArr1 < sizeArr2) {
            System.out.println("Array Primary is not include Array check");
            return;
        }
        size = sizeArr2;

        for (int index = 0; index < size; index++) {
            if (!strArrayListPrimary.contains(strArrayListCheck.get(index))) {
                System.out.println("Array Primary is not include Array check");
                return;
            }
        }

        System.out.println("Array Primary is include Array check");
    }

    //18. Sắp xếp một LinkedList chứa các số nguyên theo thứ tự giảm dần.
    public static void sortDescending(LinkedList<Integer> numLinkedList) {
        // numLinkedList.sort(null);
        int size = numLinkedList.size();
        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 0; index2 < size; index2++) {
                if (numLinkedList.get(index1) >= numLinkedList.get(index2)) {
                    int a = numLinkedList.get(index1);
                    numLinkedList.set(index1, numLinkedList.get(index2));
                    numLinkedList.set(index2, a);
                }
            }
        }
        System.out.println("Sort Descending Linkedlist: " + numLinkedList);
    }

    //19. Tạo một HashSet từ một mảng và in ra tất cả các phần tử.
    public static void createHasSetFromArray(String[] exArray) {
        HashSet<String> exHashSet = new HashSet<>();
        for (String str : exArray) {
            exHashSet.add(str);
        }
        System.out.println("Create HashSet from Array: " + exHashSet);
    }

    //20. Viết một phương thức để lấy phần tử đầu tiên và phần tử cuối cùng của một ArrayList.
    public static void getValueList(ArrayList<Integer> numArrayList) {
        int numFirst = numArrayList.get(0); 
        int numLast = numArrayList.get(numArrayList.size()-1); 
        System.out.println("Number First : " + numFirst + " Number Last: " + numLast);
    }


}