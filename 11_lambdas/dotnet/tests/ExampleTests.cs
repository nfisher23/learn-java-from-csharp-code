using System;
using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {


        public string applyThenToString(int param, Func<int, int> delegateOfFunc)
        {
            return delegateOfFunc(param).ToString();
        }

        public int square(int val)
        {
            return val * val;
        }

        [Test]
        public void delegates_fun_longHand()
        {
            Func<int, int> squareDelegate = new Func<int, int>(square);

            string squaredAsString = applyThenToString(4, squareDelegate);

            Assert.AreEqual("16", squaredAsString);
        }

        [Test]
        public void delegates_fun_shorthand()
        {
            string doubledAsString = applyThenToString(4, x => x * x);

            Assert.AreEqual("16", doubledAsString);
        }

        [Test]
        public void closures()
        {
            int someValue = 1;

            Func<int, int> multiplyBySomeValue = v => someValue * v;

            Assert.AreEqual(2, multiplyBySomeValue.Invoke(2));
        }

        [Test]
        public void closures_afterCapture()
        {
            int someValue = 1;

            Func<int, int> multiplyBySomeValue = v => someValue * v;

            someValue = 5; // change value

            Assert.AreEqual(10, multiplyBySomeValue.Invoke(2));
        }

        public Func<int> Incrementor()
        {
            int seedVal = 0;
            return () => ++seedVal;
        }

        [Test]
        public void showIncrementor()
        {
            Func<int> incrementor = Incrementor();
            Assert.AreEqual(1, incrementor());
            Assert.AreEqual(2, incrementor());
            Assert.AreEqual(3, incrementor());
        }

        [Test]
        public void someLinqStuff()
        {
            IList<int> countToFour = new List<int> { 1, 2, 3, 4 };

            IList<int> newCollection =
                        countToFour.Select(n => n * n)
                                    .ToList();

            Assert.AreEqual(4, newCollection[1]);
            Assert.AreNotEqual(newCollection[1], countToFour[1]);
        }

        [Test]
        public void deferredExecution()
        {
            IList<int> countToFour = new List<int> { 1, 2, 3, 4 };

            var enumeratedCount = countToFour.Select(n => n * n);

            countToFour.Add(5); // change the base collection after query declaration

            Assert.AreEqual(5, enumeratedCount.ToList().Count);
        }

        [Test]
        public void conversionOperators()
        {
            IList<int> countToFour = new List<int> { 1, 2, 3, 4 };
            IEnumerable<int> newCollection =
                                countToFour.Select(n => n * n);

            List<int> first = newCollection.Select(n => n * 2).ToList();
            List<int> second = newCollection.Select(n => n).ToList();

            Assert.AreNotEqual(first[2], second[2]);
        }

        [Test]
        public void elvisTest()
        {
            object nullObj = null;

            string stringIfNotNull = nullObj?.ToString();

            Assert.IsNull(stringIfNotNull);
        }
    }
}