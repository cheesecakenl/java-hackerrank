package nl.dev4all.hackerrank.interview.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        SockMerchant solution = new SockMerchant();
        int result = solution.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the sockMerchant function below.
    int sockMerchant(int n, int[] ar) {

        List<Sock> socks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int type = ar[i];

            boolean exists = false;
            for (Sock s : socks) {
                if (s.type == type) {
                    s.amount += 1;
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                Sock newSock = new Sock(type, 1);
                socks.add(newSock);
            }
        }

        int pairs = 0;
        for (Sock sock : socks) {
            pairs += Math.floor(sock.amount / 2);
        }

        return pairs;
    }

    class Sock {
        int type;
        int amount;

        public Sock(int type, int amount) {
            this.type = type;
            this.amount = amount;
        }
    }
}
