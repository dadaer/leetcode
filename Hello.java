import java.util.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{2,5,9,2,1,4}, 4));
    }

    public static int hello0(int[] A, int M) {
        int ret = 0;
        int[] ints = new int[M];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % M >= 0) {
                ints[A[i] % M]++;
            } else {
                ints[A[i] % M + M]++;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            ret = Math.max(ret, ints[i]);
        }
        return ret;
    }

    class Point{
        int val;
        char chars;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public char getChars() {
            return chars;
        }

        public void setChars(char chars) {
            this.chars = chars;
        }

        Point(int val, char chars) {
            this.val = val;
            this.chars = chars;
        }
    }

    public  int solution(String S, int[] X, int[] Y) {
        boolean[] visited = new boolean[26];
        Arrays.fill(visited,false);
        int n = S.length(), ans = 0;
        List<Point> P = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            P.add(new Point(X[i] * X[i] + Y[i] * Y[i], S.charAt(i)));
        }
        Collections.sort(P, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.val != o2.val) return o1.val - o2.val;
                else return o1.chars - o2.chars;
            }
        });
        if (n > 0) {
            visited[P.get(0).chars - 'A'] = true;
            ans++;
        }
        int l = P.get(0).val;
        boolean ifcontinue = true;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (; i < n; i++) {
                if (P.get(i).val == l) {
                    if (!visited[P.get(i).chars - 'A']) {
                        if (i + 1 < n) {
                            if (P.get(i) == P.get(i + 1)) {
                                ifcontinue = false;
                                break;
                            }
                        }
                        visited[P.get(i).chars - 'A'] = true;
                        cnt++;
                    } else {
                        ifcontinue = false;
                        break;
                    }
                } else {
                    i--;
                    break;
                }
            }
            if (!ifcontinue) break;
            ans += cnt;
            if (i < n - 1) l = P.get(i + 1).val;
        }
        return ans;
    }

    public static int solution1(int[] D, int x) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, ret = 1;
        for(int i = 0; i < D.length; i++) {
            max = Math.max(max, D[i]);
            min = Math.min(min, D[i]);
            if(D[i] - min <= x && max - D[i] <= 3) continue;
            else {
                max = D[i];
                min = D[i];
                ret++;
            }
        }
        return ret;
    }
}
