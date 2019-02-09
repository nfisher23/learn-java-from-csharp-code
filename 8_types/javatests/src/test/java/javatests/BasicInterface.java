package javatests;

interface BasicInterface {
    Object SomeMethod();
    default String newMethod() { return "default string"; }
    double SOME_CONSTANT = 1001;
}
