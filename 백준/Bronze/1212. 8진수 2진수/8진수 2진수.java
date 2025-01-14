import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String eight = br.readLine();
		   for (int i = 0; i < eight.length(); i++) {
	            int num = eight.charAt(i) - '0'; // 8진수 문자 -> 숫자

	            // 2진수로 변환
	            String binary = Integer.toBinaryString(num);

	            if (i == 0) {
	                // 첫 번째 숫자: 앞의 0 제거된 상태로 추가
	                sb.append(binary);
	            } else {
	                // 나머지 숫자: 3자리로 맞춤
	                while (binary.length() < 3) {
	                    binary = "0" + binary; // 앞에 0을 채움
	                }
	                sb.append(binary);
	            }
	        }

	        // 최종 결과 출력
	        System.out.println(sb.toString());
	    }
	}
