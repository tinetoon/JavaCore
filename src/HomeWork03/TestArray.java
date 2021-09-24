package HomeWork03;

public class TestArray<T> {

    private T obj;

    public TestArray(T оbj) {
        this.obj = оbj;
    }

    public T getObj() {
        return obj;
    }

//    public void setObj(T obj) {
//        this.obj = obj;
//    }

    public void showType() {
        System.out.println("Тип T: " + obj.getClass().getName());
    }

}
