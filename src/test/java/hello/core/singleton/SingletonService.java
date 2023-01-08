package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    //객체 인스턴스를 호출하려면 이 매서드를 통해서만 조회할 수 있다.
    //    딱 한개의 객체인스턴스만 존재해야하므로, new 키워드로 인스턴스 생성을 막아야함.


//    public static void main(String[] args) {
//        SingletonService singletonService = new SingletonService();
//        //이렇게 맏들어 버릴 수 있으므로. 유일함을 보장할 수 없다. 따라서 private로 접근을 제한한다.
//    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
