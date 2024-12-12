package nested.nested.ex1;

// Network 객체 안에서만 사용됨
public class NetworkMessage {

    private String content;

    public NetworkMessage(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}
