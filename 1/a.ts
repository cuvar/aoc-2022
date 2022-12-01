const filename = "input.txt";
const input = Deno.readTextFileSync(filename);

const lines = input.split("\n");

const calories: number[][] = [];
let j = 0;

calories[j] = [];
for (let i = 0; i < lines.length; i++) {
  if (lines[i] === "") {
    j++;
    calories[j] = [];
    continue;
  }
  calories[j].push(parseInt(lines[i]) ?? -1);
}

console.log(calories.length);

const sums = calories.map((c: number[]) => {
  return c.reduce((a, b) => a + b, 0);
});

// get max in array
const max = Math.max(...sums);

console.log(max);
