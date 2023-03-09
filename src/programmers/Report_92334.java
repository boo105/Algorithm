package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Report_92334 {
    private static HashMap<String, Integer> reportResult = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] idList = br.readLine().split(", ");
        String[] reportHolder = br.readLine().split(",");
        int k = Integer.parseInt(br.readLine());

        HashMap<String, HashSet<String>> reportedInfo = report(reportHolder);
        findRestrainAccount(reportedInfo, k);
        printReportResult(idList);
    }

    private static void printReportResult(String[] idList) {
        StringBuilder sb = new StringBuilder();
        for(String id : idList) {
            id = id.substring(1, id.length() - 1);
            Integer reportResultCount = reportResult.get(id);

            if(reportResultCount == null)
                sb.append(0);
            else
                sb.append(reportResultCount);

            sb.append(", ");
        }
        System.out.println(sb);
    }

    private static HashMap<String, HashSet<String>> report(String[] reportHistory) {
        HashMap<String, HashSet<String>> reportedInfo = new HashMap<>();

        for(String report : reportHistory) {
            report = report.substring(1, report.length() - 1);
            String[] info = report.split(" ");

            HashSet<String> reporterList = reportedInfo.get(info[1]);
            if(reporterList == null)
                reporterList = new HashSet<>();
            reporterList.add(info[0]);
            reportedInfo.put(info[1], reporterList);
        }

        return reportedInfo;
    }

    private static void findRestrainAccount(HashMap<String, HashSet<String>> reportedInfo, int k) {
        for(String key : reportedInfo.keySet()) {
            HashSet<String> reporterList = reportedInfo.get(key);
            if(reporterList.size() >= k) {
                sendReportResult(reporterList);
            }
        }
    }

    private static void sendReportResult(HashSet<String> reporterList) {
        for(String reporter : reporterList) {
            Integer reportResultCount = reportResult.get(reporter);
            if(reportResultCount == null)
                reportResultCount = 0;
            reportResult.put(reporter, reportResultCount + 1);
        }
    }
}
