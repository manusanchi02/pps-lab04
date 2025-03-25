package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Sequences.Sequence.{Cons, nil}

class SchoolModelTest:
  // Choice of implementation to test
  val schoolADT: SchoolModule = BasicSchoolModule

  import schoolADT.*

  @Test def testCourses() =
    assertEquals(Cons("Math", nil()), emptySchool.setTeacherToCourse(teacher("John"), course("Math")).courses)

  @Test def testTeachers() =
    assertEquals(nil(), emptySchool.teachers)
    assertEquals(Cons("John", nil()), emptySchool.setTeacherToCourse(teacher("John"), course("Math")).teachers)

  @Test def testCoursesOfATeacher() =
    assertEquals(nil(), emptySchool.coursesOfATeacher(teacher("John")))
    assertEquals(Cons("Math", nil()), emptySchool.setTeacherToCourse(teacher("John"), course("Math")).coursesOfATeacher(teacher("John")))
    assertEquals(Cons("Math", Cons("Italian", nil())), emptySchool.setTeacherToCourse(teacher("John"), course("Math")).setTeacherToCourse(teacher("John"), course("Italian")).coursesOfATeacher(teacher("John")))

  @Test def testHasTeacher() =
    assertFalse(emptySchool.hasTeacher("John"))
    assertTrue(emptySchool.setTeacherToCourse(teacher("John"), course("Math")).hasTeacher("John"))