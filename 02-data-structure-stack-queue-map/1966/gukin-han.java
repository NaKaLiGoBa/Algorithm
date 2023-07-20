import javax.print.Doc;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numOfTestCases; i++) {
            StringTokenizer testCase = new StringTokenizer(br.readLine());
            int numOfDocument = Integer.parseInt(testCase.nextToken());
            int targetIndex = Integer.parseInt(testCase.nextToken());

            Queue<Document> printQ = new LinkedList<>();
            StringTokenizer givenPrintQList = new StringTokenizer(br.readLine());
            for (int givenOrder = 0; givenOrder < numOfDocument; givenOrder++) {
                int priority = Integer.parseInt(givenPrintQList.nextToken());
                printQ.add(new Document(priority, givenOrder));
            }

            answer.append(getTargetOrder(printQ, targetIndex)).append("\n");
        }
        System.out.println(answer.toString());
    }

    static class Document{
        private int priority;
        private int order;

        public Document(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public int getOrder() {
            return order;
        }
    }

    private static int getTargetOrder(Queue<Document> printQ, int targetIndex) {
        int printedNumber = 0;
        while (!printQ.isEmpty()) {
            int higherPriority = getHigherPriority(printQ);

            while (true) {
                Document currentQ = printQ.peek();
                if (currentQ.priority == higherPriority) {
                    printedNumber++;
                    if (currentQ.order == targetIndex) {
                        return printedNumber;
                    }
                    printQ.poll();
                    break;
                }
                printQ.add(printQ.poll());
            }
        }
        return printedNumber;
    }

    private static int getHigherPriority(Queue<Document> printQ) {
        int higherPriority = printQ.peek().priority;
        for (int i = 0; i < printQ.size(); i++) {
            Document currentQ = printQ.poll();
            if (currentQ.priority > higherPriority) {
                higherPriority = currentQ.priority;
            }
            printQ.add(currentQ);
        }
        return higherPriority;
    }
}


