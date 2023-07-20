const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

class Queue {
  constructor() {
    this.queue = [];
    this.front = 0;
    this.rear = 0;
  }

  enqueue(value) {
    this.queue[this.rear++] = value;
  }

  dequeue() {
    const value = this.queue[this.front];
    delete this.queue[this.front];
    this.front += 1;
    return value;
  }

  peek() {
    return this.queue[this.front];
  }

  size() {
    return this.rear - this.front;
  }
};

let [_, ...arr] = input;
arr = arr.map((item) => item.split(' ').map(Number));

for (let i = 0; i < arr.length; i += 2) {
  const queue = new Queue();

  let cnt = 0;
  let printArr = arr[i + 1];
  let location = arr[i][1];

  printArr.forEach((element, idx) =>
    queue.enqueue([element, idx])
  );

  printArr.sort((a, b) => b - a);

  while (queue.size() > 0) {
    let currentValue = queue.peek();

    if (currentValue[0] < printArr[cnt]) {
      queue.enqueue(queue.dequeue());
    } else {
      const value = queue.dequeue();
      cnt += 1;

      if (location === value[1]) {
        console.log(cnt);
        break;
      }
    }
  }
};