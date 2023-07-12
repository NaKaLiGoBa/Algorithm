let fs = require('fs');
let input = fs.readFileSync('data.txt').toString().split('\n');
// let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let arr = input[1].split(' ').join('');

for (let i = 3; i < input.length; i++) {
  let question = input[i].split(' ').join('');
  let s = arr.slice(question[0] - 1, question[1]);

  if (s.length === 1) {
    console.log(1);
    continue;
  } else if (s.length === 2) {
    if (s[0] === s[1]) {
      console.log(1);
      continue;
    } else {
      console.log(0);
      continue;
    }
  };

  if (s[0] !== s[s.length - 1]) {
    console.log(0);
    continue;
  };

  if (s.length % 2 === 0) {
    for (let j = 0; j < s.length / 2; j++) {
      console.log("by")
    }
  }

  if (s === s.split('').reverse().join('')) {
    console.log(1);
  } else {
    console.log(0);
  };
};


