import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        
        // Create NxN board to track down who report(row) and who was reported(column)
        int numOfUsers = id_list.length;
        boolean[][] reportBoard = new boolean[numOfUsers][numOfUsers];
        
        // Map username to index to make easy to the report process
        Map<String, Integer> mapToIndex= new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            mapToIndex.put(id_list[i], i);
        }
        
        // Report process on ReportBoard
        for(String report: reports) {
            String[] parsedReport = report.split(" ");
            String reporter = parsedReport[0];
            String reportedUser = parsedReport[1];
            int reporterId = mapToIndex.get(reporter);
            int reportedUserId = mapToIndex.get(reportedUser);
            
            reporting(reportBoard, reporterId, reportedUserId);
        }
        
        // Check suspended Users
        boolean[] whoGotSuspended = new boolean[numOfUsers];
        for(int to = 0; to < numOfUsers; to++) {
            int numOfReports = 0;
            
            for (int from = 0; from < numOfUsers; from++) {
                if (reportBoard[from][to]) numOfReports++;
            }
            
            if(numOfReports >= k) whoGotSuspended[to] = true;
        }
        
        // Check num Of Suspended Users
        int[] answer = new int[numOfUsers];
        for(int reporter = 0; reporter < answer.length; reporter++) {
            boolean[] usersReported = reportBoard[reporter];
            for(int i = 0; i < usersReported.length; i++) {
                if(whoGotSuspended[i] && usersReported[i]) answer[reporter]++;
            }
        }
        return answer;
    }
    
    private void reporting(boolean[][] board, int IdFrom, int IdTo) {
        board[IdFrom][IdTo] = true;
    }
}
