function solution(input) {
  let cnt = 0;

  for (let i = 1; i < input.length; i++) {
    let arr = input[i];
    let temp = arr[0];
    let tempArr = [];
    let isDuplication = false;

    for (let j = 1; j < arr.length; j++) {
      if (temp === arr[j]) {
        continue;
      } else {
        tempArr.push(temp);
        temp = arr[j];

        if (tempArr.includes(temp)) {
          isDuplication = true;
          break;
        }
      }
    }
    if (!isDuplication) {
      cnt += 1;
    }
  };

  return cnt;
}

const input = [];
require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    console.log(solution(input));
    process.exit();
  });
