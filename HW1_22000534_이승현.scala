// The number of problems solved by myself: 8 out of 8

// Problem 1:
// Solved by myself: Y
// Time taken: 1 min
// [contract] dollarToWon: Int-> Int
// [purpose] To convert dollar to won
// [tests] dollarToWon(1) => 1324)
//           dollarToWon(2) => 2648)
def dollarToWon (dollar : Int): Int = 1324* dollar

// Problem 2:
// Solved by myself: Y
// Time taken: 1 min
// [contract] maxOfThreeIntegers: Int,Int-> Int
// [purpose] To determine maximum number among input 
// [tests] maxOfThreeIntegers(1,3,2) => 3)
//           maxOfThreeIntegers(2,6,9) => 9)
def max(a : Int, b : Int): Int =  a match {
    case x if x > b => x
    case _  => b
}

def maxOfThreeIntegers(a : Int, b : Int, c : Int): Int = a match{
    case x if a > b => max(a,c)
    case _ => max(b,c)
}

// Problem 3:
// Solved by myself: Y
// Time taken: 1 min
// [contract] dollarToWon:Int,Int,Int-> Int
// [purpose] To calculate cuboid
// [tests] volumeCuboid(1,2,3) => 3)
//           volumeCuboid(3,2,1) => 3)

def volumeCuboid(length : Int, breadth : Int, height : Int): Int = length*breadth*height

// Problem 4:
// Solved by myself: Y (I found out the Euclidean algorithm by searching)
// Time taken: 3 min
// [contract] gcd: Int,Int-> Int
// [purpose] To calculate gcd from given two integers
// [tests] gcd(10,5) => 5)
//           gcd(12,30) => 6)

def gcd (a :Int,b:Int):Int = a match{
    case x if b == 0 => a
    case x if a>b => gcd(b,a%b)
    case _ => gcd(a,b)
}

// Problem 5:
// Solved by myself: Y
// Time taken: 3 min
// [contract] combination: Int,Int-> Int
// [purpose] To calculate nCk
// [tests] combination(5,2) => 10)
//           combination(6,3) => 20)


def factorial(n : Int):Int = n match{
    case 1 => 1
    case x if n > 1 => n*factorial(n-1)
}

def combination(n : Int, k : Int):Int = factorial(n)/(factorial(k)*factorial(n-k))


// Problem 6:
// Solved by myself: Y
// Time taken: 5 min
// [contract] vehicleTax: Int-> Int
// [purpose] To calculate tax from given critera
// [tests]vehicleTax(Bicycle(4),4,3,2) => 16)
//           vehicleTax(Bicycle(4),5,3,2) => 20)
// [contract] isVehicleSafe: Int-> Int
// [purpose] To check if given vichle is safe or unsafe
// [tests] isVehicleSafe(Car(3,5)) => unsafe)
//           isVehicleSafe(Car(4,5)) => safe)

trait Vehicle
case class Bicycle(wheels : Int) extends Vehicle
case class Car(wheels : Int, windows : Int) extends Vehicle
case class Airplane(wheels : Int, windows : Int, engines : Int) extends Vehicle

def vehicleTax(v : Vehicle, tpWh : Int,tpWin : Int, tpE : Int ):Int = v match{
    case  Bicycle(wheels) => wheels*tpWh
    case  Car(wheels, windows)  => wheels*tpWh + windows*tpWin
    case  Airplane(wheels, windows, engines) => wheels*tpWh + windows*tpWin + engines*tpE
}


def isVehicleSafe(v : Vehicle):String = v match{
    case  Bicycle(wheels) if wheels < 4 => "safe"
    case  Car(wheels, windows) if wheels > 3 && windows > 2  => "safe"
    case  Airplane(wheels, windows, engines) if wheels > 2 && windows > 10 && engines > 1 => "safe"
    case _ => "unsafe"
}

// Problem 7:
// Solved by myself: Y
// Time taken: 3 min
// [contract] nameAlphabet: List[String]-> List[String]
// [purpose] To transform a designated character into another character from given list
// [tests]  nameAlphabet(List("b","a","c")) => List(unnamed, alice, cherry))
//          nameAlphabet(List("k","a","c")) => List(kate, alice, cherry))

def nameAlphabet (l : List[String]):List[String] = l.map(
    _ match{
        case "a" => "alice"
        case "c" => "cherry"
        case "j" => "jc"
        case "k" => "kate"
        case _ => "unnamed"
    }
)

// Problem 1:
// Solved by myself: Y
// Time taken: 5 min
// [contract] dollarToWon: Int-> Int
// [purpose] To transform a designated old string into new string from given list
// [tests] updateName("cherry", "claire", List("jc", "cherry", "kate")) => List(jc, claire, kate))
//          updateName("cherry", "hi", List("cherry", "hi", "kate")) => List(hi, hi, kate))

def updateName (old : String,nw : String,l : List[String]):List[String] = l.map(
    _ match{
        case x if x == old => nw
        case x => x
    }
)


@main def runAreaCalculator(): Unit = {

    //test case 1
    println(dollarToWon(1))
    println(maxOfThreeIntegers(5,10,-4))
    println(volumeCuboid(1,2,3))
    println(gcd(10,5))
    println(combination(5,2))
    println(vehicleTax(Bicycle(4),4,3,2))
    println(isVehicleSafe(Car(3,5)))
    println(nameAlphabet(List("b","a","c")))
    println(updateName("cherry", "claire", List("jc", "cherry", "kate")))
    //test case 2
    println(dollarToWon(2))
    println(maxOfThreeIntegers(2,6,9))
     println(volumeCuboid(3,2,1))
    println(gcd(12,30))
    println(combination(6,3))
    println(vehicleTax(Bicycle(4),5,3,2))
    println(isVehicleSafe(Car(4,5)))
    println(nameAlphabet(List("k","a","c")))
    println(updateName("cherry", "hi", List("cherry", "hi", "kate")))
}
