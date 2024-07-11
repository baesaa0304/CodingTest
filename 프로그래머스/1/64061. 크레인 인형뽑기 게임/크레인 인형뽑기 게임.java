import java.util.*;

class Solution {
  public int solution(int[][] board, int[] moves) {
    // 각 열에 대한 스택을 저장할 해시맵을 생성합니다.
    HashMap<Integer, Stack<Integer>> stack = new HashMap<>();
    for (int i = 0; i < board[0].length; i++) {
    	stack.put(i, new Stack<>());  // 각 열에 대해 새로운 스택을 생성하여 해시맵에 추가
    }

    // board를 역순으로 탐색하며, 각 열의 인형을 해시맵에 추가합니다.
    for (int i = board.length - 1; i >= 0; i--) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] > 0) {
        	stack.get(j).push(board[i][j]);  // 해당 열의 스택에 인형을 추가
        }
      }
    }

    // 인형을 담을 bucket을 생성합니다.
    Stack<Integer> bucket = new Stack<>();
    // 사라진 인형의 총 개수를 저장할 변수를 초기화합니다.
    int answer = 0;

    // moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가합니다.
    for (int move : moves) {
      Stack<Integer> stacks = stack.get(move - 1); // 현재 열의 있는 스택에서 가져옴 
      if (!stacks.isEmpty()) { // 해당 열에 인형이 있는 경우
        int doll = stacks.pop();
        // 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
        if (!bucket.isEmpty() && bucket.peek() == doll) {
          bucket.pop();
          answer += 2;
        } else { // 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
          bucket.push(doll);
        }
      }
    }
    return answer;
  }
}