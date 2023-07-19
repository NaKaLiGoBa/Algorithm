function solution(board, moves) {
  let stack = [];
  let cnt = 0;

  moves.forEach((row) => {
    for (let i = 0; i < board.length; i++) {
      if (board[i][row - 1] !== 0) {
        let temp = board[i][row - 1];
        board[i][row - 1] = 0;

        if (temp === stack[stack.length - 1]) {
          stack.pop();
          cnt += 2;
        } else {
          stack.push(temp);
        };
        break;
      }
    };
  });

  return cnt;
};

