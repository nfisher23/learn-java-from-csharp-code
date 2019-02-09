using NUnit.Framework;

namespace tests
{
    public class ExampleTests
    {
        [Test]
        public void objectOrderInit()
        {
            ParentWithValue pair = new ChildWithValue();

            Assert.AreEqual("default parent", pair.Value);
        }
    }
}