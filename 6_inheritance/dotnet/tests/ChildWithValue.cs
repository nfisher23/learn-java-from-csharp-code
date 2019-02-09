namespace tests
{
    class ChildWithValue : ParentWithValue
    {
        public string Value { get; set; } = "default child";
    }

    class ParentWithValue
    {
        public string Value { get; set; } = "default parent";
    }
}