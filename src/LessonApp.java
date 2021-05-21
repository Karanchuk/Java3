import java.util.ArrayList;
import java.util.Arrays;

public class LessonApp {
    public static void main(String[] args) {
        /** 1. Написать метод, который меняет два элемента массива местами.
         *     (массив может быть любого ссылочного типа);
         */
        Integer[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"A", "B", "C", "D", "E"};
        swap(ints, 0,2);
        System.out.println(Arrays.toString(ints));
        swap(strings, 2,4);
        System.out.println(Arrays.toString(strings));

        /** 2. Написать метод, который преобразует массив в ArrayList;
         */
        ArrayList<Integer> list = toList(ints);
        System.out.println(list);

        /** 3. Большая задача:

         a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
         b. Класс Box в который можно складывать фрукты, коробки условно сортируются
         по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
         c. Для хранения фруктов внутри коробки можете использовать ArrayList;
         d. Сделать метод getWeight() который высчитывает вес коробки, зная количество
         фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
         e. Внутри класса коробка сделать метод compare, который позволяет сравнить
         текущую коробку с той, которую подадут в compare в качестве параметра,
         true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать
         с коробками с апельсинами);
         f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
         в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
         соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
         которые были в этой коробке;
         g. Не забываем про метод добавления фрукта в коробку.
         */
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());

        System.out.println("Масса коробки с яблоками равна " + appleBox.getWeight());
        System.out.println("Сравниваем коробки с 2 яблоками и 2 апельсинами: " + appleBox.compare(orangeBox));
        appleBox.add(new Apple());
        System.out.println("Сравниваем коробки с 3 яблоками и 2 апельсинами: " + appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple());
        System.out.println("Масса коробки 2 с яблоками равна " + appleBox2.getWeight());
        appleBox.pourInto(appleBox2);
        System.out.println("Масса коробки 2 с яблоками равна " + appleBox2.getWeight());

    }

    public static void swap(Object[] array, int index1, int index2) {
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T> ArrayList<T> toList(T[] array) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        return list;
    }
}
