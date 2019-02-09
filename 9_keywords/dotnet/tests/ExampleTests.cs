using System.Collections.Generic;
using NUnit.Framework;
using tests;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void foreachEx()
        {
            IList<int> numbers = new List<int> { 1, 2, 3, 4 };

            foreach (int number in numbers)
            {
                Assert.IsTrue(number > 0);
            }
        }

        private IList<string> transformToStringList(params int[] ints)
        {
            IList<string> listOfParams = new List<string>();

            foreach (int i in ints)
            {
                listOfParams.Add(i.ToString());
            }

            return listOfParams;
        }

        [Test]
        public void paramsTest()
        {
            IList<string> vals = transformToStringList(1, 2, 3);

            Assert.AreEqual("1", vals[0]);
        }

        [Test]
        public void testIsKeyword()
        {
            object pair = new Placeholder();
            Assert.IsTrue(pair is Placeholder);
        }
    }
}