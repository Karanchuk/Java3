import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {
    private final List<T> fruits;

    @SafeVarargs
    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    /**
     * Возвращает массу фрукторв в коробке
     * @return масса фруктов в коробке
     */
    public double getWeight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    /**
     * Метод сравнивает содержимое нескольких коробок с текущей по массе
     * @param boxes коробки для сравнения с текущей
     * @return true в случае, если масса каэжой коробки равна текущей, иначе false
     */
    public boolean compare(Box... boxes) {
        boolean comparable = true;
        for (Box box : boxes)
            comparable = (!(Math.abs(this.getWeight() - box.getWeight()) > 0.0001) && comparable);
        return comparable;
    }

    /**
     * Метод добавляет новый фрукт в коробку
     * @param elem Новый элемент с типом T
     */
    public void add(T elem) {
        fruits.add(elem);
    }

    /**
     * Метод перемещает все элементы ArrayList в новую коробку, удаляя их из этой колобки
     * @param box коробка, в которую пересыпаем фрукты
     */
    public void pourInto(Box box) {
        for (T fruit : fruits)
            box.add(fruit);
        fruits.clear();
    }
}
