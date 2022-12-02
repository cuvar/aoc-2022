type Shapes = "ROCK" | "PAPER" | "SCISSORS";
type FirstLetter = "A" | "B" | "C";
type SecondLetter = "X" | "Y" | "Z";

enum PointsState {
  LOST = 0,
  DRAW = 3,
  WON = 6,
}

const shapesFirst: Record<FirstLetter, Shapes> = {
  A: "ROCK",
  B: "PAPER",
  C: "SCISSORS",
};

const shapesSecond: Record<SecondLetter, Shapes> = {
  X: "ROCK",
  Y: "PAPER",
  Z: "SCISSORS",
};

const shapePoints: Record<Shapes, number> = {
  ROCK: 1,
  PAPER: 2,
  SCISSORS: 3,
};

const filename = "input.txt";
const input = Deno.readTextFileSync(filename);

const lines = input.split("\n");

let totalPoints = 0;

// map to rock paper scissors
function isValidFirstLetter(letter: string): letter is FirstLetter {
  return letter === "A" || letter === "B" || letter === "C";
}
function isValidSecondLetter(letter: string): letter is SecondLetter {
  return letter === "X" || letter === "Y" || letter === "Z";
}

lines.forEach((line) => {
  const [firstLetter, secondLetter] = line.split(" ");

  if (!isValidFirstLetter(firstLetter) || !isValidSecondLetter(secondLetter)) {
    throw Error("Invalid input");
  }

  const firstLetterShape = shapesFirst[firstLetter];
  const secondLetterShape = shapesSecond[secondLetter];

  totalPoints += shapePoints[secondLetterShape];

  if (firstLetterShape == secondLetterShape) {
    totalPoints += PointsState.DRAW;
    return;
  }

  if (secondLetterShape == "ROCK" && firstLetterShape == "SCISSORS") {
    totalPoints += PointsState.WON;
    return;
  }

  if (secondLetterShape == "PAPER" && firstLetterShape == "ROCK") {
    totalPoints += PointsState.WON;
    return;
  }

  if (secondLetterShape == "SCISSORS" && firstLetterShape == "PAPER") {
    totalPoints += PointsState.WON;
    return;
  }

  totalPoints += PointsState.LOST;
});

console.log(totalPoints);
