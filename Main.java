import java.util.Scanner;

class Main {
    // 构建线段树
    public static void buildTree(int[] arr, int[] tree, int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, tree, start, mid, 2 * index);
        buildTree(arr, tree, mid + 1, end, 2 * index + 1);
        tree[index] = tree[2 * index] | tree[2 * index + 1];
    }

    // 查询
    public static int query(int[] tree, int start, int end, int left, int right, int index) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && right >= end) {
            return tree[index];
        }
        int mid = (start + end) / 2;
        int leftAns = query(tree, start, mid, left, right, 2 * index);
        int rightAns = query(tree, mid + 1, end, left, right, 2 * index + 1);
        return leftAns | rightAns;
    }

    // 更新
    public static void updateOr(int[] tree, int start, int end, int left, int right, int value, int index) {
        if (left > end || right < start) {
            return;
        }
        if (start == end) {
            tree[index] |= value;
            return;
        }
        int mid = (start + end) / 2;
        updateOr(tree, start, mid, left, right, value, 2 * index);
        updateOr(tree, mid + 1, end, left, right, value, 2 * index + 1);
        tree[index] = tree[2 * index] | tree[2 * index + 1];
    }

    public static void updateAnd(int[] tree, int start, int end, int left, int right, int value, int index) {
        if (left > end || right < start) {
            return;
        }
        if (start == end) {
            tree[index] &= value;
            return;
        }
        int mid = (start + end) / 2;
        updateAnd(tree, start, mid, left, right, value, 2 * index);
        updateAnd(tree, mid + 1, end, left, right, value, 2 * index + 1);
        tree[index] = tree[2 * index] | tree[2 * index + 1];
    }

    public static void updateSet(int[] tree, int start, int end, int left, int right, int value, int index) {
        if (left > end || right < start) {
            return;
        }
        if (start == end) {
            tree[index] = value;
            return;
        }
        int mid = (start + end) / 2;
        updateSet(tree, start, mid, left, right, value, 2 * index);
        updateSet(tree, mid + 1, end, left, right, value, 2 * index + 1);
        tree[index] = tree[2 * index] | tree[2 * index + 1];
    }

    public static void main(String[] args) {
        // 使用线段树
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] left = new int[m];
        int[] right = new int[m];
        char[] a = new char[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            right[i] = scanner.nextInt();
        }
        String s = scanner.next();
        for (int i = 0; i < m; i++) {
            a[i] = s.charAt(i);
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int[] tree = new int[4 * n];
        buildTree(arr, tree, 0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            if (a[i] == '|') {
                updateOr(tree, 0, n - 1, left[i] - 1, right[i] - 1, b[i], 1);
            } else if (a[i] == '&') {
                updateAnd(tree, 0, n - 1, left[i] - 1, right[i] - 1, b[i], 1);
            } else {
                updateSet(tree, 0, n - 1, left[i] - 1, right[i] - 1, b[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(query(tree, 0, n - 1, i, i, 1) + " ");
        }
    }
}