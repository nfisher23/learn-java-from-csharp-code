using NUnit.Framework;
using tests;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void testTuple() // this test passes
        {
            MyTuple<int> intTuple1 = new MyTuple<int>(1, 2);
            MyTuple<int> intTuple2 = new MyTuple<int>(1, 2);
            MyTuple<string> stringTuple = new MyTuple<string>("first", "second");

            Assert.AreNotEqual(intTuple1.GetType(), stringTuple.GetType());
            Assert.AreEqual(intTuple1.GetType(), intTuple2.GetType());
        }

        [Test]
        public void testStaticFields()
        {
            MyTuple<int> intTuple = new MyTuple<int>(1, 2);
            MyTuple<int>.staticVal = "int tuple val";
            MyTuple<string>.staticVal = "string tuple val";

            Assert.AreNotEqual(MyTuple<int>.staticVal, MyTuple<string>.staticVal);
        }
    }
}