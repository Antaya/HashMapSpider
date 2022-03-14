import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SiteContent siteContent = new SiteContent();
        SearchWord searchWord = new SearchWord();

        Map<String, String> sitesMap = siteContent.getSitesMap();
        sitesMap.put("pikabu.ru", "Котята занялись рукоделием, посмотрите. #пятничное #моё #котята");
        sitesMap.put("vk.com", "Бизнес цитаты и поцанский паблик. Заработал МЕЛЛИОН за день в 16 лет.");
        sitesMap.put("rutracker.org", "Доступ запрещен. Слава Роскомнадзору!");


        Map<String, Map<String, Integer>> wordsOnSiteMap = siteContent.getWordsOnSiteMap();
        Map<String, Integer> resultValues = searchWord.getResultValues();

        siteContent.showSitesMap(sitesMap);
        siteContent.addWordsOnSiteMap(sitesMap);

        while (true) {
            System.out.println();
            System.out.println("Введите запрос:");
            searchWord.addInputWords(scanner);
            searchWord.addResultValues(wordsOnSiteMap);
            searchWord.showRankingSites(resultValues);
            searchWord.clearRequest();

            System.out.println();
            System.out.println("Для завершения программы введите exite, для продолжения нажмите enter");
            String input = scanner.nextLine();
            if ("exite".equals(input)) {
                System.out.println("Завершение программы");
                break;
            }

        }
    }


}









