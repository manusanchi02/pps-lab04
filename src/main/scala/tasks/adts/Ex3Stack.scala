package tasks.adts

/*import u03.Sequences.Sequence
import Sequence.map*/
import u03.Optionals.*
import u03.extensionmethods.Sequences.Sequence
import u03.extensionmethods.Sequences.Sequence.*



/*  Exercise 3: 
 *  Implement a Stack ADT
 *  Suggestion: 
 *  - push adds an element and returns the new stack
 *  - pop returns:
 *  -- empty optional is stack is empty
 *  -- a pair of top of the stack and the new stack after removal if not empty
 */
object Ex3Stacks:

  private case class StackType(s: Sequence[Int])

  trait StackADT:
    type Stack[A]
    def empty[A]: Stack[A] // factory
    extension [A](stack: Stack[A])
      def push(a: A): Stack[A]
      def pop(): Optional[(A, Stack[A])]
      def asSequence(): Sequence[A]

  object StackImpl extends StackADT:
    opaque type Stack[A] = StackType
    def empty[A]: Stack[A] = StackType(nil())
    extension [A](stack: Stack[A])
      def push(a: A): Stack[A] = StackType(cons(a.asInstanceOf[Int], stack.s))
      def pop(): Optional[(A, Stack[A])] = ???
      def asSequence(): Sequence[A] = stack.s.map(a => a.asInstanceOf[A])