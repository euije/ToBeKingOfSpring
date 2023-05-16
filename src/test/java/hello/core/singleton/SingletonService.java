package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // private 접근자 설정으로 인해 직접적인 객체 생성을 금지함.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
