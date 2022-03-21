package io.zipcoder;

public class Music {
    private String[] playList;
    private int upButton = -1;
    private int downButton = 1;



    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        Integer minSkips= 0;
        int downSkips = 0;
        int upSkips = 0;
        for (int i = startIndex; i < playList.length;){
            if (playList[i].equals(selection)){
                break;
            }
            while (!selection.equals(playList[i]) ) {
                i += downButton;
                downSkips++;
            }
            i = startIndex;
            while (!selection.equals(playList[i])){
                if(startIndex != 0) {
                    i += upButton;
                    upSkips++;
                }
                if(selection.equals(playList[i])) break;
                if (i == 0){
                    i = playList.length - 1;
                    upSkips++;
                    if(selection.equals(playList[i])) break;
                }
            }
            minSkips = Math.min(upSkips,downSkips);
            break;
        }
        return minSkips;
    }
}
