import java.util.*;

public class SearchWord {
    private Map<String, Integer> resultValues;
    private Set<String> inputWords;


    public SearchWord() {
        this.resultValues = new HashMap<>();
        this.inputWords = new HashSet<>();
    }


    public Map<String, Integer> getResultValues() {
        return resultValues;
    }

    public Set<String> getInputWords() {
        return inputWords;
    }


    public void addInputWords(Scanner scanner) {
        String input = scanner.nextLine();
        String word = input.toLowerCase().trim().replaceAll("\\p{P}", "");
        String[] words = word.split(" ");
        for (int i = 0; i < words.length; i++) {
            inputWords.add(words[i]);
        }
    }

    public void clearRequest() {
        inputWords.clear();
        resultValues.clear();
    }


    public void addResultValues(Map<String, Map<String, Integer>> wordsOnSiteMap) {
        for (Map.Entry<String, Map<String, Integer>> entry : wordsOnSiteMap.entrySet()) {
            String siteName = entry.getKey();
            for (String word : inputWords) {
                if (wordsOnSiteMap.get(siteName).containsKey(word)) {
                    int count;
                    if (resultValues.containsKey(siteName)) {
                        count = resultValues.get(siteName) + wordsOnSiteMap.get(siteName).get(word);
                    } else {
                        count = wordsOnSiteMap.get(siteName).get(word);
                    }
                    resultValues.put(siteName, count);
                }
            }
        }
    }

    public static void showRankingSites(Map<String, Integer> resultValues) {
        System.out.println();
        System.out.println("Были найдены следующие сайты:");
        resultValues.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey()));
    }

}









