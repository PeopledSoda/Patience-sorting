import java.util.*;

public class PatienceSortMeasured {

    public static SortStats patienceSort(int[] arr) {
        long ops = 0;

        long start = System.nanoTime();

        List<Stack<Integer>> piles = new ArrayList<>();
        List<Integer> tops = new ArrayList<>();

        // --- ЭТАП 1: построение кучек ---
        for (int num : arr) {
            ops++;

            int pos = Collections.binarySearch(tops, num);
            ops++;

            if (pos < 0) {
                pos = -pos - 1;
                ops++;
            }

            if (pos == piles.size()) {
                Stack<Integer> newPile = new Stack<>();
                newPile.push(num);
                piles.add(newPile);
                tops.add(num);
                ops += 3;
            } else {
                piles.get(pos).push(num);
                tops.set(pos, num);
                ops += 2;
            }
        }

        // --- ЭТАП 2: сборка через кучу ---
        PriorityQueue<PileNode> heap = new PriorityQueue<>();
        ops++;

        for (int i = 0; i < piles.size(); i++) {
            Stack<Integer> pile = piles.get(i);
            heap.add(new PileNode(pile.pop(), i));
            ops += 2;
        }

        int index = 0;

        while (!heap.isEmpty()) {
            ops++;

            PileNode node = heap.poll();
            arr[index++] = node.value;
            ops += 2;

            Stack<Integer> pile = piles.get(node.pileIndex);

            if (!pile.isEmpty()) {
                heap.add(new PileNode(pile.pop(), node.pileIndex));
                ops += 2;
            }
        }

        long end = System.nanoTime();

        return new SortStats(end - start, ops);
    }

    static class PileNode implements Comparable<PileNode> {
        int value;
        int pileIndex;

        PileNode(int value, int pileIndex) {
            this.value = value;
            this.pileIndex = pileIndex;
        }

        public int compareTo(PileNode other) {
            return Integer.compare(this.value, other.value);
        }
    }
}