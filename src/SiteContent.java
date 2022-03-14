import java.util.*;

public class SiteContent {
    private Map<String, String> sitesMap;
    private Map<String, Integer> countWordsMap;
    private Map<String, Map<String, Integer>> wordsOnSiteMap;


    public SiteContent() {
        this.sitesMap = new HashMap<>();
        this.countWordsMap = new HashMap<>();
        this.wordsOnSiteMap = new HashMap<>();

    }

    public Map<String, Integer> getCountWordsMap() {
        return countWordsMap;
    }

    public Map<String, Map<String, Integer>> getWordsOnSiteMap() {
        return wordsOnSiteMap;
    }

    public Map<String, String> getSitesMap() {
        return sitesMap;
    }


    public void addWordsOnSiteMap(Map<String, String> sitesMap) {
        Set<Map.Entry<String, String>> set = sitesMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            String keySite = entry.getKey();
            String value = entry.getValue().toLowerCase().replaceAll("\\p{P}", "");
            String[] values = value.split(" ");
            Map<String, Integer> map = new HashMap<>();

            for (String str : values)
                if (countWordsMap.containsKey(str)) {
                    countWordsMap.put(str, countWordsMap.get(str) + 1);
                    map.put(str, countWordsMap.get(str));
                    wordsOnSiteMap.put(keySite, map);
                } else {
                    countWordsMap.put(str, 1);
                    map.put(str, countWordsMap.get(str));
                    wordsOnSiteMap.put(keySite, map);
                }

        }
    }

    public void showSitesMap(Map<String, String> sitesMap) {
        System.out.println();
        for (Map.Entry<String, String> entry : sitesMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

    }

}



















