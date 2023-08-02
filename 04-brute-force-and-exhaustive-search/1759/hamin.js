const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [L, C] = input.shift().split(' ').map(Number);
const map = input.join('').split(' ');
const vowel = ['a', 'e', 'i', 'u', 'o'];

function solution(l, c, arr) {

  const dfs = (s) => {
    if (s.length === l) {
      let [vowelCount, consonantCount] = [0, 0];

      for (const m of s) {
        if (vowel.includes(m)) {
          vowelCount += 1;
        } else {
          consonantCount += 1;
        };
      };

      if (vowelCount >= 1 && consonantCount >= 2) {
        return console.log(s.join(""));
      };

      return;
    };

    for (const alphabet of arr) {
      if (alphabet > s[s.length - 1]) {
        s.push(alphabet);
        dfs(s);
        s.pop();
      };
    };
  };

  arr.sort();

  for (let i = 0; i < c - l + 1; i++) {
    dfs([arr[i]]);
  };
};

solution(L, C, map);
