import java.util.*;

// Jawaban soal nomer 1
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

     
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a);
            if (freqCompare == 0) {
                return a.compareTo(b); // urut alfabet jika frekuensi sama
            }
            return freqCompare;
        });

        pq.addAll(freqMap.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"java", "python", "java", "golang", "java", "python"};
        int k = 2;
        List<String> result = topKFrequent(words, k);
        System.out.println(result); // Output: [java, python]
    }
}
