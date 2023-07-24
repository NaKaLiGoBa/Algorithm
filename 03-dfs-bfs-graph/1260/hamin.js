const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M, V] = input.shift().split(' ').map(Number);
const edges = input.map(v => v.split(' ').map(Number));
const graph = Array.from(Array(Number(N + 1)).fill(false), () => []); // 정점의 개수만큼 배열 생성

for (const [start, end] of edges) {
  graph[start].push(end); // 원점에서 도착지를 인접 리스트에 추가
  graph[end].push(start); // 양방향으로 둘 다 갈 수 있도록
}; // 그래프 완성

function BFS(V) {
  const queue = [V]; // 탐색 시작점
  const visited = Array(N + 1).fill(false); // 방문 여부 체크 배열
  const order = [];
  while (queue.length > 0) {
    const node = queue.shift();

    if (!visited[node]) {
      visited[node] = true;
      order.push(node);
      queue.push(...graph[node]); // graph와 인접한 노드
    };
  };

  console.log(order.join(' ')) // 방문한 순서를 적는 배열
};

const DFS = (V) => {
  const stack = [V];                                    // 탐색 시작점
  const visited = Array(N + 1).fill(false);
  const order = []; while (stack.length > 0) {
    const node = stack.pop();

    if (!visited[node]) {
      visited[node] = true;
      order.push(node);
      stack.push(...graph[node]);
    };
  };

  console.log(order.join(' ')) // 방문한 순서를 적는 배열
};

// 스택 구조로 pop 사용 => 내림차순 
// ex) [ [], [ 2, 3, 4 ], [ 1, 4 ], [ 1, 4 ], [ 1, 2, 3 ] ]
graph.forEach(v => v.sort((a, b) => b - a));
DFS(V);

// 큐 구조로 shift 사용 => 오름차순
// ex) [ [], [ 4, 3, 2 ], [ 4, 1 ], [ 4, 1 ], [ 3, 2, 1 ] ]
graph.forEach(v => v.sort((a, b) => a - b));
BFS(V);
