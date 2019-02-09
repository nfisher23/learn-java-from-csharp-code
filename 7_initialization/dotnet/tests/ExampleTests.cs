using NUnit.Framework;
using tests;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void testingObjInit()
        {
            SimplePair pair = new SimplePair
                {
                    Key = 1,
                    Value = "first"
                };

            Assert.AreEqual("first", pair.Value);
        }

        [Test]
        public void testingConstructorCalls() 
        {
            OtherConstructors otherConstructors = new OtherConstructors();
            Assert.AreEqual("default value", otherConstructors.SomeString);
        }
    }
}