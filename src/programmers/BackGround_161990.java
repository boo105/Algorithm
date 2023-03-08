package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BackGround_161990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // x, y 최소 최대 좌표 찾는거임
        String[] wallpaper = br.readLine().split(" ");
        for(int i = 0; i < wallpaper.length; i++) {
            wallpaper[i] = wallpaper[i].substring(1, wallpaper[i].length() - 1);
        }

        HashMap<String, Integer> xMinAndMax = getMinAndMaxDragXPosition(wallpaper);
        HashMap<String, Integer> yMinAndMax = getMinAndMaxDragYPosition(wallpaper);

        sb.append(yMinAndMax.get("min")).append(",");
        sb.append(xMinAndMax.get("min")).append(",");
        sb.append(yMinAndMax.get("max")).append(",");
        sb.append(xMinAndMax.get("max"));

        System.out.println(sb);
    }

    private static HashMap<String,Integer> getMinAndMaxDragXPosition(String[] wallpaper) {
        HashMap<String,Integer> minAndMax = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(String space : wallpaper) {
            for(int i = 0; i < space.length(); i++) {
                char content = space.charAt(i);
                if(content == '#' && min > i) {
                    min = i;
                }

                if(content == '#' && max < i + 1) {
                    max = i + 1;
                }
            }
        }

        minAndMax.put("min", min);
        minAndMax.put("max", max);

        return minAndMax;
    }

    private static HashMap<String, Integer> getMinAndMaxDragYPosition(String[] wallpaper) {
        HashMap<String,Integer> minAndMax = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < wallpaper.length; i++) {
            String space = wallpaper[i];
            if(space.contains("#")) {
                if(min > i) {
                    min = i;
                }

                if(max < i + 1) {
                    max = i + 1;
                }
            }
        }

        minAndMax.put("min", min);
        minAndMax.put("max", max);
        return minAndMax;
    }
}
