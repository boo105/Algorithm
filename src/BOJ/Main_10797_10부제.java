package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10797_10부제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());
        String[] cars = br.readLine().split(" ");

        int count = 0;
        for(String car : cars) {
            int carLicence = Integer.parseInt(car);
            if(day == carLicence)
                count++;
        }

        System.out.println(count);

    }
}
