module HalfAdder (
    input a,
    input b,
    output s,
    output cout,
);

    assign s = a ^ b;
    assign cout = a & b;
    
endmodule
