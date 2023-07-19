const input = require('fs').readFileSync('d.txt').toString().trim().split('');
let stack = [];

if (input[0] === ')' || input[0] === ']') return console.log(0);
if (input[input.length - 1] === '(' || input[input.length - 1] === '[') return 0;

for (let i = 0; i < input.length; i++) {
  if (input[i] === '(' || input[i] === '[') {
    stack.push(input[i]);
  }
  else if (input[i] === ')' || input[i] === ']') {
    let bracket = input[i] === ')' ? '(' : '[';
    let num = bracket === ')' ? 2 : 3;

    if (stack[stack.length - 1] === bracket) {
      stack.pop();
      stack.push(num);

    } else {
      let total = 0;

      while (1) {
        let top = stack.pop();

        if (typeof top === 'number') {
          total += top;
        }

        else if (top === bracket) {
          stack.push(total * num);
          break;
        };
      };
    };
  };
};

console.log(stack.reduce((acc, cur) => acc + cur));
