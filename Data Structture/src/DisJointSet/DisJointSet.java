package DisJointSet;

public interface DisJointSet {
    void connect(int p, int q);
    boolean isConnected(int p, int q);
}
