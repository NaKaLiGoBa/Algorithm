const input = require('fs').readFileSync('/dev/stdin').toString().trim();
let s = [...input];
let answer = '';
let temp = '';
let flag = false;

for (let i = 0; i < s.length; i++) {
  if (s[i] === '<' || flag) {
    flag = true;

    if (temp !== '') {
      temp = [...temp].reverse().join('');
      answer += temp + s[i];
      temp = '';
    } else if (temp === '') {
      answer += s[i];
    };

    if (s[i] === '>') {
      flag = false;
    };

    continue;
  };

  if (s[i] === ' ') {
    answer += [...temp].reverse().join('') + ' ';
    temp = '';
    continue;
  }

  temp += s[i];
};

console.log(answer + [...temp].reverse().join(''));
