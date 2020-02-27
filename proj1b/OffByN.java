public class OffByN implements CharacterComparator {
    private int D;
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == D) {
            return true;
        } else {
            return false;
        }
    }
    public OffByN(int N) {
        D = N;
    }
}
