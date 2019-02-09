using System.Collections.Generic;
using NUnit.Framework;

namespace Tests
{
    public class Tests
    {
        [Test]
        public void importingEx() 
        {
            // available after declaring "using System.Collections.Generic;"
            IList<int> someList = new List<int>();
        }
    }
}