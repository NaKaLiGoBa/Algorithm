const [N, M] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);

const array = Array.from({length: N}, (_, i) => i + 1);
const answer = [];
const visited = new Array(N).fill(false);

function getPermutation(array, M, permutation) {

    if (permutation.length === M) {
        answer.push([...permutation].join(" "));
    }

    for (let i = 0; i < array.length; i++) {

        if (visited[i]) continue;

        permutation.push(array[i]);
        visited[i] = true;
        getPermutation(array, M, permutation);
        permutation.pop();
        visited[i] = false;
    }
}

getPermutation(array, M, [])

console.log(answer.join("\n"));

