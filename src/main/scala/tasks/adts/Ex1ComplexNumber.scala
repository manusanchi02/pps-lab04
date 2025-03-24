package tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  private case class ComplexType(re: Double, im: Double)

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:


    // Change assignment below: should probably define a case class and use it?
    opaque type Complex = ComplexType
    def complex(re: Double, im: Double): Complex = ComplexType(re, im)
    extension (complex: Complex)
      def re(): Double = complex.re
      def im(): Double = complex.im
      def sum(other: Complex): Complex = ComplexType(complex.re + other.re, complex.im + other.im)
      def subtract(other: Complex): Complex = complex.sum(ComplexType(-other.re, -other.im))
      def asString(): String = complex.re.toString + {
        if (complex.im >= 0) then " + " else " - "
      } + complex.im.toString + { if (complex.im != 0) then "i" else " "}
