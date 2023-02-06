





































//문자열 추출
//substring
//
//문자열 비교
//equals
//
//문자열 변경
//replaceAll
//다중[369] [^369]
//
//문자열 뒤집기 StringBuffer(str).reverse().toString();
//
//문자열 포함여부
//s.contains
//
//큰수비교
//Math.max
//
//반올림 올림 내림
//round ceil floor
//
//double 연산결과가 이상하면 소수점
//
//배열 정렬 
//Arrays.sort()
//
//역순 정렬
//arr, Collections.reverseOrder()
//


//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//import java.util.StringTokenizer;
// 두전구
//class Solution {
//    static int A, B, C, D;
//     
//    static StringTokenizer st;
//    static BufferedWriter bw;
//     
//    static int[] time;
//     
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = Integer.parseInt(sc.nextLine());
//         
//        for(int tc = 0; tc < T; ++tc) {
//            st = new StringTokenizer(sc.nextLine(), " ");
//            A = Integer.parseInt(st.nextToken());
//            B = Integer.parseInt(st.nextToken());
//            C = Integer.parseInt(st.nextToken());
//            D = Integer.parseInt(st.nextToken());
//            time = new int[100];
//            int cnt = 0;
//            for(int i = A; i < B; ++i) {
//                time[i] += 1;
//            }
//            for(int i = C; i < D; ++i) {
//                time[i] += 1;
//            }
//            for(int i = 0; i < 100; ++i) {
//                if(time[i] == 2) {
//                    cnt++;
//                }
//            }
//            bw.append(String.format("#%d %d\n", tc + 1, cnt));
//        }
//        bw.flush();
//        bw.close();
//    }
//}
































//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//import java.util.StringTokenizer;
// 
//class Solution {
//     교환학생
//    static StringTokenizer st;
//    static BufferedWriter bw;
//    static Scanner sc;
//    static int[] Table = new int[7];
//     
//    public static void main(String[] args) throws IOException {
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        sc = new Scanner(System.in);
//         
//        int T = Integer.parseInt(sc.nextLine());
//         
//        for(int tc = 0; tc < T; ++tc) {
//            int D_day = Integer.parseInt(sc.nextLine());
//             
//            st = new StringTokenizer(sc.nextLine(), " ");
//             
//            for(int i = 0; i < 7; ++i) {
//                Table[i] = Integer.parseInt(st.nextToken());
//            }
//             
//            int min = Integer.MAX_VALUE;
//             
//            for(int j = 0; j < 7; ++j) {
//                int cnt = 0;
//                int Temp_day = D_day;
//                for(int i = 0; Temp_day > 0; ++i) {
//                    Temp_day -= Table[(i + j) % 7];
//                    cnt++;
//                }
//                if(min > cnt) {
//                    min = cnt;
//                }
//            }
//            bw.append(String.format("#%d %d\n", tc + 1, min));
//        }
//        bw.flush();
//        bw.close();
//    }
//}





























//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
// 조별과제
//class Solution {
//    static BufferedWriter bw;
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int T = Integer.parseInt(sc.nextLine());
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for(int i = 0; i < T; ++i) {
//            int res = Integer.parseInt(sc.nextLine()) / 3;
//            bw.append(String.format("#%d %d\n", i + 1, res));
//        }
//        bw.flush();
//        bw.close();
//    }
//}
















//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//  일요일
//class Solution {
//    static BufferedWriter bw;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         
//        N = Integer.parseInt(sc.nextLine());
//        String s = "";
//        WEEK w = new WEEK();
//        for(int i = 0; i < N; ++i) {
//            bw.append(String.format("#%d %d\n", (i + 1), w.reday(sc.nextLine())));
//        }
//        bw.flush();
//        bw.close();
//    }
//     
//     
//}
//class WEEK {
//    public String[] Week = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
//    public int[] re = { 6, 5, 4, 3, 2, 1, 7 };
//     
//    public int reday(String s) {
//        return re[Arrays.asList(Week).indexOf(s)];
//    }
//}
//
//




























//import java.util.Scanner;
//  
//class Solution {
//    static int T;
// 
//    static int N[];
//    static String[] S;
//    static String word[];
//     팔씨름
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//         
//        T = sc.nextInt();
// 
//        N = new int[T];
//        S = new String[T];
//        word = new String[T];
//         
//        sc.nextLine();
//        for(int i = 0; i < T; i++) {
//            word[i] = sc.nextLine();
//            N[i] = 0;
//            for(int j = 0; j < word[i].length(); ++j) {
//                if(word[i].charAt(j) == 'x') {
//                    N[i] += 1;
//                }
//            }
//        }
//         
//        for(int i = 0; i < T; i++) {
//            if(N[i] < 8) {
//                System.out.printf("#%d YES\n", i + 1);
//            }else if(N[i] >= 8) {
//                System.out.printf("#%d NO\n", i + 1);
//            }
//        }
//    }
//}






//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
// 
//class Solution {
//    public static int N = 0;
//    public static char[][] map;
//    public static boolean[][] visit;
//    static BufferedWriter bw;
//     정사각형 판정
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = Integer.parseInt(sc.nextLine());
//         
//        for(int tc = 1; tc <= T; ++tc) {
//            N = Integer.parseInt(sc.nextLine());
//            map = new char[N][N];
//            visit = new boolean[N][N];
//             
//            int startX = -1;
//            int startY = -1;
//             
//            for(int i = 0; i < N; ++i) {
//                String s = sc.nextLine();
//                for(int j = 0; j < N; ++j) {
//                    map[i][j] = s.charAt(j);
//                    if(map[i][j] == '#') {
//                        if(startX == -1 && startY == -1) {
//                            startX = i;
//                            startY = j;
//                        }
//                    }
//                }
//            }
//            int cnt = 0;
//            for (int i = startY; i < N; i++) {
//                if(map[startX][i] == '#') {
//                    cnt += 1;
//                } else {
//                    break;
//                }
//            }
//            boolean chk = true;
//            outer: for (int i = startX; i < startX + cnt; i++) {
//                for (int j = startY; j < startY + cnt; j++) {
//                    visit[i][j] = true;
//                    if (map[i][j] != '#') {
//                        chk = false;
//                        break outer;
//                    }
//                }
//            }
//            outer: for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (map[i][j] == '#' && !visit[i][j]) {
//                        chk = false;
//                        break outer;
//                    }
//                }
//            }
//            bw.append(String.format("#%d %s\n", tc, (chk ? "yes" : "no")));
//        }
//        bw.flush();
//        bw.close();
//    }
//}



//import java.util.Scanner;
// 1차원 정원
//public class Solution {
//    static int T;
//    static double N;
//    static double D;
//    static long[] ret;
//    static String sum[];
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        T = sc.nextInt();
// 
//        ret = new long[T];
//         
//        for(int i = 0; i < T; ++i) {
//            N = sc.nextDouble();
//            D = sc.nextDouble();
//            ret[i] = (long) Math.ceil( N / (D * 2 + 1));
//        }
//         
//         
//        for(int i = 0; i < T; ++i) {
//            System.out.printf("#%d %d\n", i + 1, ret[i]);
//        }
//    }
//}
//

































































//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class Solution{
//	static BufferedReader br;
//	static BufferedWriter bw;
//	static StringTokenizer st;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new InputStreamReader(System.in));
//		bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		수도쿠
//		int T = Integer.parseInt(br.readLine());
//		int[][] map = new int[9][9];
//		for(int tc = 1; tc <= T; ++tc) {
//			int ans = 1;
//			for(int i = 0; i < 9; ++i) {
//				st = new StringTokenizer(br.readLine(), " ");
//				for(int j = 0; j < 9; ++j) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			for(int i = 0; i < 9; ++i) {
//				int[] rvisited = new int[9];
//				int[] cvisited = new int[9];
//				for(int j = 0; j < 9; ++j) {
//					++rvisited[map[i][j] - 1];
//					++cvisited[map[j][i] - 1];
//					if(rvisited[map[i][j] - 1] != 1 || cvisited[map[j][i] - 1] != 1) {
//						ans = 0;
//						break;
//					}
//				}
//			}
//			if(ans == 0) {
//				bw.append(String.format("#%d %d\n", tc, ans));
//				continue;
//			}
//			
//			L:for(int i = 0; i < 9; i+=3) {
//				for(int j = 0; j < 9; j+=3) {
//					int[] gvisited = new int[9];
//					for(int x = 0; x < 3; ++x) {
//						for(int y = 0; y < 3; ++y) {
//							++gvisited[map[i + x][j + y] - 1];
//							if(gvisited[map[i + x][j + y] - 1] != 1) {
//								ans = 0;
//								break L;
//							}
//						}
//					}
//				}
//			}
//			bw.append(String.format("#%d %d\n", tc, ans));
//		}
//		br.close();
//		bw.flush();
//		bw.close();
//	}
//}



//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
// 
//public class Solution {
//    static BufferedReader br;
//    static BufferedWriter bw;
//    static StringTokenizer st;
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         단어 끼우기
//        int T = Integer.parseInt(br.readLine());
//        for(int tc = 1; tc <= T; ++tc) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int N = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//            int[] arr = new int[N];
//            int cnt = 0;
//            for(int i = 0; i < N; ++i) {
//                int x = 0;
//                st = new StringTokenizer(br.readLine(), " ");
//                for(int j = 0; j < N; ++j) {
//                    if(Integer.parseInt(st.nextToken()) == 1) {
//                        ++x;
//                        ++arr[j];
//                    } else {
//                        x = 0;
//                        arr[j] = 0;
//                    }
//                    if(x == K) {
//                        ++cnt;
//                    }
//                    if(arr[j] == K) {
//                        ++cnt;
//                    }
//                    if(x == K + 1) {
//                        --cnt;
//                    }
//                    if(arr[j] == K + 1) {
//                        --cnt;
//                    }
//                }
//            }
//            bw.append(String.format("#%d %d\n", tc, cnt));
//        }
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}




//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.StringTokenizer;
// 성적
//public class Solution {
//    static BufferedReader br;
//    static BufferedWriter bw;
//    static StringTokenizer st;
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
//        int T = Integer.parseInt(br.readLine());
//        for(int tc = 1; tc <= T; ++tc) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int N = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//            double select = 0;
//            double[] res = new double[N];
//            for(int i = 0 ; i < N; ++i) {
//                st = new StringTokenizer(br.readLine(), " ");
//                int mid_exam = Integer.parseInt(st.nextToken());
//                int fin_exam = Integer.parseInt(st.nextToken());
//                int project = Integer.parseInt(st.nextToken());
//                 
//                res[i] = mid_exam * 0.35 + fin_exam *0.45 + project * 0.2;
//                if(i + 1 == K) {
//                    select = res[i];
//                }
//            }
//            Arrays.sort(res);
//            int rank = 0;
//            for(int i = 0; i < res.length; ++i) {
//                if(res[i] == select) {
//                    rank = i;
//                }
//            }
//            rank /= (N / 10);
//            bw.append(String.format("#%d %s\n", tc, grade[rank]));
//        }
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}