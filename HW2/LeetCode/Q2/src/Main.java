public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestWordDistance(wordsDict,"makes","coding"));
        System.out.println(shortestWordDistance(wordsDict,"coding","makes"));

        System.out.println(shortestWordDistance(wordsDict,"notExist","coding"));
    }

    public static int shortestWordDistance(String[] wordsDict, String word1, String word2){
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i] == word1){
                for (int j = i+1; j < wordsDict.length; j++) {
                    if(wordsDict[j] == word2){
                        distance = j-i < distance ? j-i : distance;
                    }
                }
            }
            if(wordsDict[i] == word2){
                for (int j = i+1; j < wordsDict.length; j++) {
                    if(wordsDict[j] == word1){
                        distance = j-i < distance ? j-i : distance;
                    }
                }
            }
        }
        return distance == Integer.MAX_VALUE ? -1: distance;
    }
}
