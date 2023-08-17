const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let count = 0;
let ingredients = [];
let isGoingUp = true;
let prev = 0;
let answer = 0;


rl.on('line', function (line) {
  count++;
  if (count === 2) {
    ingredients = line.split(' ').map(Number);
	}
}).on('close', function () {
 
	// solution
	for (let ingredient of ingredients) {
		if (isGoingUp) {
			if (ingredient >= prev) {
				prev = ingredient;
				answer += ingredient;
				continue;
			} else isGoingUp = false;
		}
		
		if (!isGoingUp) {
			if (ingredient <= prev) {
				prev = ingredient;
				answer += ingredient;
			} else {
				answer = 0;
				break;
			}
		}
	}
	console.log(answer);

  process.exit();
});
