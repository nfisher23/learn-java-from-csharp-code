namespace tests
{
    public interface IBasicInterface
    {
        object SomeMethod();
    }

    public class BasicImplemented : IBasicInterface
    {
        object IBasicInterface.SomeMethod() {
            return this.SomeMethod();
        }
        public string SomeMethod()
        {
            return "some method returned";
        }
    }
}