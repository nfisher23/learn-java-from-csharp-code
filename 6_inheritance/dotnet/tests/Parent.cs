namespace tests
{
    public class Grandparent
    {
        public virtual void ChangeMember() 
        {

        }
    }

    public class Parent : Grandparent
    {
        public override void ChangeMember()
        {
            base.ChangeMember();
        }
    }
}