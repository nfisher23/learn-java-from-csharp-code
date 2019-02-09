namespace tests
{
    public class OtherConstructors
    {
        public string SomeString { get; }

        public OtherConstructors() : this("default value")
        {}

        public OtherConstructors(string _someString)
        {
            SomeString = _someString;
        }
    }
}