package io.mediachain

import org.specs2.matcher.Matcher
import org.specs2.execute.{Failure, Result}
import org.specs2.matcher.*

trait XorMatchers {
  type Xor[+A, +B] = Either[A, B]

  def beRightXor[T](checker: T => Result): Matcher[Xor[?, T]] =
    (x: Xor[?, T]) =>
      x match {
        case Right(value) =>
          checker(value)
        case x            =>
          Failure(s"Xor value was instance of Xor.Left: $x")
      }

  def beRightXor: Matcher[Xor[?, ?]] = { (x: Xor[?, ?]) =>
    (x.isRight, s"Xor value was instance of Xor.Left: $x")
  }

  def beLeftXor[T](checker: T => Result): Matcher[Xor[T, ?]] =
    (x: Xor[T, ?]) =>
      x match {
        case Left(value) =>
          checker(value)
        case _           =>
          Failure(s"Xor value was instance of Xor.Right: $x")
      }

  def beLeftXor: Matcher[Xor[?, ?]] = (x: Xor[?, ?]) => (x.isLeft, s"Xor value was instance of Xor.Right: $x")
}
