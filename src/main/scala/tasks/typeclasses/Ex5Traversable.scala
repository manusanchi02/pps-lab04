package tasks.typeclasses

import u03.Sequences.*
import Sequence.*
import u03.extensionmethods.Optionals.Optional
import u03.extensionmethods.Optionals.Optional.Just

/*  Exercise 5: 
 *  - Generalise by ad-hoc polymorphism logAll, such that:
 *  -- it can be called on Sequences but also on Optional, or others... 
 *  -- it does not necessarily call log, but any function with analogous type
 *  - Hint: introduce a type class Traversable[T[_]]], capturing the ability of calling a
 *    "consumer function" on all elements (with type A) of a datastructure T[A] 
 *    Note Traversable is a 2-kinded trait (similar to Filterable, or Monad)
 *  - Write givens for Traversable[Optional] and Traversable[Sequence]
 *  - Show you can use the generalisation of logAll to:
 *  -- log all elements of an Optional, or of a Traversable
 *  -- println(_) all elements of an Optional, or of a Traversable
 */

object Ex5Traversable:

  trait Traversable[T[_]]:
    def forEach[A](t: T[A])(f: A => Unit): Unit

  given Traversable[Sequence] with
    def forEach[A](seq: Sequence[A])(f: A => Unit): Unit = seq match
      case Cons(h, t) => f(h); forEach(t)(f)
      case _ => ()

  given Traversable[Optional] with
    def forEach[A](opt: Optional[A])(f: A=> Unit): Unit = opt match
      case Just(a) => f(a)
      case _ => ()

  private def log[A](a: A): Unit = println("The next element is: "+a)

  def logAll[T[_]: Traversable, A](t: T[A]): Unit =
    summon[Traversable[T]].forEach(t)(log)

  
