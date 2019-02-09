package javatests;

enum RestMethod {
    GET(true),
    POST(false),
    PATCH(false),
    PUT(false),
    DELETE(false);

    RestMethod(boolean readOnly) {
        this.readOnly = readOnly;
    }

    private final boolean readOnly;

    public boolean isReadOnly() {
        return readOnly;
    }
}
