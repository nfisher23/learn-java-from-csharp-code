namespace tests
{
    public class MyTuple<T>
    {
        public static string staticVal;

        public readonly T first;
        public readonly T second;

        public MyTuple(T _first, T _second)
        {
            this.first = _first;
            this.second = _second;
        }
    }
}