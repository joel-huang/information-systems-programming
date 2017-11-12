enum Type {
    
    L_PAREN("("),
    R_PAREN(")"),
    INCH("in"),
    POINT("pt"),
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    NUMBER(""),
    EPSILON("");

    private String s;

    Type(String s) {
        this.s = s;
    }

    String getS() {
        return this.s;
    }
}