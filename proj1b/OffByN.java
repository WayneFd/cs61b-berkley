public class OffByN implements CharacterComparator {
    private int D;
    public OffByN(int N) {
        D = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == D;
    }

}
