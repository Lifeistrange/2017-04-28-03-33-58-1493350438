
public class BowlingGame {

    private String[] bowlingList;

    public int getBowlingScore(String bowlingCode) {
        int bowlingScore = 0;
        bowlingList = bowlingCode.split("\\|");
        for(int i = 0; i < 10; i++) {
            if(bowlingList[i].contains("X")){
                bowlingScore = bowlingScore + 10 + getTowBowling(i);
            } else if (bowlingList[i].contains("/")){
                bowlingScore = bowlingScore + 10 + getOneBowling(i);
            } else {
                bowlingScore = bowlingScore + parserBowling(bowlingList[i].substring(0,1)) + parserBowling(bowlingList[i].substring(1,2));
            }
        }
        return bowlingScore;

    }

    private int getTowBowling(int index) {
        if(bowlingList[index+1].equals("")) {
            return getTowBowling(index+1);
        } else if (bowlingList[index+1].contains("/")) {
            return 10;
        } else if (bowlingList[index+1].equals("X")) {
            return 10 + getOneBowling(index+1);
        } else if (bowlingList[index+1].equals("XX")) {
            return 20;
        } else {
            return parserBowling(bowlingList[index+1].substring(0,1)) + parserBowling(bowlingList[index+1].substring(1,2));
        }
    }

    private int getOneBowling(int index) {
        if (bowlingList[index+1].equals("")) {
            return getOneBowling(index+1);
        } else {
            return parserBowling(bowlingList[index+1].substring(0,1));
        }
    }

    private int parserBowling(String one) {
        if (one.equals("X")) {
            return 10;
        } else if (one.equals("-")) {
            return 0;
        } else {
            return Integer.parseInt(one);
        }
    }
}
