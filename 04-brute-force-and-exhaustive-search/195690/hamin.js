// Run by Node.js
const readline = require('readline');

(async () => {
  let rl = readline.createInterface({ input: process.stdin });
  let N;
  let bandageCnt, medicineCnt, painkillerCnt = 0;
  const [bandage, medicine, painkiller,] = [1, 7, 14];

  for await (const line of rl) {
    N = Number(line);

    rl.close();
  }

  painkillerCnt = Math.floor(N / painkiller);
  N %= painkiller;

  medicineCnt = Math.floor(N / medicine);
  N %= medicine;

  bandageCnt = Math.floor(N / bandage);
  N %= bandage;

  console.log(painkillerCnt + medicineCnt + bandageCnt);

  process.exit();
})();
