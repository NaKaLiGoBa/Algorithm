const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input = [];
let newIntArray = [];
let count = 0;

rl.on('line', (line) => {
	count++;
	if (count == 1) {
		input.push(line.split(" ").map(Number));
	}
	
	if (count == 2) {
		line.split(" ").map(Number).forEach(num => {
			newIntArray.push(inputToNewInt(num));
		})
		rl.close();
	}
});

rl.on('close', () => {
	let targetPosition = input[0][1];
	
	newIntArray.sort(function(a, b) {
		if (a[1] < b[1]) return 1;
		if (a[1] > b[1]) return -1;
		return (a[0] <= b[0]) ? 1:-1;
	})
	console.log(newIntArray[targetPosition-1][0]);
})

function inputToNewInt(inputInt) {
	let newIntElement = [];	
	let tempInputInt = inputInt;
	let bitCount = 0;
	
	while (tempInputInt != 0) {
		bitCount += tempInputInt % 2;
		tempInputInt = Math.floor(tempInputInt / 2);
	}
	
	newIntElement.push(inputInt);
	newIntElement.push(bitCount);
	
	return newIntElement;
}
