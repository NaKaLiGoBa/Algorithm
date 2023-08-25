const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let lines = [];
rl.on('line', line => {
  lines.push(line);
});

rl.on('close', () => {
  const N = parseInt(lines[0]);
  const goormCoordinate = lines[1].split(' ').map(Number);
  const playerCoordinate = lines[2].split(' ').map(Number);
  const board = Array.from({ length: N }, (_, i) => lines[i + 3].split(' '));
  let visited = Array.from({ length: N }, () => Array(N).fill(false));
  const goormScore = play(goormCoordinate);

  visited = Array.from({ length: N }, () => Array(N).fill(false));
  const playerScore = play(playerCoordinate);

  function play(startAt) {
    let r = startAt[0] - 1;
    let c = startAt[1] - 1;
    let score = 0;

    score++;
    visited[r][c] = true;

    let commandSize = board[r][c].length;
    let steps = parseInt(board[r][c].slice(0, commandSize - 1));
    let direction = board[r][c].charAt(commandSize - 1);

    while (steps > 0) {
      switch (direction) {
        case "L":
          c--;
          break;
        case "R":
          c++;
          break;
        case "U":
          r--;
          break;
        case "D":
          r++;
          break;
      }

      if (r < 0) r = N - 1;
      if (r >= N) r = 0;
      if (c < 0) c = N - 1;
      if (c >= N) c = 0;

      if (visited[r][c]) {
        return score;
      }

      score++;
      visited[r][c] = true;
      steps--;

      if (steps === 0) {
        commandSize = board[r][c].length;
        steps = parseInt(board[r][c].slice(0, commandSize - 1));
        direction = board[r][c].charAt(commandSize - 1);
      }
    }
    return score;
  }

  if (goormScore > playerScore) {
    console.log(`goorm ${goormScore}`);
  } else {
    console.log(`player ${playerScore}`);
  }
});
