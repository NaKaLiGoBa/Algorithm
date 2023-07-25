let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString();
let iSplit = input.split('\n');
let meta = iSplit[0].split(' ');
let vertex = Number(meta[0]);
let edge = Number(meta[1]);
let startNode = Number(meta[2]);
// 0 ~ 3
const adArr = Array.from(Array(vertex), () => Array(vertex).fill(0)); // 인접행렬
let dfsResult = '';
let bfsResult = '';

for (let i = 1; i < edge + 1; i++) {
    let value = iSplit[i].split(" ");
    let from = Number(value[0]) - 1;
    let to = Number(value[1]) - 1;
    adArr[from][to] = 1;
    adArr[to][from] = 1;
}


let visited = Array(vertex).fill(0);

function dfs(start) {
    if (!visited.includes(0))
        return;
    visited[start] = 1;
    dfsResult += start + 1 + ' ';

    for (let i = 0; i < vertex; i++) {
        if (adArr[start][i] === 1 && visited[i] === 0) {
            dfs(i);
        }
    }
}

function bfs(start) {
    const queue = [];
    queue.push(start);
    const visited = Array(vertex).fill(0);
    visited[start] = 1;

    while(queue.length !== 0) {
        let curNode = queue.shift();
        bfsResult += curNode + 1 + ' ';
        for (let i = 0; i < vertex; i++) {
            if (adArr[curNode][i] === 1 && visited[i] === 0) {
                queue.push(i);
                visited[i] = 1;
            }
        }
    }
}

dfs(startNode - 1);
bfs(startNode - 1);
console.log(dfsResult)
console.log(bfsResult)

