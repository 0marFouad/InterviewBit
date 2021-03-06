package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Years {

    public static class Point implements Comparable<Point>{
        boolean isStart;
        long num;
        public Point(boolean isStart, long num){
            this.isStart = isStart;
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            if(o.num != this.num){
                return Long.compare(num,o.num);
            }else{
                if(isStart){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        long[][] arr = new long[t][2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<t;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = sc.nextInt();
                pq.add(new Point(j%2==0,arr[i][j]));
            }
        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        long year = -1;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(p.isStart){
                ans++;
                if(max<ans){
                    max = ans;
                    year = p.num;
                }
            }else{
                ans--;
            }
        }
        System.out.println(year + " " + max);
    }










    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}


