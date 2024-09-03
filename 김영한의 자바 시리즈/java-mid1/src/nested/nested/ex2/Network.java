package nested.nested.ex2;

public class Network {
    public void sendMessage(String text) {
        /*
            자기 클래스 내부에 있는 중첩 클래스에 접근할 때는 자기 클래스 이름은 떼도 됨
            그렇지만 다른 클래스의 중첩 클래스에 접근하는 거면 이렇게 쓰자
            (근데 이렇게 외부에서 다른 중첩클래스를 접근하는 경우가 생기면 그냥 빼는게 나음)
         */
        Network.NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    // Network 객체 내부에서만 쓰는 클래스니까 중첩 클래스로 만들고 private 처리
    private static class NetworkMessage {

        private String content;

        public NetworkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }

}
