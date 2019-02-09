using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void CSharpHasUnifiedTypes() {
            int valueAsInt = 10;
            string valueAsString = valueAsInt.ToString();
            Assert.AreEqual("10", valueAsString);
        }

        [Test]
        public void nullableInt() {
            int? canBeNull = 40;

            canBeNull = null;

            Assert.IsNull(canBeNull);
        }
    }
}