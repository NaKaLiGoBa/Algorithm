const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input;
let count = 0;
rl.on('line', (line) => {
	input = line;
	count++;
	if (count == 2) rl.close();
});

// === Solution ===
rl.on('close', () => {
	let candidates = [];
	let scoreContainer = [];
	
	for (let i = 0; i < input.length - 2; i++) {
		for (let j = i + 2; j < input.length; j++) {
			let candidate = [];
	
			// only need three words(segmentations)
			candidate.push(input.slice(0, i+1)); 
			candidate.push(input.slice(i+1, j));
			candidate.push(input.slice(j));
			candidates.push(candidate);
			
			// check duplicate for scoring
			for(let c of candidate) {
				if(!scoreContainer.includes(c)) scoreContainer.push(c);
			}
		}
	}
	
	
	// Alphabetically sorting
	scoreContainer.sort();
	
	let maxScore = 0;
	for (let candidate of candidates) {
		
		// Check total score in each candidate and get Max score
		// by comparing pre-max value with current one
		let tempScore = 0;
		for (let c of candidate) {
			tempScore += scoreContainer.indexOf(c) + 1;
			maxScore = Math.max(tempScore, maxScore);
		}
	}
	
	console.log(maxScore);
})
