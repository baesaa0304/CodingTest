import java.util.LinkedList;
import java.util.Stack;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> stack = new Stack<Integer>();
        
        // 현재 표의 크기를 저장하는 변수
        int table_size = n;
        
        // 명령어 처리 루프
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            
            // "D x" 명령어 처리
            if(c=='D')
                k+=Integer.parseInt(cmd[i].substring(2));
            
            // "U x" 명령어 처리    
            else if(c=='U')
                k-=Integer.parseInt(cmd[i].substring(2));
            
            // "C" 명령어 처리
            else if(c=='C') {
                // 현재 커서 위치의 행을 삭제하고 스택에 저장
                stack.add(k);
                table_size--;
                
                // 만약 현재 커서가 마지막 행이었다면 커서를 1 감소시킴
                if(k==table_size)
                    k--;
            }
            
            // "Z" 명령어 처리
            else if(c=='Z') {
                // 가장 최근에 삭제된 행의 인덱스를 스택에서 pop
                if(stack.pop()<=k)
                    k++;
                table_size++;
            }
        }
        
        // 최종 결과 문자열 생성
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<table_size; i++)
            builder.append("O");
        while(!stack.isEmpty())
            builder.insert(stack.pop().intValue(), "X");
        String answer = builder.toString();
        return answer;
    }
}
