type Shapes = "ROCK" | "PAPER" | "SCISSORS";
type FirstLetter = "A" | "B" | "C";
type SecondLetter = "X" | "Y" | "Z";
type Outcome = "WON" | "LOST" | "DRAW";

const pointsState: Record<Outcome, number> = {
  LOST: 0,
  DRAW: 3,
  WON: 6,
};

const expectedOutcome: Record<SecondLetter, Outcome> = {
  X: "LOST",
  Y: "DRAW",
  Z: "WON",
};

const shapesFirst: Record<FirstLetter, Shapes> = {
  A: "ROCK",
  B: "PAPER",
  C: "SCISSORS",
};

// const shapesSecond: Record<SecondLetter, Shapes> = {
//   X: "ROCK",
//   Y: "PAPER",
//   Z: "SCISSORS",
// };

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
  const currentExpectedOutcome = expectedOutcome[secondLetter];

  totalPoints += pointsState[currentExpectedOutcome];

  if (currentExpectedOutcome === "WON") {
    if (firstLetterShape === "SCISSORS") {
      totalPoints += shapePoints.ROCK;
      return;
    }

    if (firstLetterShape === "ROCK") {
      totalPoints += shapePoints.PAPER;
      return;
    }

    if (firstLetterShape === "PAPER") {
      totalPoints += shapePoints.SCISSORS;
      return;
    }
  }

  if (currentExpectedOutcome === "LOST") {
    if (firstLetterShape === "ROCK") {
      totalPoints += shapePoints.SCISSORS;
      return;
    }

    if (firstLetterShape === "PAPER") {
      totalPoints += shapePoints.ROCK;
      return;
    }

    if (firstLetterShape === "SCISSORS") {
      totalPoints += shapePoints.PAPER;
      return;
    }
  }

  if (currentExpectedOutcome === "DRAW") {
    totalPoints += shapePoints[firstLetterShape];
    return;
  }
});

console.log(totalPoints);
